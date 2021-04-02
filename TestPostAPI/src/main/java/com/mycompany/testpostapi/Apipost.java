/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testpostapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class Apipost {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        var values = new HashMap<String, String>() {{
            put("id", "19");
            put ("email", "samantha.holt@reqres.in");
            put ("first_name", "Samantha ");
            put ("last_name", "Juliet");
            put ("avatar", "https://reqres.in/img/faces/19-image.jpg");
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);
        
        System.out.println("The full request being sent is" + requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("The full response received is" + response.body());
    }
    
    
}
