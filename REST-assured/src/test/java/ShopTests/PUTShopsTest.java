package ShopTests;

import static org.junit.jupiter.api.Assertions.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.get;
import org.junit.jupiter.api.Test;

class PUTShopsTest {
	final String ACTUAL = "Moscow";
	final String EXPECTED = "Moscow";

	@Test
	void test() {
		RestAssured.given().baseUri("http://webservice.toscacloud.com")
		.basePath("/rest/api/Shops_V2")
		.contentType(ContentType.JSON)
		.header("api_key", "5cc0c96e-7efe-41a2-871d-306e3d004910")
		.body("{" + "\n" +
			   " \"City\":" + "Moscow\"," + "\n" +
			   " \"Country\":" + "Russia\"," + "\n" +  
			   " \"Id\":" + "4\"," +"\n" +  
			   " \"Name\":" + "Pauling\"," + "\n" + "}")
		.when()
		.put()
		.then();
		Assert.assertTrue(ACTUAL.equals(EXPECTED));
	}

}
