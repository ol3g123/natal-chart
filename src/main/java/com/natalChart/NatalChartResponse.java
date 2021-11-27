package com.natalChart;

import java.util.List;
import javax.annotation.Generated;

public class NatalChartResponse {

private Planets planets;
private List<Double> cusps = null;
private String error;

/**
* No args constructor for use in serialization
*
*/
public NatalChartResponse() {
}

/**
*
* @param planets
* @param cusps
*/
public NatalChartResponse(Planets planets, List<Double> cusps) {
super();
this.planets = planets;
this.cusps = cusps;
}

public Planets getPlanets() {
return planets;
}

public void setPlanets(Planets planets) {
this.planets = planets;
}

public NatalChartResponse withPlanets(Planets planets) {
this.planets = planets;
return this;
}

public List<Double> getCusps() {
return cusps;
}

public void setCusps(List<Double> cusps) {
this.cusps = cusps;
}

public NatalChartResponse withCusps(List<Double> cusps) {
this.cusps = cusps;
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(NatalChartResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("planets");
sb.append('=');
sb.append(((this.planets == null)?"<null>":this.planets));
sb.append(',');
sb.append("cusps");
sb.append('=');
sb.append(((this.cusps == null)?"<null>":this.cusps));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

   public String getError() {
      return this.error;
   }
   
   public NatalChartResponse setError(String error) {
      this.error = error;
      return this;
   }

}