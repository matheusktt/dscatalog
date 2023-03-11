package com.devsuperior.dscatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private JwtTokenStore tokenStore;

    // Endpoint publico para login e h2-console
    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    // Endpoints liberados para operador e admin
    private static final String[] OPERATOR_OR_ADMIN = {"/products/**", "/categories/**"};

    // Endpoint liberado para admin
    private static final String[] ADMIN = {"/users/**"};

    // Validação do token
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    // Configuração das rotas
    @Override
    public void configure(HttpSecurity http) throws Exception {

        // Libera o h2-console no perfil de test, desabilitando os frames do h2
        if (Arrays.asList(environment.getActiveProfiles()).contains("test")){
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR_OR_ADMIN).permitAll()
                .antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}