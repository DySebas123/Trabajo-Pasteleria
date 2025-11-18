package com.mdw.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
public class Critica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(message = "Debe seleccionar un cliente")
    private Cliente cliente;

    @NotBlank(message = "La crítica no puede estar vacía")
    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fecha;
}
