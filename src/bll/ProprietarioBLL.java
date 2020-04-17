/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ProprietarioDAL;
import java.util.List;
import model.Proprietario;

/**
 *
 * @author PC
 */
public class ProprietarioBLL {
    private ProprietarioDAL dal;

    public ProprietarioBLL() {
        dal = new ProprietarioDAL();
    }

    public void Adicionar(Proprietario proprietario) throws Exception {
        dal.salvar(proprietario);
    }

    public void Alterar(Proprietario proprietario) throws Exception {
        dal.alterar(proprietario);
    }

    public void Remover(Proprietario proprietario) throws Exception {
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
