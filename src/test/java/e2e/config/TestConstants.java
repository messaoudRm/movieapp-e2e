package e2e.config;

public final class TestConstants {

    private TestConstants() {
    }

    public static final String BASE_URL = "http://localhost:4200";
    public static final String AUTH_URL = BASE_URL + "/auth";
    public static final String HOME_URL = BASE_URL + "/home";

    public static final String USERNAME = "seleniumE2E";
    public static final String PASSWORD = "seleniumE2E";
    public static final String EMAIL = "selenium@selenium.com";

    public static final int MOVIE_ID = 1;
    public static final int ANOTHER_MOVIE_ID = 2;
    public static final String MOVIE_NAME = "john wick";

    public static final String POSITIVE_REVIEW = "Great movie with a compelling story, strong performances, and excellent cinematography.";
    public static final String NEGATIVE_REVIEW = "Disappointing movie with a predictable plot and underdeveloped characters.";

    public static final int COMMENT_ID = 16;
    public static final int ANOTHER_COMMENT_ID = 17;

}
