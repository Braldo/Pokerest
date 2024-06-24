package com.braldo.Pokerest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    @JsonProperty("base_experience")
    private int baseExperience;
    private List<Ability> abilities;
    @JsonProperty("held_items")
    private List<HeldItem> heldItems;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncountersUrl;

    private List<String> locationAreaEncounters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<HeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    public String getLocationAreaEncountersUrl() {
        return locationAreaEncountersUrl;
    }

    public void setLocationAreaEncountersUrl(String locationAreaEncountersUrl) {
        this.locationAreaEncountersUrl = locationAreaEncountersUrl;
    }

    public List<String> getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(List<String> locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }
}
