package main.java.com.biblioteca.controller;

// MembroController é a Celula

public class MembroController {
    private MembroController next;
    private Object element;
    private MembroController previous;
    
    public MembroController(MembroController next, Object element){
        this.next = next;
        this.element = element;
    }
    
    public MembroController(Object element){
        this.element = element;
    }
    
    public void setNext(MembroController next){
        this.next = next;
    }
    
    public MembroController getNext(){
        return next;
    }
    
    public Object getElement(){
        return element;
    }

    public MembroController getPrevious(){
        return previous;
    }

    public void setPrevious(MembroController previous){
        this.previous = previous;
    }
}
