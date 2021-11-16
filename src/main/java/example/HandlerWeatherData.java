/* Decompiler 6ms, total 182ms, lines 32 */
package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.List;

public class HandlerWeatherData implements RequestHandler<WeatherData, NatalChartResponse> {
   Gson gson = (new GsonBuilder()).setPrettyPrinting().create();

   public NatalChartResponse handleRequest(WeatherData event, Context context) {
      LambdaLogger logger = context.getLogger();
      logger.log("Input EVENT: " + this.gson.toJson(event));
      logger.log("Input EVENT TYPE: " + event.getClass().toString());
      List<Double> cusps = Arrays.asList(265.6850555442075D, 307.6441825689919D, 353.38796689506074D, 26.86890880306794D, 50.191811553503044D, 68.57049261566578D, 85.6850555442075D, 127.64418256899188D, 173.3879668950608D, 206.8689088030679D, 230.19181155350307D, 248.5704926156658D);
      Planets thePlanets = (new Planets()).setMoon(Arrays.asList(64.25288092281401D)).setVenus(Arrays.asList(273.7830306594277D)).setJupiter(Arrays.asList(194.01740070357724D)).
      setNNode(Arrays.asList(158.69506558607495D)).setMars(Arrays.asList(304.51132244447103D)).setLilith(Arrays.asList(229.84586450839743D)).setSaturn(Arrays.asList(255.93879297657875D, -0.2D)).
      setChiron(Arrays.asList(350.7902705629371D)).setUranus(Arrays.asList(21.33233540624847D)).setSun(Arrays.asList(233.42635496859216D)).setMercury(Arrays.asList(244.23481860676145D)).
      setNeptune(Arrays.asList(339.24756865409074D)).setPluto(Arrays.asList(285.5359664922833D));
      NatalChartResponse response = (new NatalChartResponse()).setCusps(cusps).setPlanets(thePlanets);
      logger.log("Response: " + this.gson.toJson(response));
      logger.log("Response TYPE: " + response.getClass().toString());
      return response;
   }
}
