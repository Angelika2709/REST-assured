package RestAssuredTestArticle;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;


public class GETTest {
  @Test(description = "GET")
  public void getRequestExampleTest() throws JSONException {
	  Response response = get("https://www.gold585.ru/api/catalog/memory?page=1&pathname=/catalog/&display=desktop&city=-1&product_id=");
      JSONArray jsonResponse = new JSONArray(response.asString());
      String item = jsonResponse.getJSONObject(0).getString("title");
      Assert.assertEquals(item, "Цепочка, плетение Сингапур, из золота");	  
  }
}
