package Tests;

import Utils.ReusableMethods;
import Resources.Users;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CRUDTest {

    Logger log = LogManager.getLogger(CRUDTest.class.getName());

    RequestSpecification requestSpec;

    Properties prop = new Properties();

    private static String propertiesPath = System.getProperty("user.dir") + "/src/test/java/files/env.properties";


    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream(propertiesPath);
        prop.load(fis);

        log.info("Host information " + prop.getProperty("HOST"));
        requestSpec = given()
                .baseUri(prop.getProperty("HOST"));
    }

    @Test(priority = 1)

    public void createUser() {
        Response res = given().log().ifValidationFails()
                .spec(requestSpec)
                .body(Payloads.Users.getUserData())
                .when().post(Users.createUser())
                .then().assertThat().statusCode(201).and().body("$", hasKey("createdAt"))
                .extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String user_id = js.get("id");
        System.out.println(user_id);
    }

    @Test(priority = 2)

    public void getUser() {

        int user_id = 12;

        given().log().ifValidationFails()
                .spec(requestSpec)
                .when().get(Users.getUser(user_id))
                .then().assertThat().statusCode(200).and().body("data.id", equalTo(user_id));
    }


    @Test(priority = 3)

    public void updateUser() {

        int user_id = 12;

        given().log().ifValidationFails()
                .spec(requestSpec)
                .body(Payloads.Users.updateUserData())
                .when().put(Users.updateUser(user_id))
                .then().assertThat().statusCode(200).and().body("$", hasKey("updatedAt"));
    }

    @Test(priority = 4)

    public void deleteUser() {

        int user_id = 12;

        given().log().ifValidationFails()
                .spec(requestSpec)
                .body(Payloads.Users.updateUserData())
                .when().delete(Users.deleteUser(user_id))
                .then().assertThat().statusCode(204);
    }
}

