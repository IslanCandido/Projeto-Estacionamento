package bll;

import dal.ProprietarioDAL;
import java.util.List;
import model.Proprietario;

public class ProprietarioBLL {
    private ProprietarioDAL dal;

    public ProprietarioBLL() {
        dal = new ProprietarioDAL();
    }

    public void adicionar(Proprietario proprietario) throws Exception {
        dal.salvar(proprietario);
    }

    public void alterar(Proprietario proprietario) throws Exception {
        dal.alterar(proprietario);
    }

    public void remover(Proprietario proprietario) throws Exception {
        dal.excluir(proprietario.getCodigo());
    }

    public List<Proprietario> getConsulta() {
        return dal.mostrarTodos();
    }

    public Proprietario getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
    public boolean verificarCpfsIguais(String cpf){
        return dal.vericarCpfIgual(cpf);
    }
    
    public boolean verificarCnhsIguais(String cnh){
        return dal.vericarCnhIgual(cnh);
    }
    
    
}
