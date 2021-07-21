package com.zup.william.proposta.proposta.security;

//@EnableWebSecurity
public class SecurityConfig {

//
//        extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests(authorizeRequests ->
//                authorizeRequests.antMatchers(HttpMethod.GET, "/teste").permitAll()
//                        .antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_leitura")
//                        .antMatchers(HttpMethod.GET, "/cartoes/**").hasAuthority("SCOPE_leitura")
//                        .antMatchers(HttpMethod.POST, "/cartoes/**").hasAuthority("SCOPE_leitura")
//                        .antMatchers(HttpMethod.POST, "/proposta/").hasAuthority("SCOPE_leitura")
//
//                        .anyRequest().authenticated())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//    }

}