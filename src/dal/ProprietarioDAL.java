package dal;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Proprietario;

public class ProprietarioDAL {

    private Connection conexao;

    public ProprietarioDAL() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Proprietario proprietario) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO proprietario (nome, cpf, telefone, cnh) VALUES (?, ?, ?, ? )");
            preparedStatement.setString(1, proprietario.getNome());
            preparedStatement.setString(2, proprietario.getCpf());
            preparedStatement.setString(3, proprietario.getTelefone());
            preparedStatement.setString(4, proprietario.getCnh());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void excluir(int cod) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM proprietario WHERE pro_id = ?");
            preparedStatement.setInt(1, cod);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterar(Proprietario proprietario) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE proprietario SET nome = ?, cpf = ?, telefone = ?, cnh = ? WHERE pro_id = ?");
            preparedStatement.setString(1, proprietario.getNome());
            preparedStatement.setString(2, proprietario.getCpf());
            preparedStatement.setString(3, proprietario.getTelefone());
            preparedStatement.setString(4, proprietario.getCnh());
            preparedStatement.setInt(5, proprietario.getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<Proprietario> mostrarTodos() {
        List<Proprietario> proprietarios = new ArrayList<Proprietario>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM proprietario");
            while (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setCodigo(rs.getInt("pro_id"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCpf(rs.getString("cpf"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setCnh(rs.getString("cnh"));
                proprietarios.add(proprietario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return proprietarios;
    }

    public Proprietario consultarPorId(int cod) {
        Proprietario proprietario = new Proprietario();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM proprietario WHERE pro_id = ?");
            preparedStatement.setInt(1, cod);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                proprietario.setCodigo(rs.getInt("pro_id"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCpf(rs.getString("cpf"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setCnh(rs.getString("cnh"));
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return proprietario;
    }
    
    public boolean vericarCpfIgual(String cpf) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM proprietario WHERE cpf = ?");
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();            
            
            resultado = rs.next();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return resultado;
    }
    
    public boolean vericarCnhIgual(String cnh) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM proprietario WHERE cnh = ?");
            preparedStatement.setString(1, cnh);
            ResultSet rs = preparedStatement.executeQuery();            
            
            resultado = rs.next();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return resultado;
    }

}
