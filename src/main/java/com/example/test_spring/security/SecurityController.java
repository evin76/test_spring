package com.example.test_spring.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SecurityController {

    @GetMapping("/public/api")
    public String publicApi() {
        /*
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<SimpleGrantedAuthority> roles = null;
        String username = null;
        if (user instanceof UserDetails) {
            username = ((UserDetails) user).getUsername();
            roles = (Collection<SimpleGrantedAuthority>) ((UserDetails) user).getAuthorities();
            System.out.println(roles);
            System.out.println(username);
        }*/
        return "public/api";
    }

    @GetMapping("/admin/api")
    public String adminApi() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<SimpleGrantedAuthority> roles = null;
        String username = null;
        if (user instanceof UserDetails) {
            username = ((UserDetails) user).getUsername();
            roles = (Collection<SimpleGrantedAuthority>) ((UserDetails) user).getAuthorities();
            System.out.println(roles);
            System.out.println(username);
        }
        return "admin/api, roles:  " + roles + ", username: " + username;
    }

    @GetMapping("/support/api")
    public String supportApi() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<SimpleGrantedAuthority> roles = null;
        String username = null;
        if (user instanceof UserDetails) {
            username = ((UserDetails) user).getUsername();
            roles = (Collection<SimpleGrantedAuthority>) ((UserDetails) user).getAuthorities();
            System.out.println(roles);
            System.out.println(username);
        }
        return "support/api, roles:  " + roles + ", username: " + username;
    }
}
