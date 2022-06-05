package com.consumeapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumeapi.entity.Trade;

public interface TradeRepo extends JpaRepository<Trade, Long> {

}
