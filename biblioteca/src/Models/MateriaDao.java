
package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaDao {
    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Materia mt) {
        String sql = "INSERT INTO materia (materia) VALUES (?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, mt.getMateria());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Materia mt) {
        boolean res;
        String sql = "UPDATE materia SET materia=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, mt.getMateria());
            ps.setInt(2, mt.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Materia> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM materia ORDER BY id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM materia WHERE materia LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia mt = new Materia();
                mt.setId(rs.getInt("id"));
                mt.setMateria(rs.getString("materia"));
                lista.add(mt);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM materia WHERE id = ?";
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
