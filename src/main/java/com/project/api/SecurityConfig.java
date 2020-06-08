package com.project.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(final WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login*", "/logout*", "/signin/**", "/signup/**", "/customLogin",
//                        "/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
//                        "/badUser*", "/user/resendRegistrationToken*" ,"/forgotPassword*", "/user/resetPassword*",
//                        "/user/changePassword*", "/emailError*", "/resources/**","/old/user/registration*","/successRegister*","/qrcode*","/user/enableNewLoc*", "/welcome*", "/swagger*").permitAll()
//                .antMatchers("/user/updatePassword*","/user/savePassword*","/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
//                .anyRequest().hasAuthority("READ_PRIVILEGE")
//                .and()
//                    .formLogin()
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/welcome")
//                        .failureUrl("/login?error=true").permitAll()
//                .and()
//                    .logout()
//                        .deleteCookies("JSESSIONID")
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login");
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.csrf().disable()
                .formLogin().disable();
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}
