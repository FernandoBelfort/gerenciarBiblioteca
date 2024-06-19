/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.biblioteca.interfaces;

import br.com.biblioteca.models.Lendings;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public interface LendingsDAO {
    public void registrar(Lendings user) throws Exception;
    public void modificar(Lendings user) throws Exception;
    //public void eliminar(Lendings user) throws Exception;
    public List<Lendings> listar()throws Exception;
}
