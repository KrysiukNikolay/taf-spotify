package spotify.ui.pages;

import spotify.ui.util.UserData;

public class HomePage extends BasePage{
    public static final String URL = "https://open.spotify.com/";
    public void openWebSite() {
        driver.get(URL);

    }
}
