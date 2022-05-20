
package br.com.Beans;

import java.util.Date;


/**
 * @author Breno Baudeson
 * @author Camila França
 * @author Caio Magno
 * @author Felipe Rodrigues
 * @author Waismann Alves
 *
 * @version Beta v0.01
 */
public class Doacao {
    private int id;
    private String data;
    private String roupa;
    private String alimento;
    private String servivo;
    private double dinheiro;
    private String insti;
    private String us;

    public String getInsti() {
        return insti;
    }

    public void setInsti(String insti) {
        this.insti = insti;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getRoupa() {
        return roupa;
    }

    public void setRoupa(String roupa) {
        this.roupa = roupa;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getServivo() {
        return servivo;
    }

    public void setServivo(String servivo) {
        this.servivo = servivo;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        
        return data;
    }

    public void setData(String data) {
        
        this.data = data;
    }

    
}
