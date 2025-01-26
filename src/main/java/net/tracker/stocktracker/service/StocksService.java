package net.tracker.stocktracker.service;

import net.tracker.stocktracker.dto.StocksDto;

import java.util.List;

public interface StocksService {
    StocksDto createStocks(StocksDto stocksDto);

    StocksDto getStocksById(Long stocksId);

    List<StocksDto> getAllStocks();

    StocksDto updateStocks(Long stocksId, StocksDto updatedStocks);

    void deleteStocks(Long stocksId);
}
