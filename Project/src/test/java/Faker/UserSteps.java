package Faker;
import apis.UserApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import model.User;
public class UserSteps {

    public static User generateuser() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastname = faker.name().lastName();
        String emaill = faker.internet().emailAddress();
        String password = "likeQAtest";
        User user = new User(firstName, lastname, emaill, password);
        return user;

    }


    public static User getRegisteredUser() {
        User user = generateuser();
        UserApi.registeruser(user);
        return user;
    }
    public static String getUserToken() {
        User user = generateuser();
        Response response= UserApi.registeruser(user);
        return response.body().path("access_token");



    }
}