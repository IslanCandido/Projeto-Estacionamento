package model;

public class Veiculo {

    private int codigo;
    private String placa;
    private String cor;
    private String modelo;
    private Proprietario idPropietario;
    private Plano idPreco;

    public Veiculo() {
        idPreco =  new Plano();
        idPropietario = new Proprietario();
    }

    public Veiculo(int codigo, String placa, String modelo, String cor, Proprietario idPropietario, Plano idPreco) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.idPropietario = idPropietario;
        this.idPreco = idPreco;
    }

    public String toString() {
        return getPlaca() + " - " + getModelo();
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

    public Proprietario getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Proprietario idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Plano getIdPreco() {
        return idPreco;
    }

    public void setIdPreco(Plano idPreco) {
        this.idPreco = idPreco;
    }

}
