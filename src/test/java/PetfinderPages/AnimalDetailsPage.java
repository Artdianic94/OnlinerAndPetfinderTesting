package PetfinderPages;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AnimalDetailsPage {
    Response response;

    public Response sentGetRequestWithAnimalID(String token, String id) {
        response = given()
                .filter(new AllureRestAssured())
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id)
                .log()
                .all()
                .get("{id}");
        return response;
    }

    public void particularAnimal() {
        JsonPath expectedJson = new JsonPath(new File("src/test/resources/OnyxCat.json"));
        response.then().body("", equalTo(expectedJson.getMap(""))).log().all();
    }
}
