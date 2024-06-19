/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.models;

/**
 *
 * @author ALEXANDRE
 */
public class Lendings {
    private String nome;
    private int user_id;
    private int book_id;
    private int date_out;
    private int date_return;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getDate_out() {
        return date_out;
    }

    public void setDate_out(int date_out) {
        this.date_out = date_out;
    }

    public int getDate_return() {
        return date_return;
    }

    public void setDate_return(int date_return) {
        this.date_return = date_return;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }
}
