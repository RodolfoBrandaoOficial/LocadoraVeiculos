package com.rodolfobrandao.aulajavacollectionsproject.controllers.consultas;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

@Deprecated
public class BaixarImagem {

        public static void main(String[] args) {
            // Pedir ao usuário para inserir o termo de pesquisa
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o termo de pesquisa: ");
            String searchTerm = scanner.nextLine();

            // Realiza a pesquisa no Google Imagens
            try {
                String imageUrl = searchGoogleImages(searchTerm);

                // Exibe a URL da imagem
                System.out.println("URL da Imagem: " + imageUrl);

                // Transforma a imagem em base64
                String base64Image = getImageAsBase64(imageUrl);

                // Exibe a imagem em base64 no console
                System.out.println(base64Image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String searchGoogleImages(String searchTerm) throws IOException {
            String googleUrl = "https://www.google.com/search?tbm=isch&q=";
            String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");
            Document doc = Jsoup.connect(googleUrl + encodedSearchTerm).get();
            Element imgElement = doc.select("img").first();
            return imgElement.absUrl("src");
        }

        private static String getImageAsBase64(String imageUrl) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] imageBytes = Jsoup.connect(imageUrl).ignoreContentType(true).execute().bodyAsBytes();
            baos.write(imageBytes);
            return Base64.encodeBase64String(baos.toByteArray());
        }
    }
