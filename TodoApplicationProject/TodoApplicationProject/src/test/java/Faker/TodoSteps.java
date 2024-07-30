package Faker;

import apis.TodoApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import model.Todo;

public class TodoSteps {

    public static Todo generateTodo() {
        Faker faker = new Faker();
        String item = faker.book().title();

        boolean isCompleted = false;

        return new Todo(false, item);
    }

    public static Todo generateTodoWithoutisCompleted() {
        Faker faker = new Faker();
        String item = faker.book().title();
        return new Todo( item);
    }
    public static String GetTaskID(String Token){
        Todo todo = generateTodo();

        Response response = TodoApi.AddTodo(todo,Token);

        return response.body().path("_id");
    }






}
