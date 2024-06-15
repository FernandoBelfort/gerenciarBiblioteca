package main.java.com.biblioteca.model;

public class Livro{
    private String titular;
    private String author;
    private String genero;

    public Livro() {}

    public Livro(String titular, String author, String publicacao, String genero, String isbn){
        this.titular = titular;
        this.author = author;
        this.genero = genero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
