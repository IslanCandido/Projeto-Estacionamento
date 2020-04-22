package bll;

import dal.PlanoDAL;
import java.util.List;
import model.Plano;

public class PlanoBLL {
    private PlanoDAL dal;

    public PlanoBLL() {
        dal = new PlanoDAL();
    }

    public void adicionar(Plano plano) throws Exception {
        dal.salvar(plano);
    }

    public void alterar(Plano plano) throws Exception {
        dal.alterar(plano);
    }

    public void remover(Plano plano) throws Exception {
        dal.excluir(plano.getCodigo());
    }

    public List<Plano> getConsulta() {
        return dal.mostrarTodos();
    }

    public Plano getConsultaPorId(int cod) {
        return dal.consultarPorId(cod);
    }
    
}
