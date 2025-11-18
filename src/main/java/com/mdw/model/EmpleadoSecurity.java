package com.mdw.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "empleados_security")
public class EmpleadoSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "empleado_roles", joinColumns = @JoinColumn(name = "empleado_id"))
    @Column(name = "role_name", nullable = false)
    private Set<String> roles;

    // Constructores
    public EmpleadoSecurity() {}
    
    public EmpleadoSecurity(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}