package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Estadia;
import model.Funcionario;
import model.Plano;
import model.Proprietario;
import model.Veiculo;
import util.Conexao;

public class EstadiaDAL {
    private Connection conexao;

    public EstadiaDAL() {
        conexao = Conexao.getConexao();
    }
    
    public void salvar(Estadia estadia) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement
            ("INSERT INTO estadia (dt, horaEntrada, horaSaida, desconto, vei_fk, fun_fk, valor, situacaoPagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setDate(1, new java.sql.Date(estadia.getData().getTime()));
            preparedStatement.setTime(2, estadia.getHoraEntrada());
            preparedStatement.setTime(3, estadia.getHoraSaida());
            preparedStatement.setString(4, estadia.getDesconto());
            preparedStatement.setInt(5, estadia.getIdVeiculo().getCodigo());
            preparedStatement.setInt(6, estadia.getIdFuncionario().getCodigo());
            preparedStatement.setDouble(7, estadia.getValor());
            preparedStatement.setString(8, estadia.getSituacaoPagamento());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM estadia WHERE est_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void alterar(Estadia estadia) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement
            ("UPDATE estadia SET dt = ?, horaEntrada = ?, horaSaida = ?, desconto = ?, vei_fk = ?, fun_fk = ?, valor = ?, situacaoPagamento = ? WHERE est_id = ?");
            preparedStatement.setDate(1, new java.sql.Date(estadia.getData().getTime()));
            preparedStatement.setTime(2, estadia.getHoraEntrada());
            preparedStatement.setTime(3, estadia.getHoraSaida());
            preparedStatement.setString(4, estadia.getDesconto());
            preparedStatement.setInt(5, estadia.getIdVeiculo().getCodigo());
            preparedStatement.setInt(6, estadia.getIdFuncionario().getCodigo());
            
            
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Estadia> mostrarTodos(){
        List<Estadia> estadias = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement
            ("SELECT * FROM estadia e INNER JOIN veiculo v ON e.vei_fk = v.vei_id\n" +
            "JOIN funcionario f ON e.fun_fk = f.fun_id");
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                //pegando os dados de veiculo
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                
                //pegando dados de funcionario
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSenha(rs.getString("senha"));
                
                Estadia estadia = new Estadia();
                estadia.setCodigo(rs.getInt("est_id"));
                estadia.setData(rs.getDate("dt"));
                estadia.setHoraEntrada(rs.getTime("horaEntrada"));
                estadia.setHoraSaida(rs.getTime("horaSaida"));
                estadia.setDesconto(rs.getString("desconto"));
                estadia.setIdVeiculo(veiculo);
                estadia.setIdFuncionario(funcionario);
                estadia.setValor(rs.getDouble("valor"));
                estadia.setSituacaoPagamento(rs.getString("situacaoPagamento"));
                
                estadias.add(estadia);
            }
            
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        
        return estadias;
    }
    
    public Vector<Veiculo> listarVeiculos() {
        Vector<Veiculo> veiculos = new Vector<Veiculo>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM veiculo");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(rs.getInt("vei_id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.getIdPreco();
                veiculo.getIdPropietario();
                
                veiculos.add(veiculo);
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return veiculos;
    }
    
    public Vector<Funcionario> listarFuncionarios(){
        Vector<Funcionario> funcionarios = new Vector<Funcionario>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM funcionario");
            ResultSet rs = preparedStatement.executeQuery();
            
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
}
