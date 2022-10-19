package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking {

    //Valid Scenario
    @Test
    public void createABookingValid()
    {
        JSONObject request = new JSONObject();

        request.put("firstname", "Dennis");
        request.put("lastname", "Nyawira");
        request.put("totalprice", 111);
        request.put("depositpaid", true);
        request.put("additionalneeds", "Breakfast");


        JSONObject childParams = new JSONObject();
        childParams.put("checkin" , "2018-01-01");
        childParams.put("checkout", "2019-01-01");
        request.put("bookingdates", childParams);

        System.out.println(request.toJSONString());

        given()

                .accept("application/json")
                .contentType("application/json")
                .body(request.toJSONString())
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .log().all();
    }
}
