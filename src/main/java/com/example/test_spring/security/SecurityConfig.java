package com.example.test_spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyRole("ADMIN").
                antMatchers("/support/**")
                .hasAnyRole("SUPPORT").
                anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(testUsersService());
    }

    @Bean
    public InMemoryUserDetailsManager testUsersService(){
        org.springframework.security.crypto.password.PasswordEncoder encoder
                = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        String adminPass = encoder.encode("admin");
        System.out.println("Admin: " + adminPass);
        String supportPass = encoder.encode("support");
        System.out.println("Support: " + supportPass);

        var admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password(adminPass)
                .roles("ADMIN")
                .build();
        var support = User.withDefaultPasswordEncoder()
                .username("support")
                .password(supportPass)
                .roles("SUPPORT")
                .build();
        return new InMemoryUserDetailsManager(admin, support);
    }
}
