package bll;

import dal.VeiculoDAL;
import java.util.List;
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
    
    /*public List<String> PreencherCbxProprietario(){
        return dal.mostrarDadosProprietario();
    }
    
    public List<String> PreencherCbxPlanos(){
        return dal.mostrarDadosPreco();
    }

    public int pegarId(String comboBox){
        return dal.pegarId(comboBox);
    }*/
}
