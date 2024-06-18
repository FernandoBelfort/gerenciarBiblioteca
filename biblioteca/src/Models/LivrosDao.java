package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LivrosDao {

    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Livros lb) {
        String sql = "INSERT INTO livros (titulo, id_autor, id_editora, id_materia, quantidade, num_pag, ano_edicao) VALUES (?,?,?,?,?,?,?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, lb.getTitulo());
            ps.setInt(2, lb.getAutor());
            ps.setInt(3, lb.getEditora());
            ps.setInt(4, lb.getMateria());
            ps.setInt(5, lb.getQuantidade());
            ps.setInt(6, lb.getNum_pag());
            ps.setInt(7, lb.getAno_edicao());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Livros lb) {
        boolean res;
        String sql = "UPDATE livros SET titulo=?, id_autor=?, id_editora=?, id_materia=?, quantidade=?, num_pag=?, ano_edicao=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, lb.getTitulo());
            ps.setInt(2, lb.getAutor());
            ps.setInt(3, lb.getEditora());
            ps.setInt(4, lb.getMateria());
            ps.setInt(5, lb.getQuantidade());
            ps.setInt(6, lb.getNum_pag());
            ps.setInt(7, lb.getAno_edicao());
            ps.setInt(8, lb.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Livros> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT l.*, e.id AS id_editora, e.editora, a.id AS id_autor, a.autor, m.id AS id_materia, m.materia FROM livros l INNER JOIN editora e ON e.id = l.id_editora INNER JOIN autor a ON a.id = l.id_autor INNER JOIN materia m ON m.id = l.id_materia ORDER BY l.id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT l.*, e.id AS id_editora, e.editora, a.id AS id_autor, a.autor, m.id AS id_materia, m.materia FROM livros l INNER JOIN editora e ON e.id = l.id_editora INNER JOIN autor a ON a.id = l.id_autor INNER JOIN materia m ON m.id = l.id_materia WHERE l.titulo LIKE '%" + valor + "%' OR e.editora LIKE '%" + valor + "%' OR m.materia LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Livros lb = new Livros();
                lb.setId(rs.getInt("id"));
                lb.setTitulo(rs.getString("titulo"));
                lb.setAutor(rs.getInt("id_autor"));
                lb.setEditora(rs.getInt("id_editora"));
                lb.setMateria(rs.getInt("id_materia"));
                lb.setQuantidade(rs.getInt("quantidade"));
                lb.setNum_pag(rs.getInt("num_pag"));
                lb.setAno_edicao(rs.getInt("ano_edicao"));
                lb.setNome_autor(rs.getString("autor"));
                lb.setNome_editora(rs.getString("editora"));
                lb.setNome_materia(rs.getString("materia"));
                lista.add(lb);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";
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

    public Combinacao getAutor(String valor) {
        Combinacao lb = new Combinacao();
        String sql = "SELECT * FROM autor WHERE autor = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, valor);
            rs = ps.executeQuery();
            if (rs.next()) {
                lb.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lb;
    }
    
    public Combinacao getEditora(String valor) {
        Combinacao lb = new Combinacao();
        String sql = "SELECT * FROM editorial WHERE editorial = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, valor);
            rs = ps.executeQuery();
            if (rs.next()) {
                lb.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lb;
    }

    public Combinacao getMateria(String valor) {
        Combinacao lb = new Combinacao();
        String sql = "SELECT * FROM materia WHERE materia = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, valor);
            rs = ps.executeQuery();
            if (rs.next()) {
                lb.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lb;
    }
}
