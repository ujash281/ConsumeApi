package com.consumeapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.consumeapi.entity.Trade;
import com.consumeapi.repo.TradeRepo;

@RestController
public class TradeController {

	@Autowired
	private TradeRepo tradeRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/saveTrades")
	public ResponseEntity<Trade[]> saveTrades() {

		final String url = "https://api.binance.com/api/v3/trades?symbol=ETHUSDT&limit=1000";
		
		ResponseEntity<Trade[]> tradeEntity = restTemplate.getForEntity(url, Trade[].class);
		Trade[] tradeArray = tradeEntity.getBody();
		this.tradeRepo.saveAll(List.of(tradeArray));		
		return new ResponseEntity<Trade[]>(tradeArray , HttpStatus.CREATED);
	}
}
