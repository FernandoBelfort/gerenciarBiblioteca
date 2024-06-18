package Models;

public class Editora {
    private int id;
    private String editora;

    public Editora(){}

    public Editora(int id, String editora){
        this.id = id;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString(){
        return this.getEditora();
    }
}
