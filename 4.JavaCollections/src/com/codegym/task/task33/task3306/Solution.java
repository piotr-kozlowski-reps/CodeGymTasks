package com.codegym.task.task33.task3306;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringWriter;

/* 
My first serialization into XML

*/

public class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        Cat cat = new Cat();
        cat.name = "Missy";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jefferson";

        StringWriter writer = new StringWriter();
        convertToXml(writer, cat);
        convertToXml(writer, dog);
        System.out.println(writer.toString());
        /* Expected output:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cat>
    <name>Missy</name>
    <age>5</age>
    <weight>3</weight>
</cat>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<dog>
    <name>Killer</name>
    <age>8</age>
    <owner>Bill Jefferson</owner>
</dog>
        */
    }

    public static void convertToXml(StringWriter writer, Object obj) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
    }

    public static class Pet {
        public String name;
    }


    @XmlRootElement
    @XmlType(name = "cat")
    public static class Cat extends Pet {
        public int age;
        public int weight;
    }


    @XmlRootElement
    @XmlType(name = "dog")
    public static class Dog extends Pet {
        public int age;
        public String owner;
    }
}

//My first serialization into XML
//Correctly arrange JAXB annotations on the static classes.
//
//
//Requirements:
//1. The Cat class must be annotated with @XmlRootElement.
//2. The Cat class must be annotated with @XmlType with name = "cat".
//3. The Dog class must be annotated with @XmlRootElement.
//4. The Dog class must be annotated with @XmlType with name = "dog".