package com.spring.market.web.security;

import com.spring.market.domain.service.MarketUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**Clase encargada de la seguridad*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MarketUserDetailService marketUserDetailService;
    //indicar que se va a usar el usuario creado en la clase de MarketUserDetail (se genera en la opcion Code-> generate->Override methods
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(marketUserDetailService);
    }
}
