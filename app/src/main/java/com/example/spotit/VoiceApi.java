package com.example.spotit;

import com.sinch.httpclient.HttpClient;

import java.net.*;
import java.net.http.*;
import java.util.*;

public class VoiceApi {
    private static final String key = "9af29c95-1229-4944-85da-49199e1e72eb";
    private static final String secret = "c6jkqU8UIkKIi1sPc5RzXw==";
    private static final String fromNumber = "+447520651493";
    private static final String to = "+923361556619";
    private static final String locale = "ur-PK";

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().build();

        String payload = String.join("\n"
                , "{"
                , " \"method\": \"ttsCallout\","
                , " \"ttsCallout\": {"
                , "  \"cli\": \"" + fromNumber + "\","
                , "  \"destination\": {"
                , "   \"type\": \"number\","
                , "   \"endpoint\": \"" + to + "\""
                , "  },"
                , "  \"locale\": \"" + locale + "\","
                , "  \"text\": \"Hello, this is a call from Sinch. Congratulations! You made your first call.\""
                , " }"
                , "}"
        );

        String host = "https://calling.api.sinch.com";
        String pathname = "/calling/v1/callouts";
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(host + pathname ))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((key + ":" + secret).getBytes()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
