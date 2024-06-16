package main.java.com.biblioteca.view;
import main.java.com.biblioteca.controller.MembroController;

// MembroView é ListaLigada

public class MembroView {
    private MembroController first;
    private MembroController last;

    // variavel para contagem de elementos e algumas operações
    private int totalElement;

    // Verifica se a posição está ocupada
    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalElement;
    }

    private MembroController pegaCelula(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }

        MembroController current = first;
        for(int i = 0; i < posicao; i++){
            current = current.getNext();
        }
        return current;
    }

    // função para adicionar na lista
    public void adiciona(Object element){
        if(this.totalElement == 0){
            this.adicionaNoComeco(element);
        } else {
            MembroController nova = new MembroController(element);
            this.last.setNext(nova);
            nova.setPrevious(this.last);
            this.last = nova;
            this.totalElement++;
        }
    }

    public void adicionaPosicao(int posicao, Object element){
        if(posicao == 0){ // No começo
            this.adicionaNoComeco(element);
        } else if(posicao == this.totalElement){ // No fim
            this.adiciona(element);
        } else {
            MembroController previous = this.pegaCelula(posicao - 1);
            MembroController next = previous.getNext();
            MembroController nova = new MembroController(previous.getNext(), element);
            nova.setPrevious(previous);
            previous.setNext(nova);
            next.setPrevious(nova);
            this.totalElement++;
        }
    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElement();
    }

    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("posição não existe");
        }

        if(posicao == 0){
            this.removeDoComeco();
        } else if(posicao == this.totalElement - 1){
            this.removeDoFim();
        } else {
            MembroController previous = this.pegaCelula(posicao - 1);
            MembroController currrent = previous.getNext();
            MembroController next = currrent.getNext();

            previous.setNext(next);
            next.setPrevious(previous);

            this.totalElement--;
        }
    }

    public int tamanho(){
        return this.totalElement;
    }

    public boolean contem(Object element){
        MembroController current = this.first;

        while(current != null){
            if(current.getElement().equals(element)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void adicionaNoComeco(Object element){
        if(this.totalElement == 0){
            MembroController nova = new MembroController(element);
            this.first = nova;
            this.last = nova;
        } else {
            MembroController nova = new MembroController(this.first, element);
            this.first.setPrevious(nova);
            this.first = nova;
        }
        this.totalElement++;
    }

    public void removeDoComeco(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }

        this.first = this.first.getNext();
        this.totalElement--;

        if(this.totalElement == 0){
            this.last = null;
        }
    }

    public void removeDoFim(){
        if(!this.posicaoOcupada(this.totalElement - 1)){
            throw new IllegalArgumentException("Posição não existe");
        }
        if(this.totalElement == 1){
            this.removeDoComeco();
        } else {
            MembroController penultimate = this.last.getPrevious();
            penultimate.setNext(null);
            this.last = penultimate;
            this.totalElement--;
        }
    }

    public String toString(){
        //Verifica se a lista está vazia
        if(this.totalElement == 0){
            return " [] ";
        }

        StringBuilder builder = new StringBuilder(" [");
        MembroController current = first;

        // Percorrendo até o penúltimo elemento
        for(int i = 0; i < this.totalElement - 1; i++){
            builder.append(current.getElement());
            builder.append(", ");
            current = current.getNext();
        }

        // último elemento
        builder.append(current.getElement());
        builder.append("] ");

        return builder.toString();
    }
}
