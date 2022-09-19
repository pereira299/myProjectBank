package br.edu.utfpr.td.tsi.mybankproject.configs;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.register(RequestContextFilter.class);
        this.packages("br.edu.utfpr.td.tsi.mybankproject.routes");
    }
}
