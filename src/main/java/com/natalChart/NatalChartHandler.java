package com.natalChart;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Optional;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import cz.kibo.api.astrology.builder.PlanetBuilder;
import cz.kibo.api.astrology.builder.CuspBuilder;
import cz.kibo.api.astrology.domain.Cusp;
import cz.kibo.api.astrology.domain.Planet;

import net.iakovlev.timeshape.TimeZoneEngine;


public class NatalChartHandler implements RequestHandler<Object, NatalChartResponse> {
   private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();

  public NatalChartResponse handleRequest(Object event, Context context) {

    LambdaLogger logger = context.getLogger();
      NatalChartResponse response = new NatalChartResponse();
      String error;
      NatalChartRequest request = null;
      
      logger.log("Input EVENT class: " + event.getClass());
      logger.log("RAW Input EVENT: " + event);
      logger.log("Input EVENT: " + GSON.toJson(event));
      
      if (event instanceof NatalChartRequest) {
          request = (NatalChartRequest) event;
      }
      else if (event instanceof LinkedHashMap) {
         boolean found = false;
         request = GSON.fromJson(GSON.toJson(event).toString(), NatalChartRequest.class);
         if(request == null) {
          Map requestMap = (LinkedHashMap) event;
          for (Object k : requestMap.keySet()) {
              Object v = requestMap.get(k);
              logger.log("key: " + k + "; value: " + v);
              if (k.equals("body")) {
                  request = GSON.fromJson(requestMap.get(k).toString(), NatalChartRequest.class);
                  found = true;
                  break;
              }
          }
          if(!found) {
             error = "Received map does not have body header";
          logger.log(error);
         response.setError(error);
         return response;
          }
         }
      }
      else {
          error = "Received object that is not instance of NatalChartRequest or Map. Object type is " + event.getClass().getName();
          logger.log(error);
         response.setError(error);
         return response;
      }
      
      if(request == null) {
          error = "After gson transformation request is null";
          logger.log(error);
         response.setError(error);
         return response;
      }
      
      processRequest(request, response, logger);
      //response = samplResponse(logger);
      return response;
   }
   
   // engine to convert coordinates to time zone
   private static final TimeZoneEngine engine = TimeZoneEngine.initialize();

   public NatalChartResponse processRequest(NatalChartRequest request, NatalChartResponse response, LambdaLogger logger) {

        if(request == null) {
          String error = "After gson transformation request is null";
          logger.log(error);
         response.setError(error);
         return response;
      }

        Optional<ZoneId> maybeZoneId = engine.query(request.getLatitude(), request.getLongitude());
        logger.log("Latitude: " + request.getLatitude() + "; longitude: " + request.getLongitude() + "; time zone: " + maybeZoneId.get());

        // "dateOfBrith":"1965-04-17","timeOfBirth":"12:00:00"
        //LocalDateTime event = LocalDateTime.of( 2018, 3, 20, 16, 20);
        LocalDateTime event = LocalDateTime.parse(request.getDateOfBrith() + ' ' + request.getTimeOfBirth(), formatter);
        logger.log("Date and time of birth: " + event);
        ZonedDateTime zonedEvent = event.atZone(maybeZoneId.get());
        logger.log("Zoned Date and time of birth: " + zonedEvent);
        ZonedDateTime zonedEventUTC = zonedEvent.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime eventUTC = zonedEventUTC.toLocalDateTime();
        logger.log("Date and UTC time of birth: " + event);

        double GEOALT = 0.0;
        Planet ephemeris = new PlanetBuilder( eventUTC )
							.planets()
                            .topo(request.getLatitude(), request.getLongitude(), GEOALT)
							.build();		
		ephemeris.getPlanets().size();
        logger.log("Planets: " + ephemeris);
        
        Map<String, List<Double>> data = new HashMap<String, List<Double>>();
        
        for (String planet : ephemeris.getPlanets().keySet()) {
            List<Double> values = new ArrayList<Double>();
			values.add(ephemeris.getPlanets().get(planet).get(0)); //longitude
			//values.add(xp[3]); //speed in longitude
			
			data.put( planet, values);
        }
        
        Planets thePlanets = (new Planets())
                .withMoon(data.get("Moon"))
              .withVenus(data.get("Venus"))
              .withJupiter(data.get("Jupiter"))
              .withnNode(data.get("NNode"))
              .withMars(data.get("Mars"))
              .withLilith(data.get("Lilith"))
              .withSaturn(data.get("Saturn"))
              .withChiron(data.get("Chiron"))
              .withUranus(data.get("Uranus"))
              .withSun(data.get("Sun"))
              .withMercury(data.get("Mercury"))
              .withNeptune(data.get("Neptune"))
              .withPluto(data.get("Pluto"));


        Cusp cusps = new CuspBuilder(eventUTC)
						.houses("Placidus")
						.topo(request.getLongitude(), request.getLatitude(), GEOALT)
						.build();
						
		response.withCusps(cusps.getCusps()).withPlanets(thePlanets);		
		//response = samplResponse(logger);
        return response;
   }

   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

   private NatalChartResponse samplResponse(LambdaLogger logger) {
       List<Double> cusps = Arrays.asList(265.6850555442075D, 307.6441825689919D, 353.38796689506074D,
               26.86890880306794D, 50.191811553503044D, 68.57049261566578D, 85.6850555442075D, 127.64418256899188D,
               173.3879668950608D, 206.8689088030679D, 230.19181155350307D, 248.5704926156658D);
       Planets thePlanets = (new Planets())
                .withMoon(Arrays.asList(64.25288092281401D))
               .withVenus(Arrays.asList(273.7830306594277D))
               .withJupiter(Arrays.asList(194.01740070357724D))
               .withnNode(Arrays.asList(158.69506558607495D))
               .withMars(Arrays.asList(304.51132244447103D))
               .withLilith(Arrays.asList(229.84586450839743D))
               .withSaturn(Arrays.asList(255.93879297657875D, -0.2D))
               .withChiron(Arrays.asList(350.7902705629371D))
               .withUranus(Arrays.asList(21.33233540624847D))
               .withSun(Arrays.asList(233.42635496859216D))
               .withMercury(Arrays.asList(244.23481860676145D))
               .withNeptune(Arrays.asList(339.24756865409074D))
               .withPluto(Arrays.asList(285.5359664922833D));
       NatalChartResponse response = (new NatalChartResponse()).withCusps(cusps).withPlanets(thePlanets);
       logger.log("Response: " + GSON.toJson(response));
       logger.log("Response TYPE: " + response.getClass().toString());
       return response;
   }
}