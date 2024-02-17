package ru.andreev.person.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {
    @JsonProperty("temp")
    private Double temperature;

    @JsonProperty("feels_like")
    private Double feelsLikeTemperature;

    @JsonProperty("temp_min")
    private Double minTemperature;

    @JsonProperty("temp_max")
    private Double maxTemperature;

    private Integer pressure;

    private Integer humidity;

    @JsonProperty("sea_level")
    private Integer seaLevel;

    @JsonProperty("grnd_level")
    private Integer groundLevel;
}
