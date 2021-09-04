package tech.futuretecnologia.gestorfinanceiro.entidades;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import tech.futuretecnologia.gestorfinanceiro.excecoes.InvalidCategoriaException;

import java.io.Serializable;

@Entity(tableName = "categorias")
public class Categoria implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id = null;
    private String nome;
    @Ignore
    private Operacoes operacoes = new Operacoes();
    private Boolean status;
    private Integer mes;
    private String userOwnerId;


    public Categoria(String nome, Boolean status, Integer mes, String userOwnerId) {
        if(nome.length() > 15){
            throw new InvalidCategoriaException("Limite de 15 caracteres excedido");
        }
        if(mes < 0 || mes > 11){
            throw new InvalidCategoriaException("Mes invalido, use 0-11 (0jan-11dez)");
        }
        this.nome = nome;
        this.status = status;
        this.mes = mes;
        this.userOwnerId = userOwnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Operacoes getOperacoes() {
        return operacoes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getUserOwnerId() {
        return userOwnerId;
    }

    public void setUserOwnerId(String userOwnerId) {
        this.userOwnerId = userOwnerId;
    }
}
