package main.java.com.biblioteca.model;

// Membro é AlunoLista

public class Membro{
    private String name;
    private int id;
    private Membro next;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}