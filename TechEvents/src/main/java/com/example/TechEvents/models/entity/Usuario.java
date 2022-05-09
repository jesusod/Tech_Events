package com.example.TechEvents.models.entity;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;


    private String password;



   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_eventos",
            joinColumns = @JoinColumn(
                    name = "usuarios_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "eventos_id"))
            private Collection < Evento > eventos;


    public Usuario(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Usuario(){

    }

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }


   /*@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name="usuarios_eventos",
            joinColumns = @JoinColumn(name="id_usuarios"),
            inverseJoinColumns = @JoinColumn (name="id_eventos"))
            private Set<Evento> eventos = new HashSet<>();*/




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Collection<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
