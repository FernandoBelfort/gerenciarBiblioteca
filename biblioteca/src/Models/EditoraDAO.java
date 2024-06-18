package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EditoraDAO {
    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Editora ed) {
        String sql = "INSERT INTO editorial (editorial) VALUES (?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, ed.getEditora());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Editora ed) {
        boolean res;
        String sql = "UPDATE editorial SET editorial=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, ed.getEditora());
            ps.setInt(2, ed.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Editora> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM editorial ORDER BY id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM editorial WHERE editorial LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Editora ed = new Editora();
                ed.setId(rs.getInt("id"));
                ed.setEditora(rs.getString("editorial"));
                lista.add(ed);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM editorial WHERE id = ?";
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
