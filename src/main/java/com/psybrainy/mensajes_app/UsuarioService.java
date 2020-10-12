package com.psybrainy.mensajes_app;

import java.util.Scanner;

public class UsuarioService {

    public static void crearUsuario(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un correo");
        String correo=sc.nextLine();

        System.out.println("Escriba una clave");
        String clave=sc.nextLine();

        System.out.println("Escriba su nombre completo");
        String nombreCompleto=sc.nextLine();

        Usuario registro =new Usuario();
        registro.setCorreo(correo);
        registro.setClave(clave);
        registro.setNombreCompleto(nombreCompleto);
        UsuarioDAO.crearUsuarioDB(registro);

    }

    public static void listarUsuarios(){
        UsuarioDAO.leerUsuarioDB();
    }

    public static void editarUsuario(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Indique el nuevo correo");
        String correo= sc.nextLine();

        System.out.println("Indique su nueva clave");
        String clave= sc.nextLine();

        System.out.println("Indique su nuevo nombre");
        String nombre= sc.nextLine();

        Usuario edicion = new Usuario();

        edicion.setCorreo(correo);
        edicion.setClave(clave);
        edicion.setNombreCompleto(nombre);
        UsuarioDAO.editarUsuario(edicion);
    }

    public static Usuario iniciarSesion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique su correo");
        String correo = sc.nextLine();
        System.out.println("Indique su clave");
        String clave = sc.nextLine();

        Usuario login = new Usuario(correo,clave);
        Usuario resultado = UsuarioDAO.iniciarSesionDB(login);

        return resultado;
    }

    /*private static String cifrarMD5(String clave) {
        String md5Hex = DigestUtils.md5Hex(clave);
    }*/
}












