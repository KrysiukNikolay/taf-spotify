package spotify.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import spotify.ui.highlight.Highlight;

public class SearchPage extends BasePage {

    public final By BUTTON_SEARCH = By.xpath("//a[@href='/search']");
    public final By FORM_SEARCH = By.xpath("//input[@data-testid='search-input']");
    public final By NAME_ARTIST_AFTER_SEARCH = By.xpath("//div[@class='sm7ZnbOO1Zfg9cupYgPN']/a/div");

    public SearchPage clickSearch() {
        WebElement buttonSearch = driver.findElement(BUTTON_SEARCH);
        Highlight.highlight(buttonSearch);
        buttonSearch.click();
        return this;
    }

    public void inputSearchRequest(String request) {
        WebElement formSearch = driver.findElement(FORM_SEARCH);
        Highlight.highlight(formSearch);
        formSearch.sendKeys(request);
    }

    public String nameAfterSearchArtist() {
        WebElement searchArtist = driver.findElement(NAME_ARTIST_AFTER_SEARCH);
        Highlight.highlight(searchArtist);
        return searchArtist.getText().toLowerCase();
    }
}
