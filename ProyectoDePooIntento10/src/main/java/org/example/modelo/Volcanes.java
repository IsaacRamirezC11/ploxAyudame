package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class Volcanes {
    private int id;
    private String nombre;
    private String ubicacion;
    private int altura;
    private String estado;
    private String urlFoto;

    public Volcanes() {
    }

    public Volcanes(int id, String nombre, String ubicacion, int altura, String estado, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.altura = altura;
        this.estado = estado;
        this.urlFoto = urlFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Volcanes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", altura=" + altura +
                ", estado='" + estado + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.urlFoto);
        return new ImageIcon(urlImage);
    }

}
