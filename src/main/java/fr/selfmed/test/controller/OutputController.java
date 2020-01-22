package fr.selfmed.test.controller;

import fr.selfmed.test.services.ExternalApiSimulatorService;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class OutputController {
    private final ExternalApiSimulatorService externalApiSimulatorService;

    @Autowired
    public OutputController(ExternalApiSimulatorService externalApiSimulatorService) {
        this.externalApiSimulatorService = externalApiSimulatorService;
    }

    @GetMapping("/api/output/json")
    public String getAsJsonFormat() throws IOException, InterruptedException, ParseException {
        //String xmlInput = externalApiSimulatorService.callApi("");
        String output = "";

        // TODO
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
        		.build()
        	    .toUriString();
        String uri = baseUrl + "/api/input/xml";
        String xmlInput = externalApiSimulatorService.callApi(uri);
        output = externalApiSimulatorService.getAsJsonFormat(xmlInput);
        
        return output;
    }

    @GetMapping("/api/output/selfmed")
    public String getAsSelfmedFormat() throws IOException, InterruptedException {
        //String xmlInput = externalApiSimulatorService.callApi("");
        String output = "";

        // TODO
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
        		.build()
        	    .toUriString();
        String uri = baseUrl + "/api/input/xml";
        String xmlInput = externalApiSimulatorService.callApi(uri);
        output = externalApiSimulatorService.getAsSelfmedFormat(xmlInput);

        return output;
    }
}