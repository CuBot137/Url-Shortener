package com.zinkworks.bountyhuntersurlshortener.google;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.zinkworks.bountyhuntersurlshortener.controller.ControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;


@RestController
public class HttpFunctions implements HttpFunction {
    @Autowired
    private ControllerUrl controllerUrl;


    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
        BufferedWriter writer = httpResponse.getWriter();
        String responseMessage = "";

        switch (httpRequest.getMethod()){
            case "GET":
                controllerUrl.getAllUrls();
                responseMessage = "This is a GET response";
                break;
            case "POST":
                String requestBody = httpRequest.getReader().readLine();
                controllerUrl.createShortUrl(requestBody);
                break;
            case "DELETE":
                requestBody = httpRequest.getReader().readLine();
                controllerUrl.deleteShortUrl(requestBody);
                break;
            default:
                ResponseEntity.notFound();
        }
        writer.write(responseMessage);
    }
}
