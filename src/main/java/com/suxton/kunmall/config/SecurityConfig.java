package com.suxton.kunmall.config;

<<<<<<< Updated upstream
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
=======

import com.suxton.kunmall.utils.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

>>>>>>> Stashed changes

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Beanpublic
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().requestMatchers("/api/v1/auth/**", "/api/v1/test/**", "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security", "/swagger-ui/**", "/doc.html", "/webjars/**", "/swagger-ui.html", "/favicon.ico").permitAll().requestMatchers("/api/v1/supervisor/**").hasAnyRole(SUPERVISOR.name(), ADMIN.name()).requestMatchers(GET, "/api/v1/supervisor/**").hasAnyAuthority(SUPERVISOR_READ.name(), ADMIN_READ.name()).requestMatchers(POST, "/api/v1/supervisor/**").hasAnyAuthority(SUPERVISOR_CREATE.name(), ADMIN_CREATE.name()).requestMatchers(PUT, "/api/v1/supervisor/**").hasAnyAuthority(SUPERVISOR_UPDATE.name(), ADMIN_UPDATE.name()).requestMatchers(DELETE, "/api/v1/supervisor/**").hasAnyAuthority(SUPERVISOR_DELETE.name(), ADMIN_DELETE.name()).requestMatchers("/api/v1/chaser/**").hasRole(CHASER.name()).requestMatchers(GET, "/api/v1/chaser/**").hasAuthority(CHASER_READ.name()).requestMatchers(POST, "/api/v1/chaser/**").hasAuthority(CHASER_CREATE.name()).requestMatchers(PUT, "/api/v1/chaser/**").hasAuthority(CHASER_UPDATE.name()).requestMatchers(DELETE, "/api/v1/chaser/**").hasAuthority(CHASER_DELETE.name()).anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authenticationProvider(authenticationProvider)//添加jwt 登录授权过滤器.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).logout().logoutUrl("/api/v1/auth/logout").addLogoutHandler(logoutHandler).logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());//添加自定义未授权和未登录结果返回http.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthorizationEntryPoint);return http.build();}
    }
}<<<<<<< Updated upstream
}
=======
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .requestMatchers("/", "/Home*").permitAll()
                        .requestMatchers("/favicon.ico").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/login")
                        .loginPage("/Login")
                        .permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler((request, response, authentication) ->
                                response.sendRedirect("/"))
                        .failureHandler((request, response, authentication) ->
                                response.sendRedirect("/Login?error"))
                ).logout((logout) -> logout.permitAll())
                .userDetailsService(userDetailsService);


        return httpSecurity.build();
    }
}


>>>>>>> Stashed changes
