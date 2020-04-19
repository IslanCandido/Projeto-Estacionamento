package bll;

import dal.VeiculoDAL;
import java.util.List;
import model.Preco;
import model.Proprietario;
import model.Veiculo;

public class VeiculoBLL {
    private VeiculoDAL dal;

    public VeiculoBLL() {
        this.dal = new VeiculoDAL();
    }
    
    public void Adicionar(Veiculo veiculo) throws Exception {
        dal.salvar(veiculo);
    }

    public void Alterar(Veiculo veiculo) throws Exception {
        dal.alterar(veiculo);
    }

    public void Remover(Veiculo veiculo) throws Exception {
        dal.excluir(veiculo.getCodigo());
    }

    public List<Veiculo> getConsulta() {
        return dal.mostrarTodos();
    }

    public Veiculo getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
    public List<Proprietario> PreencherCbxProprietario(){
        return dal.mostrarDadosProprietario();
    }
    
    public List<Preco> PreencherCbxPlanos(){
        return dal.mostrarDadosPreco();
    }
}
