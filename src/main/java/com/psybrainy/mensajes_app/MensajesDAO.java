package com.psybrainy.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensajes){
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps=null;
            try {
                String query="INSERT INTO mensajes (mensaje, id_usuario) VALUES (?,?);";
                ps=conexion.prepareStatement(query);
                ps.setString(1,mensajes.getMensaje());
                ps.setString(2,mensajes.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            }catch (SQLException e){
                System.out.println(e);

            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void leerMensajeDB(){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            ResultSet rs=null;
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("id_usuario"));
                System.out.println("Fecha: "+rs.getString("fecha"));
            }
        }catch (SQLException e) {
            System.out.println("No se pudieron encontrar los mensajes");
            System.out.println(e);
        }
    }
    public static void borrarMensajeDB(int idMensaje){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            try {
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1,idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");

            }catch (SQLException e){
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }

        }catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void actualizarMensajeDB(Mensajes mensajes){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            try {
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setInt(2,mensajes.getIdMensaje());
                ps.executeUpdate();
                System.out.println("El menaje se actualizo correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }


}
