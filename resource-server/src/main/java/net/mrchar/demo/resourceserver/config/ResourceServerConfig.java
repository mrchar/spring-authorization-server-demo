package net.mrchar.demo.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.mvcMatcher("/messages/**")
        .authorizeRequests()
        .mvcMatchers("/messages/**")
        .access("hasAuthority('SCOPE_message.read')");
    http.oauth2ResourceServer().jwt();
    return http.build();
  }
}
