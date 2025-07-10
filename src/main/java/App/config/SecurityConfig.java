package App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import App.filter.Jwtfilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final Jwtfilter jwtfilter;
	public SecurityConfig(Jwtfilter jwtfilter)
	{
		this.jwtfilter=jwtfilter;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // disable CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class); // enable HTTP Basic auth

        return http.build();
    }
}
