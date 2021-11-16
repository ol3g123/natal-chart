package com.natalChart;

public class NatalChartRequest {
   private String name;
   private String address;
   private Double latitude;
   private Double longitude;
   private String dateOfBrith;
   private String timeOfBirth;

   public NatalChartRequest() {
   }

   public NatalChartRequest(String name, String address, double latitude, double longitude, String dateOfBrith, String timeOfBirth) {
      this.name = name;
      this.address = address;
      this.latitude = latitude;
      this.longitude = longitude;
      this.dateOfBrith = dateOfBrith;
      this.timeOfBirth = timeOfBirth;
   }
   
   private boolean isEmpty(String str) {
      return str == null || str.isEmpty();
   }

   public boolean isEmpty() {
      return isEmpty(name) && isEmpty(address) && latitude == null && longitude == null && isEmpty(dateOfBrith) && isEmpty(timeOfBirth);
   }
   
   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public NatalChartRequest withName(String name) {
      this.name = name;
      return this;
   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public NatalChartRequest withAddress(String address) {
      this.address = address;
      return this;
   }

   public Double getLatitude() {
      return this.latitude;
   }

   public void setLatitude(Double latitude) {
      this.latitude = latitude;
   }

   public NatalChartRequest withLatitude(Double latitude) {
      this.latitude = latitude;
      return this;
   }

   public Double getLongitude() {
      return this.longitude;
   }

   public void setLongitude(Double longitude) {
      this.longitude = longitude;
   }

   public NatalChartRequest withLongitude(Double longitude) {
      this.longitude = longitude;
      return this;
   }

   public String getDateOfBrith() {
      return this.dateOfBrith;
   }

   public void setDateOfBrith(String dateOfBrith) {
      this.dateOfBrith = dateOfBrith;
   }

   public NatalChartRequest withDateOfBrith(String dateOfBrith) {
      this.dateOfBrith = dateOfBrith;
      return this;
   }

   public String getTimeOfBirth() {
      return this.timeOfBirth;
   }

   public void setTimeOfBirth(String timeOfBirth) {
      this.timeOfBirth = timeOfBirth;
   }

   public NatalChartRequest withTimeOfBirth(String timeOfBirth) {
      this.timeOfBirth = timeOfBirth;
      return this;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(NatalChartRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
      sb.append("name");
      sb.append('=');
      sb.append(this.name == null ? "<null>" : this.name);
      sb.append(',');
      sb.append("address");
      sb.append('=');
      sb.append(this.address == null ? "<null>" : this.address);
      sb.append(',');
      sb.append("latitude");
      sb.append('=');
      sb.append(this.latitude == null ? "<null>" : this.name);
      sb.append(',');
      sb.append("longitude");
      sb.append('=');
      sb.append(this.longitude == null ? "<null>" : this.name);
      sb.append(',');
      sb.append("dateOfBrith");
      sb.append('=');
      sb.append(this.dateOfBrith == null ? "<null>" : this.dateOfBrith);
      sb.append(',');
      sb.append("timeOfBirth");
      sb.append('=');
      sb.append(this.timeOfBirth == null ? "<null>" : this.timeOfBirth);
      sb.append(',');
      if (sb.charAt(sb.length() - 1) == ',') {
         sb.setCharAt(sb.length() - 1, ']');
      } else {
         sb.append(']');
      }

      return sb.toString();
   }
}