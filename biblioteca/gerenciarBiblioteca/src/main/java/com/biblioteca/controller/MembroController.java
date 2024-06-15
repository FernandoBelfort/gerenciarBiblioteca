package main.java.com.biblioteca.controller;
import java.util.Arrays;
import main.java.com.biblioteca.model.Membro;

public class MembroController {
    private Membro[] users = new Membro[10];

    private int totalDeMembros = 0; 

    private void garantaEspaco(){
        if(this.totalDeMembros == this.users.length){
            Membro[] novaArray = new Membro[this.users.length * 2];
            for(int i = 0; i < this.users.length; i++){
                novaArray[i] = this.users[i];
            }
            this.users = novaArray;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao < this.users.length && posicao >= 0;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= this.totalDeMembros;
    }

    public void adiciona(Membro user){
        this.garantaEspaco();
        this.users[this.totalDeMembros] = user;
        this.totalDeMembros++;
    }

    public void adiciona_posicao(int posicao, Membro user){
        this.garantaEspaco();
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }

        for(int i = this.totalDeMembros - 1; i >= posicao; i-=1){
            this.users[i + 1] = this.users[i];
        }

        this.users[posicao] = user;
        this.totalDeMembros++;
    }

    public Membro pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.users[posicao];
    }

    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for(int i = posicao; i < this.totalDeMembros - 1; i++){
            this.users[i] = this.users[i + 1];
        }
        this.totalDeMembros--;
    }

    public boolean contem(Membro user){
        for(int i = 0; i < this.totalDeMembros; i++){
            if(user.equals(this.users[i])){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return this.totalDeMembros;
    }

    public String toString(){
        return Arrays.toString(users);
    }

    public Membro[] getPerson(){
        return users;
    }

    public int getTotalDeMembros(){
        return totalDeMembros;
    }
}
