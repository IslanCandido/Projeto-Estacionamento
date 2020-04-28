package bll;

import dal.EstadiaDAL;
import java.util.List;
import java.util.Vector;
import model.Estadia;
import model.Funcionario;
import model.Veiculo;

public class EstadiaBLL {
    private EstadiaDAL dal;

    public EstadiaBLL() {
        this.dal = new EstadiaDAL();
    }
    
    public void adicionar(Estadia estadia) throws Exception {
        dal.salvar(estadia);
    }

    public void alterar(Estadia estadia) throws Exception {
        dal.alterar(estadia);
    }

    public void remover(int id) throws Exception {
        dal.excluir(id);
    }
    
    public List<Estadia> getEstadiasDevendo(){
        return dal.mostrarDevendo();
    }
    
    public List<Estadia> getEstadiasPagas(){
        return dal.mostrarPago();
    }
    
    public Estadia getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
    public Vector<Veiculo> listarVeiculos() {
        return dal.listarVeiculos();
    }

    public Vector<Funcionario> listarFuncionarios() {
        return dal.listarFuncionarios();
    }
    
    public void mostrarValor(int id){
        dal.pegarPreco(id);
    }

}
