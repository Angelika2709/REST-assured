package ShopTests;

import org.junit.jupiter.api.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

class POSTShopsTest {


	@Test
	void test() {
		RestAssured.given()
		.baseUri("http://webservice.toscacloud.com")
		.basePath("/rest/api/Shops_V2")
		.contentType(ContentType.JSON)
		.header("api_key", "5cc0c96e-7efe-41a2-871d-306e3d004910")
		.body("{" + "\n" +
			   " \"City\":" + "Saint-Petersburg\"," + "\n" +
			   " \"Country\":" + "Russia\"," + "\n" +  
			   " \"Id\":" + "4\"," +"\n" +  
			   " \"Name\":" + "Pauling\"," + "\n" + "}")
		.when()
		.post()
		.then()
		.body("City", equalTo("Saint-Petersburg"));
		
	}

}
