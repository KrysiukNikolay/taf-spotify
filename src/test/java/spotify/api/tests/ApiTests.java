package spotify.api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spotify.api.config.ApiSpotifyConfig;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    @DisplayName("Получение ответа 200 от запроса к сайту")
    public void testGetRequestReturns200() {
        given()
                .header("Authorization", "Bearer " + ApiSpotifyConfig.ACCESS_TOKEN)
                .when()
                .get(ApiSpotifyConfig.ENDPOINT_URL)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя")
    public void testAuthorizedUserGetsUserInfo() {
        Response response = given()
                .header("Authorization", "Bearer " + ApiSpotifyConfig.ACCESS_TOKEN)
                .when()
                .get(ApiSpotifyConfig.ENDPOINT_URL)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String actualUserId = response.jsonPath().getString("id");
        String actualDisplayName = response.jsonPath().getString("display_name");

        Assertions.assertEquals(ApiSpotifyConfig.EXPECTED_USER_ID, actualUserId);
        Assertions.assertEquals(ApiSpotifyConfig.EXPECTED_DISPLAY_NAME, actualDisplayName);

    }
    @Test
    @DisplayName("Создание playlist методом POST")
    public void testCreatePlaylistReturns201() {

        JSONObject playlist = new JSONObject();
        playlist.put("name", ApiSpotifyConfig.PLAYLIST_NAME);
        playlist.put("description", ApiSpotifyConfig.PLAYLIST_DESCRIPTION);

        given()
                .header("Authorization", "Bearer " + ApiSpotifyConfig.ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(playlist.toJSONString())
                .when()
                .post("https://api.spotify.com/v1/users/" + ApiSpotifyConfig.EXPECTED_USER_ID + "/playlists")
                .then().log().all()
                .assertThat()
                .statusCode(201);
    }
}
