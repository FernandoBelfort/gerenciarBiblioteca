package main.java.com.biblioteca.model;
import main.java.com.biblioteca.controller.MembroController;

public class Membro{
    private String name;

    public Membro() {}

    MembroController obj = new MembroController();

    MembroController obj2 = new MembroController();

    Membro[] array = obj.getPerson();

    int totalMembro = obj2.getTotalDeMembros();

    public Membro(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        if(this.array.length == 0){
            return " [] ";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(" [");

        for(int i = 0; i < this.totalMembro - 1; i++){
            builder.append(this.array[i]);
            builder.append(", ");
        }

        builder.append(this.array[this.totalMembro - 1]);
        builder.append("] ");

        return builder.toString();
    }

    public boolean equals(Object o){
        Membro outro = (Membro)o;
        return this.name.equals(outro.name);
    }
}
