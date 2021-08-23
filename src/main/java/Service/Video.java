package Service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static org.hamcrest.core.Is.is;

public class Video {

    @Step
    public void getRequest(){
        doSoemthing();
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();
        Response response = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather");

    }

    @Step
    public Map<String,String> authenticate(){

    }


    @Step
    public void uploadVideo(){

    }

    @Step
    private void doSoemthing(){
        int i = 0;
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();
        Response response = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather");
    }

    private String ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/";
    private Response response;

    @Step("I try to do something cool")
    public void searchCountryByCode(String code){
        response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
    }

    @Step
    public void searchIsExecutedSuccesfully(){
        response.then().statusCode(200);
    }

    @Step
    public void iShouldFindCountry(String country){
        response.then().body("RestResponse.result.name", is(country));
    }
}
