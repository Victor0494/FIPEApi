package br.com.alura.desafiofipe.converter;

import java.util.List;

public interface ConvertData {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> getConvertJson(String json, Class<T> tClass);
}
