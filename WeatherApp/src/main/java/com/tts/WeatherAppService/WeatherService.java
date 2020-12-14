package com.tts.WeatherAppService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.WeatherAppModel.Response;
//import com.tts.WeatherAppModel.ZipCode;
//import com.tts.WeatherAppRepo.ZipRepo;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	
//	  @Autowired
//	    private ZipRepo zipRepo;
//	  
//	  public void save(String zipCode) {
//	        getForecast(zipCode);
//	        zipRepo.save(zipCode);
//	    }
//	
	public Response getForecast(String zipCode) {
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject(url, Response.class);
		}
		catch (HttpClientErrorException ex) {
			Response response = new Response();
			response.setName("error");
			return response;
		}
	}

//	public ZipRepo getZipRepo() {
//		return zipRepo;
//	}
//
//	public void setZipRepo(ZipRepo zipRepo) {
//		this.zipRepo = zipRepo;
//	}
//
//	public static List<ZipCode> findAll() {
//		
//		List<ZipCode> zipcodelist = null;
//		return zipcodelist ;
//	}
	
}
