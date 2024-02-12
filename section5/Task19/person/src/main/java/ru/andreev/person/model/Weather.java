package ru.andreev.person.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {
    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("feels_like")
    private double feelsLikeTemperature;

    @JsonProperty("temp_min")
    private double minTemperature;

    @JsonProperty("temp_max")
    private double maxTemperature;

    private int pressure;

    private int humidity;
}
