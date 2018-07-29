package com.sweetitech.assessment.Utils;
import com.sweetitech.assessment.Domain.User;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class AuthUtils {

    public static void setAuthIdInSession(HttpServletRequest request, User user) {
        request.getSession().setAttribute("AUTH_ID", user.getEmail().hashCode());
    }

    public static boolean isLoggedIn(HttpServletRequest request) {
        return !Objects.isNull(request.getSession().getAttribute("AUTH_ID"));
    }

    public static boolean isLoginURL(HttpServletRequest request) {
        return "/login".equals(request.getServletPath().trim());
    }
}
