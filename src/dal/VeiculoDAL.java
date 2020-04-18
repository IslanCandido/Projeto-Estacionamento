package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;
import util.Conexao;

public class VeiculoDAL {

    private Connection conexao;

    public VeiculoDAL() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Veiculo veiculo) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO veiculo (placa, modelo, cor, pro_fk, pre_fk) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, veiculo.getPlaca());
            preparedStatement.setString(2, veiculo.getModelo());
            preparedStatement.setString(3, veiculo.getCor());
            preparedStatement.setInt(4, veiculo.getIdPropietario());
            preparedStatement.setInt(5, veiculo.getIdPreco());
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM veiculo WHERE vei_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void alterar(Veiculo veiculo) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE veiculo SET placa = ?, modelo = ?, cor = ?, pro_fk = ?, pre_fk = ? WHERE vei_id = ?");
            preparedStatement.setString(1, veiculo.getPlaca());
            preparedStatement.setString(2, veiculo.getModelo());
            preparedStatement.setString(3, veiculo.getCor());
            preparedStatement.setInt(4, veiculo.getIdPropietario());
            preparedStatement.setInt(5, veiculo.getIdPreco());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<Veiculo> mostrarTodos() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM veiculo");
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setIdPropietario(rs.getInt("pro_fk"));
                veiculo.setIdPreco(rs.getInt("pre_fk"));
                veiculos.add(veiculo);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return veiculos;
    }

    public Veiculo consultarPorId(int id) {
        Veiculo veiculo = new Veiculo();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM veiculo WHERE vei_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setIdPropietario(rs.getInt("pro_fk"));
                veiculo.setIdPreco(rs.getInt("pre_fk"));
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

        return veiculo;
    }

    /*public List<String> mostrarDadosPreco() {
        List<String> strList = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM preco");            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                strList.add(rs.getString("plano")+" - "+rs.getString("tipoVeiculo")+" - "+rs.getString("preco")+" R$");
            }
            preparedStatement.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return strList;

    }

    public List<String> mostrarDadosProprietario() {
        List<String> strList = new ArrayList<String>();

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM proprietario");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                strList.add(rs.getString("nome")+" - "+rs.getString("cpf")+" - "+rs.getString("telefone"));
            }

            preparedStatement.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return strList;
    }
    
    public int pegarId(String comboBox){
        int resultado =0;
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("select ID from preco where COLUNA = ?");
            preparedStatement.setInt(0, Integer.parseInt(comboBox));
            ResultSet rs = preparedStatement.executeQuery();
            
            resultado = rs.findColumn(comboBox);
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return resultado;
    }*/

}
