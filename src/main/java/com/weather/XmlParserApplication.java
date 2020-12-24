package com.weather;

import com.weather.models.Forecasts;
import com.weather.services.XMLService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlParserApplication implements CommandLineRunner {

    private XMLService xmlService;

    public XmlParserApplication(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(XmlParserApplication.class);
        // disable spring banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {

        // load forecast from XMLService
        Forecasts forecasts = xmlService.parseForecast();

        // print forecast details
        System.out.println(forecasts);
    }
}
