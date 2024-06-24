package com.braldo.Pokerest.controller;

import com.braldo.Pokerest.model.Ability;
import com.braldo.Pokerest.model.HeldItem;
import com.braldo.Pokerest.model.Pokemon;
import com.braldo.Pokerest.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getPokemon(name);
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
