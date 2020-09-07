package cr.una.taskapp.backend.common;

public class Constants {
    public static final String URL_PREFIX = "/api/v1/";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
