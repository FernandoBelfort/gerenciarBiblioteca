/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.biblioteca.interfaces;

import br.com.biblioteca.models.Users;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public interface UsersDAO {
    public void registrar(Users user) throws Exception;
    public void modificar(Users user) throws Exception;
    public void eliminar(Users user) throws Exception;
    public List<Users> listar()throws Exception;
    
}
