package hac.Filters;

import hac.Beans.CartBean;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor to prevent access to /checkout when the cart is empty.
 */
@Component
public class CartInterceptor implements HandlerInterceptor {

    private CartBean sessionBean;

    public CartInterceptor() {
    }

    /**
     * Constructs a CartInterceptor with the specified CartBean.
     *
     * @param sBean the CartBean instance
     */
    public CartInterceptor(CartBean sBean) {
        this.sessionBean = sBean;
    }

    /**
     * Pre-handle method to check if the cart is empty before allowing access to /checkout.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @param handler  the handler for the request
     * @return {@code true} if the cart is not empty and further processing should continue,
     *         {@code false} otherwise, and redirects the user to /cart
     * @throws Exception in case of any error during handling the request
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (sessionBean != null && sessionBean.booksInCart() > 0) {
            System.out.println("cart not empty");
            return true; // Continue with the request processing
        } else {
            System.out.println("empty cart");
            response.sendRedirect("/cart");
            return false; // Stop further processing and redirect to /cart
        }
    }
}
