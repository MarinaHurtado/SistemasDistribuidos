/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braille;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sdist
 */
public class Braille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String country = "Canada";
        String cities = getCitiesByCountry(country);
        //System.out.println(cities);
        Document doc = braille.Parser.getDocumentToBeParsed(cities);
        String ciudades = "";
        NodeList nList = doc.getElementsByTagName("Table");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
//                System.out.println(eElement.getElementsByTagName("City").item(0).getTextContent());
                ciudades += eElement.getElementsByTagName("City").item(0).getTextContent();
                ciudades += "\n";
            }
        }
        //System.out.println(ciudades);
        ///////////////////////
        
        String airpts = getAirportInformationByCountry(country);
        //System.out.println(airpts);
        doc = braille.Parser.getDocumentToBeParsed(airpts);
        String aeropuertos = "";
        nList = doc.getElementsByTagName("Table");
        for (int temp = 0; temp < nList.getLength(); temp+=2) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                //System.out.println(eElement.getElementsByTagName("AirportCode").item(0).getTextContent());
                aeropuertos += eElement.getElementsByTagName("AirportCode").item(0).getTextContent();
                aeropuertos += "\n";
            }
        }
        //System.out.println(aeropuertos);
        
        ///////////////////////
        
        String currency = getCurrencyByCountry(country);
        //System.out.println(currency);
        
        doc = braille.Parser.getDocumentToBeParsed(currency);
        String moneda = "";
        nList = doc.getElementsByTagName("Table");
        for (int temp = 0; temp < nList.getLength(); temp+=2) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                //System.out.println(eElement.getElementsByTagName("AirportCode").item(0).getTextContent());
                moneda += eElement.getElementsByTagName("Currency").item(0).getTextContent();
                moneda += "\n";
            }
        }
        System.out.println(moneda);
        
        /////////////////////
        String texto = ciudades + moneda + aeropuertos;
        byte[] arr = brailleText(texto, 12);
        braille.Parser.convertBytesToImage("ImgBraille", arr);
    }

    private static String getCitiesByCountry(java.lang.String countryName) {
        weather.GlobalWeather service = new weather.GlobalWeather();
        weather.GlobalWeatherSoap port = service.getGlobalWeatherSoap();
        return port.getCitiesByCountry(countryName);
    }

    private static String getAirportInformationByCountry(java.lang.String country) {
        webservices.Airport service = new webservices.Airport();
        webservices.AirportSoap port = service.getAirportSoap();
        return port.getAirportInformationByCountry(country);
    }

    private static String getCurrencyByCountry(java.lang.String countryName) {
        NuevoCountry.Country service = new NuevoCountry.Country();
        NuevoCountry.CountrySoap port = service.getCountrySoap();
        return port.getCurrencyByCountry(countryName);
    }

    private static byte[] brailleText(java.lang.String inText, float textFontSize) {
        brailleWS.Braille service = new brailleWS.Braille();
        brailleWS.BrailleSoap port = service.getBrailleSoap();
        return port.brailleText(inText, textFontSize);
    }

    
    
    
    
}
