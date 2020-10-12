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
                String query="INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?,?);";
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

        PreparedStatement ps=null;
        ResultSet rs=null;
        try(Connection conexion = dbConnect.getConnection()){
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
            }
        }catch (SQLException e) {
            System.out.println("No se pudieron encontrar los mensajes");
            System.out.println(e);
        }
    }
    public static void borrarMensajeDB(int idMensaje){

    }
    public static void actualizarMensajeDB(Mensajes mensajes){

    }


}
