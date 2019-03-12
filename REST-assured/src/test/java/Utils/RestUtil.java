package Utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class RestUtil {
	
    public static String path; 
    
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
    
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }
    
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
    
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }
    
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }
    
    public static void  createSearchQueryPath(String searchTerm, String jsonPathTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }
    
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }
    
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
}
 

