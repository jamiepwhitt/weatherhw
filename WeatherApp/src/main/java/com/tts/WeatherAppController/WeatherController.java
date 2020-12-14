package com.tts.WeatherAppController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherAppModel.Request;
import com.tts.WeatherAppModel.Response;
//import com.tts.WeatherAppModel.ZipCode;
import com.tts.WeatherAppService.WeatherService;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());
		return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		return "index";
	}
	
//	@GetMapping(value = { })
//    public String getFeed(Model model) {
//        List<ZipCode> zipcodes = WeatherService.findAll();
//        model.addAttribute("zipcodelist", zipcodes);
//        return "zipcodelist";
//    }
}
