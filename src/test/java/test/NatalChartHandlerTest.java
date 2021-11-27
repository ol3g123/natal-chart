package test;

import com.natalChart.*;

import com.google.gson.Gson;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class NatalChartHandlerTest {
	
	 NatalChartHandler handler;
			
		@Mock
    Context context;
    @Mock
    LambdaLogger loggerMock;
    
	    @Before
    public void setUp() throws Exception {
      when(context.getLogger()).thenReturn(loggerMock);
        
      doAnswer(call -> {
            System.out.println((String)call.getArgument(0));//print to the console
            return null;
        }).when(loggerMock).log(anyString());
        
      handler = new NatalChartHandler();
    }
    
	@Test
	public void processRequestTest() {

		Gson GSON = new Gson();
		
		//JSONValue.escape(\"test string\");
		String requestString = 
		    "{ \"name\": \"John Doe\", \"address\": \"31166 Spruceberry Ct Wesley Chapel FL\", \"latitude\": \"10\", \"longitude\": \"-82\", \"dateOfBrith\": \"1965-04-17\", \"timeOfBirth\": \"15:00\" }";
        NatalChartRequest request = GSON.fromJson(requestString, NatalChartRequest.class);
        
		
        NatalChartResponse response = new NatalChartResponse();
        System.out.println(request);
        handler.processRequest(request, response, loggerMock);
		
        // for(int i = -89; i <=89; i++) {
        //     request.setLongitude(Double.valueOf(i));
        //     System.out.println(request);
        //     handler.processRequest(request, response, loggerMock);
        //     System.out.println(response);
        // }
		
		System.out.println(response);
	}
	
}
