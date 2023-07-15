package hac.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * a classic @WebListener class for session count
 * the @Component is needed only if we INJECT beans
 */
@Component
@WebListener
public class SessionListenerCounter implements HttpSessionListener {
    /**
     * activeSessions - atomic
     */
    private final AtomicInteger activeSessions;
    private final String DECREAMENT_MSG = "SessionListenerCounter --- Total active session are ";
    private final String INCREAMENT_MSG = "SessionListenerCounter +++ Total active session are ";


    /**
     * c-tor
     */
    @Autowired
    public SessionListenerCounter() {
        super();
        activeSessions = new AtomicInteger();
    }

    /**
     * get total active session
     *
     * @return active session counter
     */
    public int getTotalActiveSession() {
        return activeSessions.get();
    }

    /**
     * increament func for counter
     *
     * @param event HttpSessionEvent
     */
    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
        System.out.println(INCREAMENT_MSG + activeSessions.get());
    }

    /**
     * destroy session
     *
     * @param event HttpSessionEvent
     */
    public void sessionDestroyed(final HttpSessionEvent event) {
        activeSessions.decrementAndGet();
        System.out.println(DECREAMENT_MSG + activeSessions.get());
    }
}