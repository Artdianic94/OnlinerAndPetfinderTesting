package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import staticData.WebUrls;
import utilities.PropertiesManager;

public class PetfinderHooks {
    private static String accessToken;
    PropertiesManager propertiesManager = new PropertiesManager();

    @Before("@api")
    public void getAccessToken() {

        Response response = RestAssured.given()
                .param("grant_type", "client_credentials")
                .param("client_id", propertiesManager.get("client_id"))
                .param("client_secret", propertiesManager.get("client_secret"))
                .when()
                .post(WebUrls.PETFINDER_TOKEN);
        accessToken = response.jsonPath().getString("access_token");
    }

    public String getAccessTokenValue() {
        return accessToken;
    }
}