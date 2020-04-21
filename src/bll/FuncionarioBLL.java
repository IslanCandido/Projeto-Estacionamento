package bll;

import dal.FuncionarioDAL;
import java.util.List;
import model.Funcionario;

public class FuncionarioBLL {
    private FuncionarioDAL dal;

    public FuncionarioBLL() {
        dal = new FuncionarioDAL();
    }

    public void adicionar(Funcionario funcionario) throws Exception {
        dal.salvar(funcionario);
    }

    public void alterar(Funcionario funcionario) throws Exception {
        dal.alterar(funcionario);
    }

    public void remover(Funcionario funcionario) throws Exception {
        dal.excluir(funcionario.getCodigo());
    }

    public List<Funcionario> getConsulta() {
        return dal.mostrarTodos();
    }

    public Funcionario getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
    public boolean fazerLogin(String usuario, String senha){
        return dal.autenticarUsuario(usuario, senha);
    }
    
    public boolean verificarCpfsIguais(String cpf){
        return dal.vericarCpfIgual(cpf);
    }


}
