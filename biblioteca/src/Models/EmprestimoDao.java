
package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmprestimoDao {
    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Emprestimo pre) {
        String sql = "INSERT INTO emprestimo (id_estudante, id_livro, quantidade, fechar_emprestimo, fechar_devolucioao) VALUES (?,?,?,?,?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, pre.getEstudante());
            ps.setInt(2, pre.getLivro());
            ps.setInt(3, pre.getQuantidade());
            ps.setString(4, pre.getFechar_emprestimo());
            ps.setString(5, pre.getFechar_devolucao());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(int id) {
        boolean res;
        String sql = "UPDATE emprestimo SET estado=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, id);
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Emprestimo> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT p.*, l.id AS id_livro, l.titulo, e.id AS id_est, e.nome FROM emprestimo p INNER JOIN livro l ON l.id = p.id_livro INNER JOIN estudante e ON e.id = p.id_estudante ORDER BY p.id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT p.*, l.id AS id_livro, l.titulo, e.id AS id_est, e.nome FROM emprestimo p INNER JOIN livro l ON l.id = p.id_livro INNER JOIN estudante e ON e.id = p.id_estudante WHERE e.nome LIKE '%" + valor + "%' OR l.titulo LIKE '%" + valor + "%' OR p.fechae_emprestimo LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Emprestimo pre = new Emprestimo();
                pre.setId(rs.getInt("id"));
                pre.setTitulo(rs.getString("titulo"));
                pre.setNome_estudante(rs.getString("nome"));
                pre.setQuantidade(rs.getInt("quantidade"));
                pre.setFechar_emprestimo(rs.getString("fechar_emprestimo"));
                pre.setFechar_devolucao(rs.getString("fechar_devolução"));
                pre.setEstado(rs.getInt("estado"));
                lista.add(pre);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

}
