package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AutorDAO {
    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Autor au){
        String sql = "INSERT INTO autor (autor) VALUES (?)";
        conexao = cn.getConnection();
        try{
            ps = conexao.prepareStatement(sql);
            ps.setString(1, au.getAutor());
            ps.execute();
            return true;
        } catch (SQLException ex){
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Autor au) {
        boolean res;
        String sql = "UPDATE autor SET autor=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, au.getAutor());
            ps.setInt(2, au.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Autor> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM autor ORDER BY id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM autor WHERE autor LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor au = new Autor();
                au.setId(rs.getInt("id"));
                au.setAutor(rs.getString("autor"));
                lista.add(au);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM autor WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
}
