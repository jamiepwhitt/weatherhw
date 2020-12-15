package com.tts.WeatherAppController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherAppModel.Request;
import com.tts.WeatherAppModel.Zip;
import com.tts.WeatherAppService.WeatherService;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
		model.addAttribute("lastTen", weatherService.getLastTen());
		return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		model.addAttribute("lastTen", weatherService.getLastTen());
		Zip newZip = new Zip(request.getZipCode());
		weatherService.saveZip(newZip);
		
		return "index";
	}
	
}
