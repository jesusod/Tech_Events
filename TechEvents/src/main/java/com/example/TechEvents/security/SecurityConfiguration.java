package com.example.TechEvents.security;

import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUsuarioService iUsuarioService;

   /* VIDEO DE MOHAMED*/
    @Autowired
   UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
  /* @Bean
    public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider auth= new DaoAuthenticationProvider();
    auth.setUserDetailsService(iUsuarioService);
    auth.setPasswordEncoder(passwordEncoder());
    return auth;
    }*/

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        /*auth.authenticationProvider(authenticationProvider());*/
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                "/registro**",
                "/js/**,",
                "/img/**",
                        "/css/**",
                        "/**"/*,
                        "/views/eventos/",
                        "/views/usuarios/",
                        "/views/usuarios/create/",
                        "/views/eventos/create/",
                        "views/eventos/edit/{id}"*/

                        ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                /*.successForwardUrl("/user/")*/
                .defaultSuccessUrl("/user/", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
