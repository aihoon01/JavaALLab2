package org.exercises.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("/", r -> r
                        .header("X-Custom-Header", "HeaderValue") // Predicate for routing based on header
                        .uri("http://main-service:8082"))
                .route("default_route", r -> r
                        .path("/vip/**") // Default route if header doesn't match
                        .uri("http://vip-service:8083"))
                .build();
    }
}
