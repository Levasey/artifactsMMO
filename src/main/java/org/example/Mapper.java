package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.*;

public class Mapper {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static UniteState getUniteStataAfterAction(String actionRes) {
        TypeReference<ActionResponse> typeReference = new TypeReference<ActionResponse>() {
        };
        try {
            return Mapper.mapper.readValue(actionRes, typeReference).data.character;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static CooldownState getCooldownState(String response) {
        TypeReference<ActionResponse> typeReference = new TypeReference<ActionResponse>() {
        };
        try {
            return Mapper.mapper.readValue(response, typeReference).data.cooldown;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static UniteState getCharacter(String response) {
        TypeReference<GetCharacterResponse> typeReference = new TypeReference<GetCharacterResponse>() {
        };
        try {
            return Mapper.mapper.readValue(response, typeReference).data;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static GeState getGe(String response) {
        TypeReference<GetGeData> typeReference = new TypeReference<GetGeData>() {
        };
        try {
            return Mapper.mapper.readValue(response, typeReference).data;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
