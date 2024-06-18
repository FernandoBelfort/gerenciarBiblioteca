package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    Connection conexao;

    public Connection getConnection(){
        try{
            String db = "jdbc:mysql://localhost:3306/biblio";
            conexao = DriverManager.getConnection(db, "root", "");
            return conexao;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro na conexão. " + e.getMessage());
        }
        return null;
    }
    
}
