package PetfinderSteps;

import PetfinderPages.AnimalsWithTypeAndLocationPage;
import hooks.PetfinderHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class AnimalSearchSteps {
    String type;
    String city;
    private static String token;
    PetfinderHooks petfinderHooks;
    AnimalsWithTypeAndLocationPage animalsWithTypeAndLocationPage;

    public AnimalSearchSteps() {
        petfinderHooks = new PetfinderHooks();
        animalsWithTypeAndLocationPage = new AnimalsWithTypeAndLocationPage();
    }

    @Given("base URI is {}")
    public void baseURIIs(String URI) {
        RestAssured.baseURI = URI;
    }

    @And("type is {}")
    public void typeIs(String animalType) {
        type = animalType;
    }

    @And("location is {}")
    public void locationIs(String location) {
        city = location;
    }

    @And("authorization token")
    public void authorizationTokenIs() {
        token = petfinderHooks.getAccessTokenValue();
    }

    @When("GET request is sent")
    public void GETRequestIsSent() {
        animalsWithTypeAndLocationPage.sentGetRequestWithTypeAndLocation(token, type, city);
    }

    @Then("response status code is {int}")
    public void responseStatusCodeIs(int statusCode) {
        animalsWithTypeAndLocationPage.responseStatusCodeIsOk(statusCode);
    }

    @And("response format is JSON")
    public void responseFormatIsJSON() {
        animalsWithTypeAndLocationPage.responseContentTypeIsJson();
    }

    @And("response contains all requested fields")
    public void responseContainsRequestedFields() {
        animalsWithTypeAndLocationPage.responseContainsParticularBody();
    }

    @And("response contains a list with {}")
    public void responseContainsAListWith(String animalType) {
        animalsWithTypeAndLocationPage.typeOfAnimal(animalType.replace("d", "D"));
    }

    @And("from {}")
    public void from(String location) {
        String[] words = location.split(" ");
        String abbreviation = "";
        for (String word : words) {
            abbreviation += word.charAt(0);
        }
        animalsWithTypeAndLocationPage.animalFromCity(abbreviation);
    }
}
