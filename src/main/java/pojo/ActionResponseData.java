package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ActionResponseData {
    public UniteState character;
    public CooldownState cooldown;
}

