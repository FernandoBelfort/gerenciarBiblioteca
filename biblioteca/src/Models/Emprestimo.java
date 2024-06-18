package Models;

public class Emprestimo {
    private int id;
    private int estudante;
    private String nome_estudante;
    private int livro;
    private String titulo;
    private int quantidade;
    private String fechar_emprestimo;
    private String fechar_devolucao;
    private int estado;

    public Emprestimo(){}

    public Emprestimo(int id, int estudante, String nome_estudante, int livro, String titulo, int quantidade, String fechar_emprestimo, String fechar_devolucao, int estado){
        this.id = id;
        this.estudante = estudante;
        this.nome_estudante = nome_estudante;
        this.livro = livro;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.fechar_emprestimo = fechar_emprestimo;
        this.fechar_devolucao = fechar_devolucao;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudante() {
        return estudante;
    }

    public void setEstudante(int estudante) {
        this.estudante = estudante;
    }

    public String getNome_estudante() {
        return nome_estudante;
    }

    public void setNome_estudante(String nome_estudante) {
        this.nome_estudante = nome_estudante;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFechar_emprestimo() {
        return fechar_emprestimo;
    }

    public void setFechar_emprestimo(String fechar_emprestimo) {
        this.fechar_emprestimo = fechar_emprestimo;
    }

    public String getFechar_devolucao() {
        return fechar_devolucao;
    }

    public void setFechar_devolucao(String fechar_devolucao) {
        this.fechar_devolucao = fechar_devolucao;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
