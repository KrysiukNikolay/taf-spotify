package spotify.ui.highlight;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import spotify.ui.pages.BasePage;

public class Highlight extends BasePage {

    public static void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 6px solid red; background:yellow');", element);
    }
}
