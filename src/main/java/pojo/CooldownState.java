package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CooldownState {
    public int total_seconds;
    public int remaining_seconds;
    public String started_at;
    public String expiration;
    public String reason;
}
