package bll;

import dal.PrecoDAL;
import java.util.List;
import model.Preco;

public class PrecoBLL {
    private PrecoDAL dal;

    public PrecoBLL() {
        dal = new PrecoDAL();
    }

    public void adicionar(Preco preco) throws Exception {
        dal.salvar(preco);
    }

    public void alterar(Preco preco) throws Exception {
        dal.alterar(preco);
    }

    public void remover(Preco preco) throws Exception {
        dal.excluir(preco.getCodigo());
    }

    public List<Preco> getConsulta() {
        return dal.mostrarTodos();
    }

    public Preco getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
}
