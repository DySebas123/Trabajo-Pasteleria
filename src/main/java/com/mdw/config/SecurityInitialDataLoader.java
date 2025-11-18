package com.mdw.config;

import com.mdw.model.EmpleadoSecurity;
import com.mdw.repository.EmpleadoSecurityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Configuration
public class SecurityInitialDataLoader {

    @Bean
    CommandLineRunner loadInitialSecurityData(EmpleadoSecurityRepository empleadoRepo,
                                           PasswordEncoder passwordEncoder) {
        return args -> {
            if (empleadoRepo.count() == 0) {
                // Empleados con roles
                EmpleadoSecurity admin = new EmpleadoSecurity(
                    "adminJose",
                    passwordEncoder.encode("Admin123"),
                    Set.of("ADMIN")
                );          
                EmpleadoSecurity empleado1 = new EmpleadoSecurity(
                    "Dylan",
                    passwordEncoder.encode("Dylan123"),
                    Set.of("EMPLEADO")
                );
                EmpleadoSecurity empleado2 = new EmpleadoSecurity(
                    "Carlos",
                    passwordEncoder.encode("Carlos123"),
                    Set.of("EMPLEADO") 
                );
                EmpleadoSecurity empleado3 = new EmpleadoSecurity(
                    "Ramiro",
                    passwordEncoder.encode("Ramiro456"),
                    Set.of("EMPLEADO")
                );
                EmpleadoSecurity empleado4 = new EmpleadoSecurity(
                    "Gabriel",
                    passwordEncoder.encode("Gabriel456"),
                    Set.of("EMPLEADO")
                );
                
                // Persistencia
                empleadoRepo.save(admin);
                empleadoRepo.save(empleado1);
                empleadoRepo.save(empleado2);
                empleadoRepo.save(empleado3);
                empleadoRepo.save(empleado4);
                
                System.out.println("Datos iniciales de seguridad cargados exitosamente");
            }
        };
    }
}