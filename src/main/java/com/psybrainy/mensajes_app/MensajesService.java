package com.psybrainy.mensajes_app;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje=sc.nextLine();

        System.out.println("Tu Nombre");
        String nombre=sc.nextLine();

        Mensajes registro= new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();

    }
    public static void borrarMensaje(){

    }
    public static void editarMensaje(){

    }
}