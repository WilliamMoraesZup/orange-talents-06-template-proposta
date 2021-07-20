package com.zup.william.proposta.proposta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorizeRequests ->
                authorizeRequests.antMatchers(HttpMethod.GET, "/teste").permitAll()
                        .antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_leitura")
                        .antMatchers(HttpMethod.GET, "/cartoes/**").hasAuthority("SCOPE_leitura")
                        .antMatchers(HttpMethod.POST, "/cartoes/**").hasAuthority("SCOPE_leitura")
                        .antMatchers(HttpMethod.POST, "/proposta/").hasAuthority("SCOPE_leitura")

                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

}