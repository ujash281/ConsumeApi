package com.consumeapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.consumeapi.entity.APIResponse;
import com.consumeapi.entity.Trade;
import com.consumeapi.repo.TradeRepo;

@RestController
public class TradeController {

	@Autowired
	private TradeRepo tradeRepo;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/save_trades")
	public ResponseEntity<Trade[]> saveTrades() {

		final String url = "https://api.binance.com/api/v3/trades?symbol=ETHUSDT&limit=1000";

		ResponseEntity<Trade[]> tradeEntity = restTemplate.getForEntity(url, Trade[].class);
		Trade[] tradeArray = tradeEntity.getBody();
		this.tradeRepo.saveAll(List.of(tradeArray));
		return new ResponseEntity<Trade[]>(tradeArray, HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/get_trades")
	public ResponseEntity<Object> getData(@RequestParam(required = false) String symbol,
			@RequestParam(required = false) Integer limit) {

		List<Trade> result = null;
		if (symbol.equals("ETHUSDT")) {
			if (limit == null) {
				return new ResponseEntity<Object>(new APIResponse(200, "success", tradeRepo.findAll()),
						HttpStatus.OK);
			} else if (limit > 0 && limit < 1001) {
				Page<?> page = tradeRepo.findAll(PageRequest.of(0, limit));
				result = (List<Trade>) page.getContent();
				return new ResponseEntity<Object>(new APIResponse(200, "success", result), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new APIResponse(400, "Invalid limit.", result),
						HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<Object>(new APIResponse(400, "Symbol is invalid or not present.", result),
				HttpStatus.BAD_REQUEST);
	}

}
