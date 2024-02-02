package br.com.alura.desafiofipe.service.Impl;

import br.com.alura.desafiofipe.client.ClientFipe;
import br.com.alura.desafiofipe.converter.StringToModelConverter;
import br.com.alura.desafiofipe.models.Marca;
import br.com.alura.desafiofipe.models.Modelo;
import br.com.alura.desafiofipe.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final String URL = "https://parallelum.com.br/fipe/api/v1/";

    private Scanner leitura = new Scanner(System.in);

    private final ClientFipe clientFipe;

    private final StringToModelConverter toModelConverter;

    public MenuService() {
        clientFipe = new ClientFipe();
        toModelConverter = new StringToModelConverter();
    }

    public void menu() {
        System.out.println("**** OPÇÕES ****");

        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão");
        System.out.print("Digite uma das opções para consultar valores: ");
        var option = leitura.nextLine();
        System.out.println(option);


        String json = clientFipe.getData(URL + option + "/marcas"); //Encontrar uma maneira de usar o Enum Vehicle
        var marcas = toModelConverter.getConvertJson(json, Marca.class);

        marcas.stream()
                .sorted(Comparator.comparing(Marca::codigo))
                .forEach(System.out::println);

        System.out.print("Qual a marca do veículo: ");
        var marca = leitura.nextLine();

        json = clientFipe.getData(URL + option + "/marcas/" + marca + "/modelos");
        var modelosList = toModelConverter.obterDados(json, Modelo.class);

        modelosList.modelos()
                .stream()
                .sorted(Comparator.comparing(Marca::codigo))
                .forEach(System.out::println);

        System.out.print("Qual o modelo desejado: ");
        var carDescription = leitura.nextLine();
        var vehicleList = modelosList.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(carDescription))
                .collect(Collectors.toList());

        vehicleList.stream().forEach(System.out::println);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Qual o código do modelo desejado: ");
        var codeModel = leitura.nextLine();
        json = clientFipe.getData(URL + option + "/marcas/" + marca + "/modelos" + "/" + codeModel + "/anos");
        var fipeList = toModelConverter.getConvertJson(json, Marca.class);

        fipeList.stream().forEach(f -> vehicles.add(toModelConverter.obterDados
                (clientFipe.getData(URL + option + "/marcas/" + marca + "/modelos" + "/" + codeModel + "/anos/" + f.codigo()),
                        Vehicle.class)));
        System.out.println("Lista de veículos: ");
        vehicles.stream().forEach(System.out::println);
    }
}
