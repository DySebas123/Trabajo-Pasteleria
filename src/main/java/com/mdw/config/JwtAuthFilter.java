package com.mdw.config;

import com.mdw.service.JwtUtils;
import com.mdw.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;

    // Inyección por constructor 
    public JwtAuthFilter(JwtUtils jwtUtils, CustomUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws IOException, ServletException {

        String token = extractToken(request); // Extrae el token del encabezado Authorization

        // Solo procesamos si hay token válido
        if (token != null && jwtUtils.validateToken(token)) {

            // Obtiene el username del token
            String username = jwtUtils.getUsernameFromToken(token);

            // Verificamos que aún no exista autenticación en el contexto
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // Carga los detalles del usuario a partir del username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Validación extra 
                if (jwtUtils.validateToken(token)) {
                    // Crea el objeto de autenticación con los roles del usuario
                    UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    // Agrega detalles del request (por ejemplo, IP, sesión)
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Establece la autenticación en el contexto de seguridad
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        // Continúa con el resto de filtros
        chain.doFilter(request, response);
    }

    // Método para extraer el token JWT del encabezado Authorization
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); 
        }
        return null;
    }
}
