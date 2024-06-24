package com.braldo.Pokerest.controller;

import com.braldo.Pokerest.model.Ability;
import com.braldo.Pokerest.model.HeldItem;
import com.braldo.Pokerest.model.Pokemon;
import com.braldo.Pokerest.service.PokemonService;
import com.braldo.Pokerest.wsdl.GetPokemonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/pokemon";

    @Autowired
    private PokemonService pokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public Pokemon getPokemon(@RequestPayload GetPokemonRequest request) {
        Pokemon pokemon = pokemonService.getPokemon(request.getName());
        printPokemonDetails(pokemon);
        return pokemon;
    }

    private void printPokemonDetails(Pokemon pokemon) {
        System.out.println("ID: " + pokemon.getId());
        System.out.println("Name: " + pokemon.getName());
        System.out.println("Base Experience: " + pokemon.getBaseExperience());
        System.out.println("Abilities:");
        for (Ability ability : pokemon.getAbilities()) {
            System.out.println(" - " + ability.getAbility().getName());
        }
        System.out.println("Held Items:");
        for (HeldItem heldItem : pokemon.getHeldItems()) {
            System.out.println(" - " + heldItem.getItem().getName());
        }
        System.out.println("Location Area Encounters:");
        for (String encounter : pokemon.getLocationAreaEncounters()) {
            System.out.println(" - " + encounter);
        }
    }
}
