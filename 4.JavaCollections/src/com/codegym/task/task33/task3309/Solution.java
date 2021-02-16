package com.codegym.task.task33.task3309;

/* 
Comments inside XML

*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {

        String result = null;
        StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, stringWriter);

        String temporaryXML = stringWriter.toString();
        if (temporaryXML.indexOf(tagName) > -1) {
            result = temporaryXML.replace("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
        } else {
            result = temporaryXML;
        }


        return result;
    }

    public static void main(String[] args) throws JAXBException{

        FirstSecondObject first = new FirstSecondObject();
        System.out.println(toXmlWithComment(first, "second", "This is a comment"));

    }

    @XmlType(name = "first")
    @XmlRootElement
    public static class FirstSecondObject {

        public String[] second = new String[]{"some string", "some string", "[CDATA[need CDATA because of < and >]]"};

        public FirstSecondObject(){}

    }

}

//Comments inside XML
//Implement the toXmlWithComment method, which should return an XML-string representation of the obj object.
//A comment should be added in the line before each tagName tag.
//The XML serialization of obj may contain CDATA sections with the specified tag. Don't add comments before them.
//
//Example method call:
//toXmlWithComment(firstSecondObject, "second", "This is a comment")
//
//Example result:
//<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//<first>
//<!--This is a comment-->
//<second>some string</second>
//<!--This is a comment-->
//<second>some string</second>
//<!--This is a comment-->
//<second><![CDATA[need CDATA because of < and >]]></second>
//<!--This is a comment-->
//<second/>
//</first><div></div>


//3. If the input XML string does not have the specified tag, then don't add comments.
//4. The number of comments added to the XML must be equal to the number of tagName tags.
//5. The toXmlWithComment method should return an XML-string that has been converted in accordance with the task conditions.
