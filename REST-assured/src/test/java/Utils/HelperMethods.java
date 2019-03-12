package Utils;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class HelperMethods {
	public static void checkStatusIs200(Response res) {
		assertEquals("Status Check Failed!", 200, res.getStatusCode());
	}

	public static ArrayList getCityIdList(JsonPath jp) {
		ArrayList cityIdList = jp.get("items.id");
		return cityIdList;
	}

	public static ArrayList getRelatedCityIdList(JsonPath jp) {
		// jp.get method returns all ids
		ArrayList relatedCityList = jp.get("items.related.id");
		ArrayList splittedRelatedCityList = (ArrayList) relatedCityList.get(0);
		return splittedRelatedCityList;
	}

	public static ArrayList mergeLists(ArrayList cityList, ArrayList relatedCityList) {
		ArrayList mergedCityList = new ArrayList(cityList);
		mergedCityList.addAll(relatedCityList);
		return mergedCityList;
	}

	public static boolean findDuplicateCities(List<Integer> cityIdList) {
		for (int i = 0; i < cityIdList.size(); i++) {
			if (Collections.frequency(cityIdList, cityIdList.get(i)) > 1) {
				System.out.println("This city id is duplicated: " + cityIdList.get(i));
				return false;
			}
		}
		return true;
	}

}
