package spotify.ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spotify.ui.pages.HomePage;
import spotify.ui.pages.LoginPage;
import spotify.ui.steps.LoginUserSteps;
import spotify.ui.util.UserData;

public class LoginTest extends BaseTest {

  @Test
  @DisplayName("Авторизация с корректными данными")
  public void testLoginCorrectDataUser() {
    LoginPage loginPage = new LoginPage();
    LoginUserSteps.stepsUserLogIn(UserData.USER_EMAIL, UserData.USER_PASSWORD);
    Assertions.assertTrue(loginPage.isDisplayedAvatar());
  }
  @Test
  @DisplayName("Авторизация с пустым логином(email) ")
  public void testLoginIncorrectName() {
    String expected = "Incorrect username or password.";
    LoginPage loginPage = new LoginPage();
    LoginUserSteps.stepsUserLogIn(UserData.EMPTY_USER_EMAIL, UserData.USER_PASSWORD);
    Assertions.assertEquals(expected, loginPage.errorMessageAutorization());
  }
  @Test
  @DisplayName("Авторизация с пустым паролем ")
  public void testLoginIncorrectPassword() {
    String expected = "Incorrect username or password.";
    LoginPage loginPage = new LoginPage();
    LoginUserSteps.stepsUserLogIn(UserData.USER_EMAIL, UserData.EMPTU_USER_PASSWORD);
    Assertions.assertEquals(expected, loginPage.errorMessageAutorization());
  }
}
