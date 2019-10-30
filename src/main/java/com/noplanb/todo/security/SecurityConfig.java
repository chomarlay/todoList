package com.noplanb.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.noplanb.todo.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true, //eg.  @Secured("ROLE_ADMIN") , @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
        jsr250Enabled = true,  //eg. @RolesAllowed("ROLE_ADMIN")
        prePostEnabled = true  //eg. @PreAuthorize("isAnonymous()") ,  @PreAuthorize("hasRole('USER')")
)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder());
	}
	


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	       http
           .cors()
               .and()
           .csrf()
               .disable()
           .exceptionHandling()
               .authenticationEntryPoint(unauthorizedHandler)
               .and()
           .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
           .authorizeRequests()
               .antMatchers("/",
                   "/favicon.ico",
                   "/**/*.png",
                   "/**/*.gif",
                   "/**/*.svg",
                   "/**/*.jpg",
                   "/**/*.html",
                   "/**/*.css",
                   "/**/*.js")
                   .permitAll()
               .antMatchers("/api/auth/**")
                   .permitAll()
               .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
                   .permitAll()
               .antMatchers(HttpMethod.GET, "/api/projects/**", "/api/users/**")
                   .permitAll()
               .anyRequest()
                   .authenticated();

			   // Add our custom JWT security filter
				//   http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

}
