/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.biblioteca.interfaces;

import br.com.biblioteca.models.Books;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public interface BooksDAO {
    public void registrar(Books user) throws Exception;
    public void modificar(Books user) throws Exception;
    public void eliminar(Books user) throws Exception;
    public List<Books> listar()throws Exception;
}
