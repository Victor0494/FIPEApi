package br.com.alura.desafiofipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(@JsonAlias("Modelo") String modelo,
                      @JsonAlias("Valor") String valor,
                      @JsonAlias("Marca") String marca,
                      @JsonAlias("AnoModelo") String anoModelo) {

    @Override
    public String toString() {
        return  "modelo=" + modelo +
                ", valor=" + valor +
                ", marca=" + marca +
                ", anoModelo=" + anoModelo;
    }
}
