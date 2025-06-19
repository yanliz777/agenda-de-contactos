package org.yf.edu.co.Agenda_De_Contactos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Debe ingresar su nombre")
    private String nombre;
    @NotEmpty(message = "Debe ingresar su email")
    @Email
    private String email;
    @NotBlank(message = "Debe ingresar su celular")
    private String celular;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    @NotNull(message = "Debe ingresar su fecha de nacimiento")
    private LocalDate fechaNacimeinto;
    private LocalDateTime fechaRegistro;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String email, String celular, LocalDate fechaNacimeinto, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.fechaNacimeinto = fechaNacimeinto;
        this.fechaRegistro = fechaRegistro;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getFechaNacimeinto() {
        return fechaNacimeinto;
    }

    public void setFechaNacimeinto(LocalDate fechaNacimeinto) {
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    //@PrePersist: Praa que cuando agregue una entidad para persistir la fecha de hoy
    @PrePersist
    public void asignarFechaDeRegistro(){
       fechaRegistro = LocalDateTime.now();
    }
}
