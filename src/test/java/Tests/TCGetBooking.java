package Tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TCGetBooking {

    @Test
    public void getBooking()
    {
        given()
                .get("https://restful-booker.herokuapp.com/booking/6842")
                .then().statusCode(200)
                .body("firstname",equalTo("Dennis"))
                .log().all();

    }
    @Test
    public void getBookingNegativeScenario()
    {
        given()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then().statusCode(404)
                .log().all();
    }
}
