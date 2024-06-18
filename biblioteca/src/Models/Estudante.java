package Models;

public class Estudante {
    private int id;
    private String documento;
    private String codigo;
    private String nome;
    private String telefone;
    private String carreira;

    public Estudante(){}

    public Estudante(int id, String documento, String codigo, String nome, String telefone, String carreira){
        this.id = id;
        this.documento = documento;
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.carreira = carreira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCarreira() {
        return carreira;
    }

    public void setCarreira(String carreira) {
        this.carreira = carreira;
    }
}



