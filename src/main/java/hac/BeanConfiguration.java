package hac;

import hac.Beans.CartBean;
import hac.Beans.SessionBean;
import hac.listeners.SessionListenerCounter;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.context.annotation.Configuration;

/**
 * Bean configurations
 */
@Configuration
public class BeanConfiguration {
    /**
     * session cart
     * @return the cart bean
     */
    @Bean
    @SessionScope
    public CartBean sessionBeanCart() {
        return new CartBean();
    }

    @Bean
    @ApplicationScope
    public CartBean BeanCart() {
        return new CartBean();
    }

    /**
     * session listener counter
     * @return Servlet Listener Registration Bean of Session Listener Counter
     */
    @Bean
    public ServletListenerRegistrationBean<SessionListenerCounter> sessionListenerWithMetrics() {
        ServletListenerRegistrationBean<SessionListenerCounter> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new SessionListenerCounter());
        return listenerRegBean;
    }
}
