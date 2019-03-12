package ShopTests;

import Utils.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertTrue;

class GETShopsTest {

	private Response res = null;
    private JsonPath jp = null; 
    
    @Before
    public void setup (){
        //Test Setup
        RestUtil.setBaseURI("http://webservice.toscacloud.com/rest/swagger/docs/v2"); 
        RestUtil.setBasePath("/api/Shops_V2"); 
        RestUtil.setContentType(ContentType.JSON); 
        //RestUtil.createSearchQueryPath("barack obama", "videos.json", "num_of_videos", "4"); //Construct the path
        res = RestUtil.getResponse(); 
        jp = RestUtil.getJsonPath(res); 
    }
	

	@Test
		public void T01_StatusCodeTest() {
	        HelperMethods.checkStatusIs200(res);
	    }		
	}

