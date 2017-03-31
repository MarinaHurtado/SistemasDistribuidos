/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braille;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author sdist
 */
public class Parser {
    
    public static Document getDocumentToBeParsed(String result){
        try {
            if (result.startsWith("<?xml")){
                result=result.substring(result.indexOf("?>")+2);
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            PrintWriter out = new PrintWriter("xmlfile.txt");
            out.println(result);
            out.close();
            File f = new File("xmlfile.txt");
            return dBuilder.parse(f);
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    
    public static void convertBytesToImage(String filename, byte[] imageInBytes){
        try {
            InputStream in = new ByteArrayInputStream(imageInBytes);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            ImageIO.write(bImageFromConvert, "jpg", new File(filename+".jpg"));
            } catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
