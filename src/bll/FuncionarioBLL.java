/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.FuncionarioDAL;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author SaoJoseNote-02
 */
public class FuncionarioBLL {
    private FuncionarioDAL dal;

    public FuncionarioBLL() {
        dal = new FuncionarioDAL();
    }

    public void Adicionar(Funcionario funcionario) throws Exception {
        dal.salvar(funcionario);
    }

    public void Alterar(Funcionario funcionario) throws Exception {
        dal.alterar(funcionario);
    }

    public void Remover(Funcionario funcionario) throws Exception {
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
