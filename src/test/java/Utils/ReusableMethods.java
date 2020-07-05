package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ReusableMethods {

    public static JsonPath rawToJson(Response r) {
        String responseBody = r.asString();
        JsonPath js = new JsonPath(responseBody);
        return js;
    }
}
