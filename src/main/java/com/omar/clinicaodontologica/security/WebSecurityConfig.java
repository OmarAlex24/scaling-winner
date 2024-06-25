package com.omar.clinicaodontologica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
//    @Autowired
//    private UsuarioService usuarioService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    //proveedor de autenticaciones DAO
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        //aca debe venir el usuario y desencriptador de claves
//        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
//        provider.setUserDetailsService(usuarioService);
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        return provider;
//    }
//    //aca deberiamos hablar de las autorizaciones
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authz)-> authz
//                        .requestMatchers("/post_odontologos.html","/get_odontologos.html")
//                        .hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults())
//                .logout(withDefaults());
//        return http.build();
//
//    }
}
