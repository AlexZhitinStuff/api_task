package Payloads;

public class Users {

    public static String getUserData() {

        String requestBody = "{\"name\": \"testName\", \"job\": \"testJob\"}";
        return requestBody;
    }

    public static String updateUserData() {

        String requestBody = "{\"name\": \"testNameUpdated\", \"job\": \"testJobUpdated\"}";
        return requestBody;
    }

    public static String addBook(String isbn, String aisle) {

        String requestBody = ("{\"name\":\"Learn Appium Automation with Java\",\"isbn\":\""+isbn+"\",\"aisle\":\""+aisle+"\",\"author\":\"John foe\"}");

        return requestBody;
    }
}