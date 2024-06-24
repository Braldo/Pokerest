package com.braldo.Pokerest.service;

import com.braldo.Pokerest.model.Encounter;
import com.braldo.Pokerest.model.Pokemon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Pokemon getPokemon(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);

        // Fetch location area encounters
        if (pokemon != null) {
            String encountersUrl = pokemon.getLocationAreaEncountersUrl();
            try {
                List<Encounter> encounters = fetchEncounters(encountersUrl);
                List<String> encounterNames = encounters.stream()
                        .map(encounter -> encounter.getLocationArea().getName())
                        .collect(Collectors.toList());
                pokemon.setLocationAreaEncounters(encounterNames);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pokemon;
    }

    private List<Encounter> fetchEncounters(String url) throws IOException {
        String json = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(json, new TypeReference<>() {
        });
    }
}
