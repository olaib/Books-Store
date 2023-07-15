//package hac.Filters;
//
//import hac.Beans.SessionBean;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class AuthenticatedInterceptor implements HandlerInterceptor {
//    private SessionBean sessionBean;
//
//    public AuthenticatedInterceptor() {
//    }
//
//    public AuthenticatedInterceptor(SessionBean sBean) {
//        sessionBean = sBean;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        if (sessionBean != null && sessionBean.isLoggedIn()) {
//            System.out.println("AuthenticatedInterceptor: logged in");
//            response.sendRedirect("/posts");
//            return false;
//        }
//        return true;
//    }
//}
//
