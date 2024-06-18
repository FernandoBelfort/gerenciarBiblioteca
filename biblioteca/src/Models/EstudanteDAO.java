package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudanteDAO {
    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Estudante est) {
        String sql = "INSERT INTO estudantes (documento, codigo, nome, telefone, carreira) VALUES (?,?,?,?,?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, est.getDocumento());
            ps.setString(2, est.getCodigo());
            ps.setString(3, est.getNome());
            ps.setString(4, est.getTelefone());
            ps.setString(5, est.getCarreira());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Estudante est) {
        boolean res;
        String sql = "UPDATE estudantes SET documento=?, codigo=?, nome=?, telefone=?, carreira=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, est.getDocumento());
            ps.setString(2, est.getCodigo());
            ps.setString(3, est.getNome());
            ps.setString(4, est.getTelefone());
            ps.setString(5, est.getCarreira());
            ps.setInt(6, est.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Estudante> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM estudantes ORDER BY id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM estudantes WHERE nome LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudante est = new Estudante();
                est.setId(rs.getInt("id"));
                est.setDocumento(rs.getString("documento"));
                est.setCodigo(rs.getString("codigo"));
                est.setNome(rs.getString("nome"));
                est.setTelefone(rs.getString("telefone"));
                est.setCarreira(rs.getString("carreira"));
                lista.add(est);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM estudante WHERE id = ?";
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
