package com.mdw.service;

import com.mdw.model.EmpleadoSecurity;
import com.mdw.repository.EmpleadoSecurityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmpleadoSecurityRepository empleadoSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Para buscar los empleados
        EmpleadoSecurity empleado = empleadoSecurityRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        
        Set<SimpleGrantedAuthority> authorities = empleado.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
            .collect(Collectors.toSet());
        
        return new org.springframework.security.core.userdetails.User(
            empleado.getUsername(),
            empleado.getPassword(),
            authorities
        );
    }
}