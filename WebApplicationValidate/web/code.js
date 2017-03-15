/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*function validateForm(){
    var x=document.forms["myForm"]["fname"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;
    }
    return true;
} */

function validateForm(){
    first = document.forms["formNextPage"]["txtFirst"].value;
    last = document.forms["formNextPage"]["txtLast"].value;
    email = document.forms["formNextPage"]["txtMail"].value;
    gen = document.forms["formNextPage"]["genderG"];
    addComm = document.forms["formNextPage"]["comments"].value;
    if(first==null || first==""){
        alert("Falta nombre");
        return false;
    }
    if(last==null || last==""){
        alert("Falta apellido");
        return false;
    }
    if(!validateEmail(email)){
        alert("Email faltante o inválido");
        return false;
    }
    if(!gen[0].checked && !gen[1].checked){
        alert("Género no seleccionado");
        return false;
    }
    if(addComm==null || addComm=="" || addCom==" "){
        alert("Comentarios adicionales faltantes");
        return false;
    }
    return true;
}

function validateEmail(email){
    var re = new RegExp('[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+([.][a-z]+)+');
    return re.test(email);
}

function validateName(name){
    str = document.forms["formNextPage"][name].value;
    newValue = "";
//    len = str.length;
//    for (i=0; i<len; i++){
//        if(isNan(charAt(i)))
//            newValue.concat(charAt(i));
//    }
    alert(newValue);
}

/*
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
*/
