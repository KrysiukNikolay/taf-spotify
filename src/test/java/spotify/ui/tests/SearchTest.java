package spotify.ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spotify.ui.data.ArtistData;
import spotify.ui.data.UserData;
import spotify.ui.pages.SearchPage;
import spotify.ui.steps.LoginUserSteps;
import spotify.ui.steps.SearchArtistSteps;

public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Проверка поисковой строки")
    public void testSearchArtist() {
        SearchPage searchPage = new SearchPage();
        LoginUserSteps.stepsUserLogIn(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        SearchArtistSteps.stepsSearchArtist(ArtistData.nameArtist);
        Assertions.assertEquals(ArtistData.nameArtist, searchPage.nameAfterSearchArtist());
    }
}
