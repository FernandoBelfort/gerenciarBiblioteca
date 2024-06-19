package br.com.biblioteca.ilib;

import br.com.biblioteca.db.Database;
import br.com.biblioteca.interfaces.UsersDAO;
import br.com.biblioteca.models.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALEXANDRE
 */
public class UsersDAOImpl extends Database implements UsersDAO{

    @Override
    public void registrar(Users user) throws Exception {
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users(name, endereco, telefone, email) VALUES(?, ?, ?);");
            st.setString(1, user.getNome());
            st.setString(2, user.getEndereco());
            st.setString(3, user.getTelefone());
            st.executeUpdate();
            st.close();
        } catch(Exception e){
            throw e;
        } finally {
            this.Encerrar();
        }
    }

    @Override
    public void modificar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Users user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Users> listar() throws Exception {
        List<Users> lista = null;
        try{
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users;");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("name"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setEmail(rs.getString("email"));
                lista.add(user);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            throw e;
        } finally {
            this.Encerrar();
        }
        return lista;
    }
    
}
