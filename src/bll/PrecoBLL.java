package bll;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dal.PrecoDAL;
import java.util.List;
import model.Preco;

/**
 *
 * @author Felipe
 */
public class PrecoBLL {
    private PrecoDAL dal;

    public PrecoBLL() {
        dal = new PrecoDAL();
    }

    public void Adicionar(Preco preco) throws Exception {
        dal.salvar(preco);
    }

    public void Alterar(Preco preco) throws Exception {
        dal.alterar(preco);
    }

    public void Remover(Preco preco) throws Exception {
        dal.excluir(preco.getCodigo());
    }

    public List<Preco> getConsulta() {
        return dal.mostrarTodos();
    }

    public Preco getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
}
