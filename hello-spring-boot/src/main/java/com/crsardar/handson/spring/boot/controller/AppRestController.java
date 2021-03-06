package com.crsardar.handson.spring.boot.controller;


import com.crsardar.handson.spring.boot.model.Person;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController
{
    /*
    Content Negotiation : In request Headers add "Accept" = "application/json" OR "application/xml"
    */
    @RequestMapping(value = "person", method = RequestMethod.GET)
    public Person getPerson()
    {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Ohmkar");
        person.setLastName("Shiva");
        person.setVillage("Kailash");
        person.setCountry("India");

        return person;
    }

    @RequestMapping(value = "person-xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public Person getPersonXML()
    {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Ohmkar");
        person.setLastName("Shiva");
        person.setVillage("Kailash");
        person.setCountry("India");

        return person;
    }

    @RequestMapping(value = "person-json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonJSON()
    {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Ohmkar");
        person.setLastName("Shiva");
        person.setVillage("Kailash");
        person.setCountry("India");

        return person;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test()
    {
        return "/hello-spring-boot: Is Up & Running!";
    }
}
