package com.example.rxjava;

import java.util.List;

public class WeatherData {

  public Coordinates coord;
  public Local sys;
  public List<Weather> weathers;
  public String base;
  public Main main;
  public Wind wind;
  public Rain rain;
  public Cloud clouds;
  public long id;
  public long dt;
  public String name;
  public int cod;

  public static class Coordinates {
    public double lat;
    public double lon;
  }

  public static class Local {
    public String country;
    public long sunrise;
    public long sunset;
  }

  public static class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
  }

  public static class Main {
    public double temp;
    public double pressure;
    public double humidity;
    public double temp_min;
    public double temp_max;
    public double sea_level;
    public double grnd_level;
  }

  public static class Wind {
    public double speed;
    public double deg;
  }

  public static class Rain {
    public int threehourforecast;
  }

  public static class Cloud {
    public int all;
  }
}