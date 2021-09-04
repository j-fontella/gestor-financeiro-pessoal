package tech.futuretecnologia.gestorfinanceiro.entidades;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import tech.futuretecnologia.gestorfinanceiro.excecoes.InvalidOperacaoException;

import java.io.Serializable;

@Entity(tableName = "operacoes")
public class Operacao implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id = null;
    private Double valor;
    private String descricao;
    private Integer userOwnerId;
    private Double cotacao;


    public Operacao(Double valor, String descricao, Integer userOwnerId, Double cotacao) {
        if(descricao.length() > 60){
            throw new InvalidOperacaoException("A descrição deve ter menos de 60 caracteres");
        }
        this.valor = valor;
        this.descricao = descricao;
        this.userOwnerId = userOwnerId;
        this.cotacao = cotacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserOwnerId() {
        return userOwnerId;
    }

    public void setUserOwnerId(Integer userOwnerId) {
        this.userOwnerId = userOwnerId;
    }

    public Double getCotacao() {
        return cotacao;
    }

    public void setCotacao(Double cotacao) {
        this.cotacao = cotacao;
    }
}
