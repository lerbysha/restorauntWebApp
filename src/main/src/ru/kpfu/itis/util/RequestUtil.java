package ru.kpfu.itis.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class RequestUtil {
    private static final String SESSION_COOKIE_NAME = "SESSION_TOKEN";

    public static Optional<Cookie> getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return Optional.empty();
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }

    public static Optional<Cookie> getAuthCookie(HttpServletRequest request) {
        return getCookie(request, SESSION_COOKIE_NAME);
    }
}