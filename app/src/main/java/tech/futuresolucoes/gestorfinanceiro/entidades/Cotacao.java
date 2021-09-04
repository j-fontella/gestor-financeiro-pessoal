package tech.futuretecnologia.gestorfinanceiro.entidades;

import java.util.HashMap;

public class Cotacao {

    private HashMap<String, Double> rates;

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }
}
