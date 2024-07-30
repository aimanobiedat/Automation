package apis;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class UserApi {

    public static Response registeruser(User user){
        return given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/v1/users/register")
                .then().log().all()
                .extract().response();

    }
    public static Response loginuser(User user){
        return given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/api/v1/users/login")
                .then().log().all()
                .extract().response();
    }
}
