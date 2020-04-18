package dal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Preco;
import util.Conexao;

/**
 *
 * @author Felipe
 */
public class PrecoDAL {
    private Connection conexao;

    public PrecoDAL() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Preco preco) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO preco (plano, tipoVeiculo, preco) VALUES (?, ?, ? )");
            preparedStatement.setString(1, preco.getPlano());
            preparedStatement.setString(2, preco.getTipoVeiculo());
            preparedStatement.setDouble(3, preco.getPreco());
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
    
    public void alterar(Preco preco) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE preco SET plano = ?, tipoVeiculo = ?, preco = ? WHERE pre_id = ?");
            preparedStatement.setString(1, preco.getPlano());
            preparedStatement.setString(2, preco.getTipoVeiculo());
            preparedStatement.setDouble(3, preco.getPreco());
            preparedStatement.setInt(4, preco.getCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Preco> mostrarTodos() {
        List<Preco> precos = new ArrayList<Preco>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM preco");
            while (rs.next()) {
                Preco preco = new Preco();
                preco.setCodigo(rs.getInt("pre_id"));
                preco.setPlano(rs.getString("plano"));
                preco.setTipoVeiculo(rs.getString("tipoVeiculo"));
                preco.setPreco(rs.getDouble("preco"));
                precos.add(preco);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return precos;
    }
    
    public Preco consultarPorId(int cod) {
        Preco preco = new Preco();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM preco WHERE pre_id = ?");
            preparedStatement.setInt(1, cod);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                preco.setCodigo(rs.getInt("pre_id"));
                preco.setPlano(rs.getString("plano"));
                preco.setTipoVeiculo(rs.getString("tipoVeiculo"));
                preco.setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return preco;
    }
}
