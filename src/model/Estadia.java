package model;

import java.sql.Time;
import java.util.Date;

public class Estadia {
    private int codigo;
    private Date data;
    private Time horaEntrada;
    private Time horaSaida;
    private String desconto;
    private Funcionario idFuncionario;
    private Veiculo idVeiculo;
    private double valor;
    private String situacaoPagamento;

    public Estadia() {
        idFuncionario = new Funcionario();
        idVeiculo = new Veiculo();
    }

    public Estadia(int codigo, Date data, Time horaEntrada, Time horaSaida, String desconto, Funcionario idFuncionario, Veiculo idVeiculo, double valor, String situacaoPagamento) {
        this.codigo = codigo;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.desconto = desconto;
        this.idFuncionario = idFuncionario;
        this.idVeiculo = idVeiculo;
        this.valor = valor;
        this.situacaoPagamento = situacaoPagamento;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo ){
        this.idVeiculo = idVeiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(String situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    
    
    
}
