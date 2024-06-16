package main.java.com.biblioteca;
import main.java.com.biblioteca.view.MembroView;

public class App{
    
    public static void main(String[] args){
        MembroView lista = new MembroView();

        lista.adiciona("Lucas");
        lista.adiciona("Pedro");
        lista.adiciona("Erik");
        lista.adiciona("Fernando");

        System.out.println(lista);
    }
}

































































// import main.java.com.biblioteca.model.Membro;
// import main.java.com.biblioteca.model.Livro;
// import java.util.Scanner;

// public class App {
//     public static void main(String[] args){
        

//         Scanner scanner = new Scanner(System.in);
//         System.out.println("\tver dados:\n1. livros\n2. membros\n3. emprestimos");
//         int res = scanner.nextInt();
        
//         Membro p1 = new Membro();
//         Livro l1 = new Livro();

//         boolean aux = false;
        
//         while (!aux) {
//             aux = true;
//             if (res == 1) {
//                 System.out.println("\t--------------------DADOS DO USUARIO-------------------------");
//                 p1.setName("Fernando");
//                 p1.setId(171);
                
//                 System.out.format("\tNome: %s\n \tEmail: %s\n \tId: %d\n \tNascimento: %s\n", p1.getName(), p1.getEndereco(), p1.getId(), p1.getNascimento());
//                 System.out.println("\t-------------------------------------------------------------"); 
//             } else if (res == 2){
//                 System.out.println("\t--------------------DADOS DO LIVRO-------------------------");
//                 l1.setTitular("cuntakinte");
//                 l1.setAuthor("Samuel L. Jackson");
//                 l1.setPublicacao("02/05/1814");
//                 l1.setGenero("Drama");
//                 l1.setIsbn("19-25-87-b-2");
                
//                 System.out.format("\tNome: %s\n \tAuthor: %s\n \tPublicação: %s\n \tGenero: %s\n \tGenero: %s\n \tISBN: %s", l1.getTitular(), l1.getAuthor(), l1.getPublicacao(), l1.getGenero(), l1.getIsbn());
//                 System.out.println("\t-------------------------------------------------------------");
//             }
//             scanner.close();
//         }
//     }
// }
