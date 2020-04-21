package model;

public class Preco {
    private int codigo;
    private String plano;
    private String tipoVeiculo;
    private double preco;

    public Preco() {
    }

    public Preco(int codigo, String plano, String tipoVeiculo, double preco) {
        this.codigo = codigo;
        this.plano = plano;
        this.tipoVeiculo = tipoVeiculo;
        this.preco = preco;
    }
    
    public String toString() {
        return getPlano() + " - " + getTipoVeiculo()+" - "+getPreco()+" R$";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    
}
