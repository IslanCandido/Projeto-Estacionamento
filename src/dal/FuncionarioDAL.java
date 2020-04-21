package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import util.Conexao;

public class FuncionarioDAL {

    private Connection conexao;

    public FuncionarioDAL() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Funcionario funcionario) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO funcionario (nome, cpf, telefone, senha) VALUES (?, ?, ?, ? )");
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getTelefone());
            preparedStatement.setString(4, funcionario.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void excluir(int cod) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM funcionario WHERE fun_id = ?");
            preparedStatement.setInt(1, cod);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterar(Funcionario funcionario) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE funcionario SET nome = ?, cpf = ?, telefone = ?, senha = ? WHERE fun_id = ?");
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getTelefone());
            preparedStatement.setString(4, funcionario.getSenha());
            preparedStatement.setInt(5, funcionario.getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<Funcionario> mostrarTodos() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM funcionario");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSenha(rs.getString("senha"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return funcionarios;
    }

    public Funcionario consultarPorId(int cod) {
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionario WHERE fun_id = ?");
            preparedStatement.setInt(1, cod);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                funcionario.setCodigo(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return funcionario;
    }

    public boolean autenticarUsuario(String usuario, String senha) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionario WHERE cpf = ? AND senha = ?");

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            resultado = rs.next();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return resultado;
    }

    public boolean vericarCpfIgual(String cpf) {
        boolean resultado = false;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionario WHERE cpf = ?");
            preparedStatement.setString(1, cpf);
            ResultSet rs = preparedStatement.executeQuery();            
            
            resultado = rs.next();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return resultado;
    }
}
