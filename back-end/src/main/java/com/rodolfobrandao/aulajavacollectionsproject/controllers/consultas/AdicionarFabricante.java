package com.rodolfobrandao.aulajavacollectionsproject.controllers.consultas;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class AdicionarFabricante {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Fazendo requisição GET para a API que retorna as marcas de veículos
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://brasilapi.com.br/api/fipe/marcas/v1/carros"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Obtendo o corpo da resposta e transformando em JSONArray
        JSONArray marcas = new JSONArray(response.body());

        // Iterando sobre as marcas
        for (int i = 0; i < marcas.length(); i++) {
            JSONObject marca = marcas.getJSONObject(i);

            // Criando o JSON para enviar na requisição POST
            JSONObject requestBody = new JSONObject();
            requestBody.put("nome", marca.getString("nome"));
            requestBody.put("imgurl", Optional.ofNullable(null)); // Você pode adicionar a URL da imagem se tiver

            // Fazendo requisição POST para a sua API Spring Boot
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://projeto-springboot:8080/api/v1/fabricante/create"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InJvZG9sZm8iLCJleHAiOjE3MTU2MDUzOTV9.MFllcB8slvlJG9PIf-191MLqC2YT2SdQnv-Bdic55VU")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());

            // Imprimindo o resultado da requisição POST
            System.out.println("Status da requisição para " + marca.getString("nome") + ": " + postResponse.statusCode());
        }
    }
}
