package com.example.email.confic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

//    //------------------
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/get").hasAuthority("ADMIN")
//                .antMatchers("/forgot_password").hasAuthority("USER")
                .antMatchers("/forgot_password").permitAll().
                anyRequest().authenticated()
                .and()
                .httpBasic();
        //http.csrf().disable().authorizeRequests().antMatchers("/forgot_password").hasAuthority("USER").anyRequest().authenticated();



//        http.headers().frameOptions().disable();


//        http.authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/get").hasAuthority("ADMIN")//hasAnyRole("ADMIN", "user")
////                .antMatchers("/signup").permitAll()//hasAuthority("USER")//hasAnyRole("admin","user")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//        http.headers().frameOptions().disable();
//        http.csrf().disable().authorizeRequests().antMatchers("/signup/").hasAuthority("ADMIN").anyRequest().authenticated();

//                .formLogin();

    }

}
