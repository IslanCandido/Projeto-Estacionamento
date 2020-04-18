package model;

public class Veiculo {

    private int codigo;
    private String placa;
    private String cor;
    private String modelo;
    private int idPropietario;
    private int idPreco;

    public Veiculo() {
    }

    public Veiculo(int codigo, String placa, String modelo, String cor, int idPropietario, int idPreco) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.idPropietario = idPropietario;
        this.idPreco = idPreco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdPreco() {
        return idPreco;
    }

    public void setIdPreco(int idPreco) {
        this.idPreco = idPreco;
    }

}
