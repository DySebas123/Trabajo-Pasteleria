package com.mdw.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 200, nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "precio", length = 10, nullable = false)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precio;

    @Column(name = "stock", length = 200, nullable = false)
    private Integer stock;

    @Column(name = "imagen_url", length = 200, nullable = false) // <-- CORREGIDO
    private String imagenUrl;

    // GETTER Y SETTER

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public BigDecimal getPrecio() {
            return precio;
        }
        public void setPrecio(BigDecimal precio) {
            this.precio = precio;
        }
        public Integer getStock() {
            return stock;
        }
        public void setStock(Integer stock) {
            this.stock = stock;
        }
        public String getImagenUrl() {
            return imagenUrl;
        }
        public void setImagenUrl(String imagenUrl) {
            this.imagenUrl = imagenUrl;
        }
}
