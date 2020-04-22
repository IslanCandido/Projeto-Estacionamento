package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Plano;
import util.Conexao;

public class PlanoDAL {
    private Connection conexao;

    public PlanoDAL() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Plano plano) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO preco (plano, tipoVeiculo, preco) VALUES (?, ?, ? )");
            preparedStatement.setString(1, plano.getPlano());
            preparedStatement.setString(2, plano.getTipoVeiculo());
            preparedStatement.setDouble(3, plano.getPreco());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(int cod) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM preco WHERE pre_id = ?");
            preparedStatement.setInt(1, cod);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Plano plano) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE preco SET plano = ?, tipoVeiculo = ?, preco = ? WHERE pre_id = ?");
            preparedStatement.setString(1, plano.getPlano());
            preparedStatement.setString(2, plano.getTipoVeiculo());
            preparedStatement.setDouble(3, plano.getPreco());
            preparedStatement.setInt(4, plano.getCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Plano> mostrarTodos() {
        List<Plano> planos = new ArrayList<Plano>();
        try {
            Statement preparedStatement = conexao.createStatement();
            ResultSet rs = preparedStatement.executeQuery("SELECT * FROM preco");
            while (rs.next()) {
                Plano plano = new Plano();
                plano.setCodigo(rs.getInt("pre_id"));
                plano.setPlano(rs.getString("plano"));
                plano.setTipoVeiculo(rs.getString("tipoVeiculo"));
                plano.setPreco(rs.getDouble("preco"));
                planos.add(plano);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return planos;
    }
    
    public Plano consultarPorId(int cod) {
        Plano plano = new Plano();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM preco WHERE pre_id = ?");
            preparedStatement.setInt(1, cod);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                plano.setCodigo(rs.getInt("pre_id"));
                plano.setPlano(rs.getString("plano"));
                plano.setTipoVeiculo(rs.getString("tipoVeiculo"));
                plano.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return plano;
    }
}
