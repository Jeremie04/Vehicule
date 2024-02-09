package com.vehicule.gestion.modele;

// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.OutputStream;
// import java.io.OutputStreamWriter;
// import java.io.PrintWriter;
// import java.net.URL;
// import java.net.URLConnection;
// import java.net.http.HttpClient;
// import java.net.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.Base64;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class TraitementImage {
    static String apikey = "b6b7a7b84eddd705bfa4e3357e418627";
    static String urlServeurStockage = "https://api.imgbb.com/1/upload";
    static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    public TraitementImage() {
    }

    public List<byte[]> Base64ToImage(List<String> encodedString) throws Exception {
        List<byte[]> images = new ArrayList<>();
        for (String string : encodedString) {
            images.add(Base64.getDecoder().decode(string));
        }
        return images;
    }

    public List<String> hebergementImage(List<String> encodedString) throws Exception {
        List<byte[]> images = this.Base64ToImage(encodedString);
        List<String> liensImages = new ArrayList<>();

        String base64Image;
        String imageDataParam;
        URI uri;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response;
        String responseBody;
        String imageUrl;

        // Create an HTTP request
        HttpRequest request;

        for (byte[] image : images) {
            base64Image = Base64.getEncoder().encodeToString(image);
            imageDataParam = "image=" + base64Image;
            uri = URI.create(this.getUrlServeurStockage() + "?" + TraitementImage.getApikey() + "&" + imageDataParam);
            request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
            imageUrl = String.valueOf(responseBody);
            liensImages.add(imageUrl);
        }

        return liensImages;
    }

    public String uploadImage(MultipartFile fichier) throws Exception {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(this.getUPLOAD_DIRECTORY(), fichier.getOriginalFilename());
        fileNames.append(fichier.getOriginalFilename());
        Files.write(fileNameAndPath, fichier.getBytes());
        return this.getUPLOAD_DIRECTORY() + "/" + String.valueOf(fileNameAndPath.getFileName());
    }

    public String getUrlServeurStockage() {
        return urlServeurStockage;
    }

    public void setUrlServeurStockage(String urlServeurStockage) {
        this.urlServeurStockage = urlServeurStockage;
    }

    public static String getUPLOAD_DIRECTORY() {
        return UPLOAD_DIRECTORY;
    }

    public static void setUPLOAD_DIRECTORY(String uPLOAD_DIRECTORY) {
        UPLOAD_DIRECTORY = uPLOAD_DIRECTORY;
    }

    public static String getApikey() {
        return apikey;
    }

    public static void setApikey(String apikey) {
        TraitementImage.apikey = apikey;
    }

}
