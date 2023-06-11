package com.zera.store.security

import com.zera.store.account.service.AccountUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig (val accountUserService: AccountUserService, val passwordEncoder: PasswordEncoder) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { crsf -> crsf.disable() }
            .authorizeHttpRequests { authorize -> authorize
                .requestMatchers("/account/register")
                    .permitAll()
                .requestMatchers("/account/admin**").hasAuthority("ADMIN")
                .requestMatchers("/product**").hasAnyAuthority("ADMIN", "CUSTOMER")
                    .anyRequest().authenticated()
            }
            .formLogin(withDefaults())
            .httpBasic(withDefaults())
        return http.build()
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider? {
        val provider = DaoAuthenticationProvider()
        provider.setPasswordEncoder(passwordEncoder)
        provider.setUserDetailsService(accountUserService)
        return provider
    }

}
