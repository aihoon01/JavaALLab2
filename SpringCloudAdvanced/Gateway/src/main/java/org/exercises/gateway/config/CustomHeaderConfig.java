package org.exercises.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomHeaderConfig {

    @Bean
    public GlobalFilter customHeaderFilter() {
        return (exchange, chain) -> {
            // Add custom header
            exchange.getRequest().mutate()
                    .header("X-Added-Header", "AddedHeaderValue")
                    .build();
            return chain.filter(exchange);
        };
    }
}
