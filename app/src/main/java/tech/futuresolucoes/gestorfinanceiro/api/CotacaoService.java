package tech.futuretecnologia.gestorfinanceiro.api;

import tech.futuretecnologia.gestorfinanceiro.entidades.Cotacao;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CotacaoService {


    @GET("latest?base=USD")
    Call<Cotacao> converterMoeda();
}
