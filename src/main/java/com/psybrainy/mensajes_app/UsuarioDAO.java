package com.psybrainy.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static void crearUsuarioDB(Usuario usuario){
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            try{
                String query="INSERT INTO usuarios (correo , clave , nombre_completo) VALUES (?,?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombreCompleto());
                ps.executeUpdate();
                System.out.println("Usuario creado correctamente");
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerUsuarioDB(){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            ResultSet rs=null;
            String query="SELECT * FROM usuarios";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+ rs.getInt("id_usuario"));
                System.out.println("Nombre Completo: "+rs.getString("nombre_completo"));
                System.out.println("Correo: "+rs.getString("correo"));
            }
        }catch (SQLException e) {
            System.out.println(e);
            System.out.println("No se pudo encontrar los usuarios");
        }
    }

    public static void editarUsuario(Usuario usuario){
        Conexion dbConnect = new Conexion();

        try(Connection conexion = dbConnect.getConnection()){
            PreparedStatement ps=null;
            try {
                String query="UPDATE usuarios SET correo = ? and clave = ? and nombre_completo = ? WHERE id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombreCompleto());
                ps.setInt(4, usuario.getIdUsuario());
                ps.executeUpdate();
                System.out.println("El usuario se ha actualizado correctamente");

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el usuario");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static Usuario iniciarSesionDB(Usuario usuario){
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM usuarios WHERE correo= ? and clave= ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                rs=ps.executeQuery();

                Usuario login = new Usuario();

                if (rs.next()) {
                    System.out.println("Login correcto!");
                    login.setIdUsuario(rs.getInt("id_usuario"));
                    login.setCorreo(rs.getString("correo"));
                    login.setNombreCompleto(rs.getString("nombre_completo"));
                } else {
                    System.out.println("Login fallido");
                }
                return login;

            } catch (SQLException e) {
                System.out.println("\nNo se pudo autenticar con el servidor\n");
            }
        }catch (Exception ex){
            System.out.println(ex);
            System.out.println("??");
        }
        return null;
    }
}
