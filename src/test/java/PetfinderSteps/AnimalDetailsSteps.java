package PetfinderSteps;

import PetfinderPages.AnimalDetailsPage;
import hooks.PetfinderHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class AnimalDetailsSteps {
    String ID;
    AnimalDetailsPage animalDetailsPage;
    PetfinderHooks petfinderHooks;
    private static String token;
    Response response;

    public AnimalDetailsSteps() {
        petfinderHooks = new PetfinderHooks();
        animalDetailsPage = new AnimalDetailsPage();
    }

    @And("animal ID is {}")
    public void animalIDIs(String animalId) {
        ID = animalId;
    }

    @When("GET request is sent with the animal ID")
    public void getRequestWithID() {
        token = petfinderHooks.getAccessTokenValue();
        response = animalDetailsPage.sentGetRequestWithAnimalID(token, ID);
    }

    @Then("response contains information about the animal with the specified ID")
    public void responseContainsAnimalWithID() {
        animalDetailsPage.particularAnimal();
    }
}
