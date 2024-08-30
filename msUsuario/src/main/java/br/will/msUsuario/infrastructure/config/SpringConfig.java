package br.will.msUsuario.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
        .csrf(csrf -> csrf.disable()) // autenticacao do spring security, desatvei ela
        //com isso eu crio uma politica de autenticacao
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
    .requestMatchers(HttpMethod.POST,"/clientes").hasRole("ADM")
    .anyRequest().permitAll()
    ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
       
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    

}


/*
   .authorizeHttpRequests(authorize -> authorize)
        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
        .requestMatchers(HttpMethod.POST,"/auth/register").hasRole("ADM").anyRequest().permitAll()
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
        */