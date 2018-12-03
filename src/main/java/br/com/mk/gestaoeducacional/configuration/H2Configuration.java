package br.com.mk.gestaoeducacional.configuration;

import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2Configuration {

    @Value("${h2.tcp.port:9092}")
    private String h2TcpPort;

    @Value("${h2.web.port:8082}")
    private String h2WebPort;

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", h2TcpPort).start();
    }

    @Bean
    public Server h2WebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-tcpAllowOthers", "-webPort", h2WebPort).start();
    }
}
