package hac;

import hac.Beans.CartBean;
import hac.Filters.CartInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * middle ware configuration
 */
@Configuration
public class FiltersConfig implements WebMvcConfigurer {
    @Resource(name="sessionBeanCart")
    private final CartBean cartBean;

    public FiltersConfig(CartBean cartBean) {
        this.cartBean = cartBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor(cartBean))
                .addPathPatterns("/checkout", "/order-confirm");
    }
}
