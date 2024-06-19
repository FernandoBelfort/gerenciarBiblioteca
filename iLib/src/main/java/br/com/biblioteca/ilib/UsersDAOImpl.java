/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.ilib;

import br.com.biblioteca.db.Database;
import br.com.biblioteca.interfaces.UsersDAO;
import br.com.biblioteca.models.Users;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public class UsersDAOImpl extends Database implements UsersDAO{

    @Override
    public void registrar(Users user) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSER INTO users(id, name, endereco, email, telefone) VALUES(?, ?, ?, ?, ?);");
            //st.setString(1, user.getId());
           // st.setString(2, user.getName());
        } catch(Exception e){
            throw e;
        } finally {
            this.Encerrar();
        }
    }

    @Override
    public void modificar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Users> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
