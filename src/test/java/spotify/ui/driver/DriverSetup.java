package spotify.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverSetup {

  public static WebDriver driver;

  public static WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*", "--incognito", "--lang=en");
    if (driver == null) {
        WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver(options);
     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
