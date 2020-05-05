package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Plano;
import model.Proprietario;
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
            preparedStatement.setInt(4, veiculo.getIdPropietario().getCodigo());
            preparedStatement.setInt(5, veiculo.getIdPreco().getCodigo());
            preparedStatement.executeUpdate();

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
            preparedStatement.setInt(4, veiculo.getIdPropietario().getCodigo());
            preparedStatement.setInt(5, veiculo.getIdPreco().getCodigo());
            preparedStatement.setInt(6, veiculo.getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Veiculo> mostrarTodos(){
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement
            ("SELECT v.vei_id, v.placa, v.modelo, v.cor, \n" +
            "p.pre_id, p.plano, p.tipoveiculo, p.preco, \n" +
            "pr.pro_id, pr.nome ,pr.cpf, pr.telefone, pr.cnh\n" +
            "FROM veiculo v INNER JOIN proprietario pr ON v.pro_fk = pr.pro_id\n" +
            "JOIN preco p ON v.pre_fk = p.pre_id");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                
                Plano plano = new Plano();
                plano.setCodigo(rs.getInt("pre_id"));
                plano.setPlano(rs.getString("plano"));
                plano.setTipoVeiculo(rs.getString("tipoVeiculo"));
                plano.setPreco(rs.getDouble("preco"));
                
                Proprietario propietario = new Proprietario();
                propietario.setCodigo(rs.getInt("pro_id"));
                propietario.setNome(rs.getString("nome"));
                propietario.setCpf(rs.getString("cpf"));
                propietario.setTelefone(rs.getString("telefone"));
                propietario.setCnh(rs.getString("cnh"));
                
                
                veiculo.setIdPreco(plano);
                veiculo.setIdPropietario(propietario);
                
                veiculos.add(veiculo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculos;
    }


    public Veiculo consultarPorId(int id) {
        Veiculo veiculo = new Veiculo();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement
            ("SELECT v.vei_id, v.placa, v.modelo, v.cor,\n" +
            "p.pre_id, p.plano, p.tipoveiculo, p.preco,\n" +
            "pr.pro_id, pr.nome ,pr.cpf, pr.telefone, pr.cnh\n" +
            "FROM veiculo v INNER JOIN proprietario pr ON v.pro_fk = pr.pro_id\n" +
            "JOIN preco p ON v.pre_fk = p.pre_id\n" +
            "WHERE vei_id = ?");
            
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                
                Plano plano = new Plano();
                plano.setCodigo(rs.getInt("pre_id"));
                plano.setPlano(rs.getString("plano"));
                plano.setTipoVeiculo(rs.getString("tipoVeiculo"));
                plano.setPreco(rs.getDouble("preco"));
                
                Proprietario propietario = new Proprietario();
                propietario.setCodigo(rs.getInt("pro_id"));
                propietario.setNome(rs.getString("nome"));
                propietario.setCpf(rs.getString("cpf"));
                propietario.setTelefone(rs.getString("telefone"));
                propietario.setCnh(rs.getString("cnh"));
                
                veiculo.setIdPreco(plano);
                veiculo.setIdPropietario(propietario);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return veiculo;
    }

    public Vector<Plano> listarPlanos() {
        Vector<Plano> precos = new Vector<Plano>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM preco");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Plano preco = new Plano();
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

    public Vector<Proprietario> listarProprietarios() {
        Vector<Proprietario> proprietarios = new Vector<Proprietario>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM proprietario");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Proprietario prop = new Proprietario();
                prop.setCodigo(rs.getInt("pro_id"));
                prop.setNome(rs.getString("nome"));
                prop.setCpf(rs.getString("cpf"));
                prop.setTelefone(rs.getString("telefone"));
                prop.setCnh(rs.getString("cnh"));
                prop.setDataCnh(rs.getDate("datacnh"));

                proprietarios.add(prop);
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return proprietarios;
    }
}
