package com.nasaapi.nasaapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@SpringBootApplication
@RestController
public class NasaapiApplication {

	private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=mNnRoGEkzdOCN02p0HTDpBjLpxYmUbnieaHr4umJ";
	private static final Logger log = LoggerFactory.getLogger(NasaapiApplication.class);
	private static APOD apod;

	static {
		try {
			apod = new APOD();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(NasaapiApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			APOD apod = restTemplate.getForObject(NASA_URL, APOD.class);
			log.info(apod.toString());
		};
	}

	@GetMapping("/apod")
	public String apiRequest(RestTemplate restTemplate){
		String output = "";
		apod = restTemplate.getForObject(NASA_URL, APOD.class);

		output += apod.getTitle() + "\'";
		output += apod.getDate() + "\'";
		output += apod.getCopyright() + "\'";
		output += apod.getExplanation();

		return output;
	}

}
