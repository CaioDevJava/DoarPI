package br.com.Beans;

/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */

public class ItensDoacao {
    private int cod;
    private int qtd;
    private double dinheiro;
    private String roupa;
    private String alimentacao;
    private String servico;

    public ItensDoacao() {
        this.qtd = 0;
        this.dinheiro = 0.0f;
        this.roupa = null;
        this.alimentacao = null;
        this.servico = null;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getRoupa() {
        return roupa;
    }

    public void setRoupa(String roupa) {
        this.roupa = roupa;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
}
