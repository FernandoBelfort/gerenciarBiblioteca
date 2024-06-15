package main.java.com.biblioteca.view;
import main.java.com.biblioteca.model.Membro;
import main.java.com.biblioteca.controller.MembroController;

public class MembroView {
    public static void main(String[] args){
        Membro u1 = new Membro();
        Membro u2 = new Membro();

        u1.setName("Lucas");
        u2.setName("Pedro");

        MembroController lista = new MembroController();

        lista.adiciona(u1);
        lista.adiciona(u2);
        lista.adiciona_posicao(0, u1);

        System.out.println(lista);
    }
}
