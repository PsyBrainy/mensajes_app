package com.psybrainy.mensajes_app;

public class Usuario {

    int idUsuario;
    String correo;
    String clave;
    String nombreCompleto;

    public Usuario(){
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(int idUsuario, String correo, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreCompleto = nombreCompleto;
    }

    public Usuario(int idUsuario, String correo, String clave, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
