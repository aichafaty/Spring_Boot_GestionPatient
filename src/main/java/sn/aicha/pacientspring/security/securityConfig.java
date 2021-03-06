package sn.aicha.pacientspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();

//        String encodedPWD=passwordEncoder.encode("123");
//        System.out.println(encodedPWD);

        auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("123")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("234")).roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin();
       http.authorizeHttpRequests().antMatchers("/delete/**","/updatePatient/**","/save/**","/formPatient/**").hasRole("ADMIN");
       http.authorizeHttpRequests().antMatchers("/index/**","/home/**").hasRole("USER");
       http.authorizeHttpRequests().anyRequest().authenticated();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
