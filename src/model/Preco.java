package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Felipe
 */
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
    
    @Override
    public String toString() {
        return getCodigo()+" - "+getPlano() + " - " + getTipoVeiculo() + " - " + getPreco()+" R$";
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
