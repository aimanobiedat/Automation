package testcases;
import  static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import Faker.UserSteps;
import apis.UserApi;
import io.restassured.response.Response;
import model.Error;
import model.User;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
public class UserTest {
    @Test
    public void shouldBeAbleToRegisterUser(){
        User user= UserSteps.generateuser();
        Response response =UserApi.registeruser(user);
        User returnedUser=response.body().as(User.class);
        assertThat(returnedUser.getFirstName(),equalTo(user.getFirstName()));
    }

    @Test
    public void shouldBeNotAbleToRegisterUserWithEmailAlreadyExist(){

        User user=UserSteps.getRegisteredUser();
             Response response=UserApi.registeruser(user);
       assertThat(response.statusCode(),equalTo(400));
        Error returnederror=response.body().as(Error.class);
        assertThat(returnederror.getMessage(), equalTo("Email is already exists in the Database"));
    }


    @Test
    public void shouldBeAbleTologin(){
        User user=UserSteps.getRegisteredUser();
        User LoginData=new User(user.getEmail(),user.getPassword());
      Response response=UserApi.loginuser(LoginData);
        User returnedUser=response.body().as(User.class);
        assertThat(returnedUser.getFirstName(), equalTo(user.getFirstName()));
      assertThat(returnedUser.getaccessToken() ,not(equalTo(null)));
    }
    @Test
    public void shouldBeNotAbleTologinwithEmailorPasswordNotcorrect(){
        User user=UserSteps.getRegisteredUser();
        User LoginData=new User(user.getEmail(),"incorrectpasswird");
        Response response=UserApi.loginuser(LoginData);
        Error returnederror=response.body().as(Error.class);
        assertThat(response.statusCode(),equalTo(401));
        assertThat(returnederror.getMessage(), equalTo("The email and password combination is not correct, please fill a correct email and password"));
    }
    }




