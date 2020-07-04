package Utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ReusableMethods {

    public static JsonPath rawToJson(Response r) {
        String responseBody = r.asString();
        JsonPath js = new JsonPath(responseBody);
        return js;
    }
}
