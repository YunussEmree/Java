package com.YunussEmree.Scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // a singleton bean and it is created only once. //Default
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // a prototype bean and it is created every time it is requested.
//@RequestScope // a request bean and it is created for every HTTP request.
//@SessionScope // a session bean and it is created for every HTTP session.
//@ApplicationScope // an application bean and it is created for the lifecycle of a ServletContext.
//@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS) // a websocket bean and it is created for the lifecycle of a WebSocket.
public class MyComponent {
    public MyComponent() {
        System.out.println("MyComponent created at " + LocalDateTime.now());
    }

    public String getname() {
        return "Yunus Emre";
    }
}
