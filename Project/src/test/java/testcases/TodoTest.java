package testcases;
import  static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import Faker.TodoSteps;
import Faker.UserSteps;
import apis.TodoApi;
import apis.UserApi;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.response.Response;
import model.Error;
import model.Todo;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
public class TodoTest {
    @Test
    public void ShouldBeabletoAddTodo(){
//      Todo todo=new Todo(false, "Learn Appium");
        String Token= UserSteps.getUserToken();
        Todo todo= TodoSteps.generateTodo();
         Response response= TodoApi.AddTodo(todo,Token );
        Todo returnedTodo= response.body().as(Todo.class);
       assertthat(response.statusCode(),equalTo(201));
        assertThat(returnedTodo.getItem(),equalTo(todo.getItem()));
        assertThat(returnedTodo.getisCompleted(),equalTo(todo.getisCompleted()));
//                .assertThat().statusCode(201)
//                .assertThat().body("isCompleted",equalTo(false))
//                        .assertThat().body("item",equalTo("Learn Appium"));
    }
    private void assertthat(int i, Matcher<Integer> integerMatcher) {
    }

    @Test
    public void ShouldBeNotabletoAddTodo(){
//      Todo todo=new Todo("Learn Appium");
        String Token= UserSteps.getUserToken();
        Todo todo=TodoSteps.generateTodoWithoutisCompleted();
        Response response= TodoApi.AddTodo(todo,Token );
        assertthat(response.statusCode(), equalTo(400));
        Error returnederror=response.body().as(Error.class);
        assertThat(returnederror.getMessage(),equalTo("\"isCompleted\" is required"));
//        assertThat(response.path("message"),equalTo("\"isCompleted\" is required"));
//                .assertThat().statusCode(400)
//                .assertThat().body("message",equalTo("\"isCompleted\" is required"));
    }

    @Test
    public void ShouldBeabletoGetTodoByID() {

       String Token = UserSteps.getUserToken();
       String TaskId = TodoSteps.GetTaskID(Token);
        Response response = TodoApi.GetTodo(TaskId, Token);
//        Todo returnedTodo= response.body().as(Todo.class);
        assertthat(response.statusCode(), equalTo(200));
        //        assertThat(response.path("item"),equalTo("Learn Appium"));
//                .assertThat().statusCode(200)
//                .assertThat().body("isCompleted",equalTo(false))
//                .assertThat().body("item",equalTo("Learn Appium"))
//                .assertThat().body("createdAt", equalTo("2024-03-17T07:47:56.410Z"));
    }
    @Test
    public void ShouldBetabletoDeleteTodo(){
        String Tasks="66012bd8f996c8001448727c";
        String Token= UserSteps.getUserToken();
      Response response=TodoApi.DeleteTodo(Tasks,Token);
      assertthat(response.statusCode(),equalTo(200));
        assertThat(response.path("item"),equalTo("Learn Appium"));
//                assertThat().body("isCompleted",equalTo(false))
//                .assertThat().body("item",equalTo("Learn Appium"));
////                .assertThat().body("createdAt", equalTo("2024-03-17T07:47:56.410Z"));
    }

    }

