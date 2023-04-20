package PetfinderPages;

import Models.Animals;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AnimalsWithTypeAndLocationPage {
    Response response;

    public Response sentGetRequestWithTypeAndLocation(String token, String type, String city) {
        response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", type)
                .queryParam("location", city)
                .log()
                .all()
                .get();
        return response;
    }

    public void responseStatusCodeIsOk(int statusCode) {
        response.then().statusCode(statusCode).log().all();
    }

    public void responseContentTypeIsJson() {
        response.then().contentType(ContentType.JSON).log().all();
    }

    public void responseContainsParticularBody() {
        response.as(Animals.class);
    }

    public void typeOfAnimal(String typeOfAnimal) {
        response.then().body("animals.type", everyItem(equalTo(typeOfAnimal))).log().all();
    }

    public void animalFromCity(String city) {
        response.then().body("animals.contact.address.state", everyItem(equalTo(city))).log().all();
    }
}
