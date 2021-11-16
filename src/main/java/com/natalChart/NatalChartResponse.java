package com.natalChart;

import java.util.ArrayList;
import java.util.List;

public class NatalChartResponse {
   private Planets planets;
   private List<Double> cusps = new ArrayList();
   private String error;

   public Planets getPlanets() {
      return this.planets;
   }

   public NatalChartResponse setPlanets(Planets planets) {
      this.planets = planets;
      return this;
   }

   public List<Double> getCusps() {
      return this.cusps;
   }

   public NatalChartResponse setCusps(List<Double> cusps) {
      this.cusps = cusps;
      return this;
   }
   
   public String getError() {
      return this.error;
   }
   
   public NatalChartResponse setError(String error) {
      this.error = error;
      return this;
   }
}
