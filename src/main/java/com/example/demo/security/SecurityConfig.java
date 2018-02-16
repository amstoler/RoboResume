/*
package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Controller
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private SSUserDetailsService userDetailsService;

        @Autowired
        private UserRepo userRepo;

        @Override
        public UserDetailsService userDetailsServiceBean() throws Exception {
            return new SSUserDetailsService(userRepo);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http
                    .authorizeRequests()
                    .antMatchers("/", "/h2-console/**").permitAll()
                    */
/*.antMatchers("/").access("hasAuthority('USER') or hasAuthority('ADMIN')") // I would insert Mapping that both the user and admin should have access to here.
                    .antMatchers("/admin").access("hasAuthority('ADMIN')")*//*
 // I would only assign Mapping that ONLY the admin should have access to here.
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login").permitAll().permitAll()
                    .and()
                    .httpBasic();

            http
                    .csrf().disable();
            http
                    .headers().frameOptions().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth)
                throws Exception {

            auth
                    .userDetailsService(userDetailsServiceBean());

       */
/* auth.inMemoryAuthentication().withUser("user").password("password").authorities("USER")
                .and()
                .withUser("ariel").password("password").authorities("ADMIN")*//*
;
        }

    }
}
*/
