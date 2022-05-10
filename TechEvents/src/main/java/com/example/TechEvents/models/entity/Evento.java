package com.example.TechEvents.models.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="eventos")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String user_max;

    private String fecha_hora;

    private String img;




/*    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name="usuarios_eventos",
            joinColumns = @JoinColumn(name="id_usuarios"),
            inverseJoinColumns = @JoinColumn (name="id_eventos"))
    private Set<Usuario> usuarios = new HashSet<>();*/

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_eventos",
            joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "evento_id", referencedColumnName = "id"))
    private Collection< Evento > eventos;*/



 /*   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @JoinTable(name = "eventos_usuarios",
            joinColumns ={@JoinColumn(name="eventos_id")},
            inverseJoinColumns = {@JoinColumn(name="usuarios_id")})
    private List<Usuario> usuarios = new ArrayList<Usuario>();*/
@ManyToMany(mappedBy = "eventos")
    private Collection < Usuario > usuarios;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUser_max() {
        return user_max;
    }

    public void setUser_max(String user_max) {
        this.user_max = user_max;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /*public Evento(String titulo) {
        this.titulo = titulo;
    }*/

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", user_max='" + user_max + '\'' +
                ", fecha_hora='" + fecha_hora + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

}