package com.braldo.Pokerest.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getPokemonRequest", namespace = "http://example.com/pokemon")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPokemonRequest {

    @XmlElement(namespace = "http://example.com/pokemon")
    private String name;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
