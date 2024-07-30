package apis;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Todo;
import static io.restassured.RestAssured.given;
public class TodoApi {
    public static Response AddTodo(Todo todo, String Token){
         return  given()
                .baseUri("https://todo.qacart.com")
                .auth().oauth2(Token)
                .contentType(ContentType.JSON)
                .body(todo)
                .when().post("/api/v1/tasks")
                .then().log().all()
                .extract().response();
    }

    public static Response GetTodo(String TaskID, String Token){
        return  given()
                .baseUri("https://todo.qacart.com")
                .auth().oauth2(Token)
                .contentType(ContentType.JSON)
                .when().get("/api/v1/tasks" +TaskID)
                .then().log().all()
                .extract().response();
    }
    public static Response DeleteTodo( String Tasks ,String Token){
        return given()
                .baseUri("https://todo.qacart.com")
                .auth().oauth2(Token)
                .contentType(ContentType.JSON)
                .when().delete("/api/v1/tasks/" +Tasks)
                .then().log().all()
                .extract().response();
    }
}
