package com.natalChart;

import java.util.List;

public class Planets {

 
private List<Double> moon = null;
 
private List<Double> venus = null;
 
private List<Double> jupiter = null;
 
private List<Double> nNode = null;
 
private List<Double> mars = null;
 
private List<Double> lilith = null;
 
private List<Double> saturn = null;
 
private List<Double> chiron = null;
 
private List<Double> uranus = null;
 
private List<Double> sun = null;
 
private List<Double> mercury = null;
 
private List<Double> neptune = null;
 
private List<Double> pluto = null;

/**
* No args constructor for use in serialization
*
*/
public Planets() {
}

/**
*
* @param saturn
* @param nNode
* @param mars
* @param mercury
* @param pluto
* @param jupiter
* @param lilith
* @param sun
* @param moon
* @param venus
* @param uranus
* @param neptune
* @param chiron
*/
public Planets(List<Double> moon, List<Double> venus, List<Double> jupiter, List<Double> nNode, List<Double> mars, List<Double> lilith, List<Double> saturn, List<Double> chiron, List<Double> uranus, List<Double> sun, List<Double> mercury, List<Double> neptune, List<Double> pluto) {
super();
this.moon = moon;
this.venus = venus;
this.jupiter = jupiter;
this.nNode = nNode;
this.mars = mars;
this.lilith = lilith;
this.saturn = saturn;
this.chiron = chiron;
this.uranus = uranus;
this.sun = sun;
this.mercury = mercury;
this.neptune = neptune;
this.pluto = pluto;
}

public List<Double> getMoon() {
return moon;
}

public void setMoon(List<Double> moon) {
this.moon = moon;
}

public Planets withMoon(List<Double> moon) {
this.moon = moon;
return this;
}

public List<Double> getVenus() {
return venus;
}

public void setVenus(List<Double> venus) {
this.venus = venus;
}

public Planets withVenus(List<Double> venus) {
this.venus = venus;
return this;
}

public List<Double> getJupiter() {
return jupiter;
}

public void setJupiter(List<Double> jupiter) {
this.jupiter = jupiter;
}

public Planets withJupiter(List<Double> jupiter) {
this.jupiter = jupiter;
return this;
}

public List<Double> getnNode() {
return nNode;
}

public void setnNode(List<Double> nNode) {
this.nNode = nNode;
}

public Planets withnNode(List<Double> nNode) {
this.nNode = nNode;
return this;
}

public List<Double> getMars() {
return mars;
}

public void setMars(List<Double> mars) {
this.mars = mars;
}

public Planets withMars(List<Double> mars) {
this.mars = mars;
return this;
}

public List<Double> getLilith() {
return lilith;
}

public void setLilith(List<Double> lilith) {
this.lilith = lilith;
}

public Planets withLilith(List<Double> lilith) {
this.lilith = lilith;
return this;
}

public List<Double> getSaturn() {
return saturn;
}

public void setSaturn(List<Double> saturn) {
this.saturn = saturn;
}

public Planets withSaturn(List<Double> saturn) {
this.saturn = saturn;
return this;
}

public List<Double> getChiron() {
return chiron;
}

public void setChiron(List<Double> chiron) {
this.chiron = chiron;
}

public Planets withChiron(List<Double> chiron) {
this.chiron = chiron;
return this;
}

public List<Double> getUranus() {
return uranus;
}

public void setUranus(List<Double> uranus) {
this.uranus = uranus;
}

public Planets withUranus(List<Double> uranus) {
this.uranus = uranus;
return this;
}

public List<Double> getSun() {
return sun;
}

public void setSun(List<Double> sun) {
this.sun = sun;
}

public Planets withSun(List<Double> sun) {
this.sun = sun;
return this;
}

public List<Double> getMercury() {
return mercury;
}

public void setMercury(List<Double> mercury) {
this.mercury = mercury;
}

public Planets withMercury(List<Double> mercury) {
this.mercury = mercury;
return this;
}

public List<Double> getNeptune() {
return neptune;
}

public void setNeptune(List<Double> neptune) {
this.neptune = neptune;
}

public Planets withNeptune(List<Double> neptune) {
this.neptune = neptune;
return this;
}

public List<Double> getPluto() {
return pluto;
}

public void setPluto(List<Double> pluto) {
this.pluto = pluto;
}

public Planets withPluto(List<Double> pluto) {
this.pluto = pluto;
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("Planets ").append('[');
sb.append("moon");
sb.append('=');
sb.append(((this.moon == null)?"<null>":this.moon));
sb.append(',');
sb.append("venus");
sb.append('=');
sb.append(((this.venus == null)?"<null>":this.venus));
sb.append(',');
sb.append("jupiter");
sb.append('=');
sb.append(((this.jupiter == null)?"<null>":this.jupiter));
sb.append(',');
sb.append("nNode");
sb.append('=');
sb.append(((this.nNode == null)?"<null>":this.nNode));
sb.append(',');
sb.append("mars");
sb.append('=');
sb.append(((this.mars == null)?"<null>":this.mars));
sb.append(',');
sb.append("lilith");
sb.append('=');
sb.append(((this.lilith == null)?"<null>":this.lilith));
sb.append(',');
sb.append("saturn");
sb.append('=');
sb.append(((this.saturn == null)?"<null>":this.saturn));
sb.append(',');
sb.append("chiron");
sb.append('=');
sb.append(((this.chiron == null)?"<null>":this.chiron));
sb.append(',');
sb.append("uranus");
sb.append('=');
sb.append(((this.uranus == null)?"<null>":this.uranus));
sb.append(',');
sb.append("sun");
sb.append('=');
sb.append(((this.sun == null)?"<null>":this.sun));
sb.append(',');
sb.append("mercury");
sb.append('=');
sb.append(((this.mercury == null)?"<null>":this.mercury));
sb.append(',');
sb.append("neptune");
sb.append('=');
sb.append(((this.neptune == null)?"<null>":this.neptune));
sb.append(',');
sb.append("pluto");
sb.append('=');
sb.append(((this.pluto == null)?"<null>":this.pluto));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}