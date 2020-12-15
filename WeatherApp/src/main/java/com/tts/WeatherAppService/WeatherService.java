package com.tts.WeatherAppService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.WeatherAppController.Response;
import com.tts.WeatherAppModel.Zip;
import com.tts.WeatherAppRepository.ZipRepository;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	
	@Autowired
	ZipRepository zipRepository;
			
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
	
	public void saveZip(Zip zip) {
		zipRepository.save(zip);
	} 
	
	public List<Zip> getLastTen() {
	List allZips = new ArrayList();
	allZips = zipRepository.findAll();
	List lastTen = new ArrayList();
	if (allZips.size() > 10) {
		for (int i = allZips.size()-1; i > allZips.size()-11; i--) {
			Object x = allZips.get(i);
			lastTen.add(x);
		}
			return lastTen;
	} else if (zipRepository.count() > 0) {
	}return allZips;
	}
	
}
