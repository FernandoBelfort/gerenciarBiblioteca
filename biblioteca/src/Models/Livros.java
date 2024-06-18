package Models;

public class Livros {
    private int id;
    private String titulo;
    private int autor;
    private int editora;
    private int materia;
    private int quantidade;
    private int num_pag;
    private int ano_edicao;
    private String nome_autor;
    private String nome_editora;
    private String nome_materia;

    public Livros(){}

    public Livros(int id, String titulo, int autor, int editora, int materia, int quantidade, int num_pag, int ano_edicao, String nome_autor, String nome_editora, String nome_materia){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.materia = materia;
        this.quantidade = quantidade;
        this.num_pag = num_pag;
        this.ano_edicao = ano_edicao;
        this.nome_autor = nome_autor;
        this.nome_editora = nome_editora;
        this.nome_materia = nome_materia;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getEditora() {
        return editora;
    }

    public void setEditora(int editora) {
        this.editora = editora;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public int getAno_edicao() {
        return ano_edicao;
    }

    public void setAno_edicao(int ano_edicao) {
        this.ano_edicao = ano_edicao;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getNome_editora() {
        return nome_editora;
    }

    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }

    public String getNome_materia() {
        return nome_materia;
    }

    public void setNome_materia(String nome_materia) {
        this.nome_materia = nome_materia;
    }
}
