package Models;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao {

    Connection conexao;
    Conexao cn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Usuario us) {
        String sql = "INSERT INTO usuario (usuario, nome, email, senha) VALUES (?,?,?,?)";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getNome());
            ps.setString(3, us.getEmail());
            ps.setString(4, us.getSenha());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean atualizar(Usuario reg) {
        boolean res;
        String sql = "UPDATE usuarios SET usuario=?, nome=?, email=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, reg.getUsuario());
            ps.setString(2, reg.getNome());
            ps.setString(3, reg.getEmail());
            ps.setInt(4, reg.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }

    public List Listar(String valor) {
        List<Usuario> lista = new ArrayList();
        try {
            conexao = cn.getConnection();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM usuario ORDER BY id DESC";
                ps = conexao.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM usuario WHERE nome LIKE '%" + valor + "%' OR usuario LIKE '%" + valor + "%' OR email LIKE '%" + valor + "%'";
                ps = conexao.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                lista.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM usuario WHERE id = ?";
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

    public Usuario login(String user, String pass) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        Usuario l = new Usuario();
        try {
            conexao = cn.getConnection();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getRow() > 0) {
                    l.setId(rs.getInt("id"));
                    l.setUsuario(rs.getString("usuario"));
                    l.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    public Devolucao getDevolucao() {
        String sql = "SELECT * FROM devolução";
        Devolucao emp = new Devolucao();
        try {
            conexao = cn.getConnection();
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getRow() > 0) {
                    emp.setId(rs.getInt("id"));
                    emp.setRuc(rs.getString("ruc"));
                    emp.setNome(rs.getString("nome"));
                    emp.setTelefone(rs.getString("telefone"));
                    emp.setEmail(rs.getString("email"));
                    emp.setEndereco(rs.getString("endereco"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return emp;
    }
    
    public boolean modificarDevolucao(Devolucao emp) {
        boolean res;
        String sql = "UPDATE empresa SET ruc=?, nome=?, telefone=?, email=?, endereço=? WHERE id = ?";
        conexao = cn.getConnection();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, emp.getRuc());
            ps.setString(2, emp.getNome());
            ps.setString(3, emp.getTelefone());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getEndereco());
            ps.setInt(6, emp.getId());
            ps.execute();
            res = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = false;
        }
        return res;
    }
}
