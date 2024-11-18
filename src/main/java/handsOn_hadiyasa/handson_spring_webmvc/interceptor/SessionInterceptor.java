package handsOn_hadiyasa.handson_spring_webmvc.interceptor;

import handsOn_hadiyasa.handson_spring_webmvc.entity.LoggedInUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        LoggedInUser loggedInUser = (LoggedInUser) session.getAttribute("username");
        if (loggedInUser == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
