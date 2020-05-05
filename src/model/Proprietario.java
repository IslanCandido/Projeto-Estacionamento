package model;

import java.util.Date;

public class Proprietario {
    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String cnh;
    private Date dataCnh;

    public Proprietario(){
        
    }
    
    public Proprietario(int codigo, String nome, String cpf, String telefone, String cnh, Date dataCnh) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cnh = cnh;
        this.dataCnh = dataCnh;
    }

    public String toString() {
        return getNome();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getDataCnh() {
        return dataCnh;
    }

    public void setDataCnh(Date dataCnh) {
        this.dataCnh = dataCnh;
    }
}
