package map.busan.animal.hospital.controller;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import map.busan.animal.hospital.vo.ItemVO;
import map.busan.animal.hospital.vo.ResultVO;

@Controller
public class MainController {

	@GetMapping(value = {"", "index"})
	public String index(Model model) {
		
		String apiURL = "http://apis.data.go.kr/6260000/BusanAnimalHospService/getTblAnimalHospital";
		String serviceKey = "22u6120Nmh52gAfDCiBOpskBBNZQanj1oMMhzJLkAzUHqldmeWDzgFMJuCVoX3ADmjvKamgBF1Iaw6R1CjJOTA==";
		String resultType = "json";
		String pageNo = "1";
		String numOfRows = "1000";
		
		URI uri = UriComponentsBuilder
						.fromUriString(apiURL)
						.queryParam("serviceKey", serviceKey)
						.queryParam("resultType", resultType)
						.queryParam("pageNo", pageNo)
						.queryParam("numOfRows", numOfRows)
						.encode()
						.build()
						.toUri();
		
		RequestEntity<Void> req = RequestEntity.get(uri).build();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.exchange(req, String.class);
		
		//JSON 문자열
		String jsonData = result.getBody();
		//JSON 파싱
		ObjectMapper om = new ObjectMapper();
		
		ResultVO resultVO;
		try {
			resultVO = om.readValue(jsonData, ResultVO.class);
			ItemVO[] items = resultVO.getGetTblAnimalHospital().getBody().getItems().getItem();
			model.addAttribute("items", items);
			System.out.print(items);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
}
