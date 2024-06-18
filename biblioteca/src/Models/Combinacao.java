package Models;

public class Combinacao {
    private int id;
    private String nome;

    public Combinacao(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Combinacao(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
