package tech.futuretecnologia.gestorfinanceiro.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Operacoes implements Serializable {

    private ArrayList<Operacao> operacoes = new ArrayList<>();


    public void adicionarOperacao(double valor, String descricao, int id, double cotacao) {
        operacoes.add(new Operacao(valor, descricao, id, cotacao));
    }

    public double getTotal() {
        double total = 0;
        for (Operacao operacao : this.operacoes) {
            if(operacao.getCotacao() == 1){
                total += operacao.getValor();
            }else{
                total += operacao.getValor() * operacao.getCotacao();
            }
        }
        return total;
    }

    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
    }
}
