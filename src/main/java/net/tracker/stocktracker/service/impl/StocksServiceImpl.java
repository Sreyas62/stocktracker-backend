package net.tracker.stocktracker.service.impl;

import net.tracker.stocktracker.dto.StocksDto;
import net.tracker.stocktracker.entity.Stocks;
import net.tracker.stocktracker.exception.ResourceNotFoundException;
import net.tracker.stocktracker.mapper.StocksMapper;
import net.tracker.stocktracker.repository.StocksRepository;
import net.tracker.stocktracker.service.StocksService;
import net.tracker.stocktracker.util.StockPriceFetcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StocksServiceImpl implements StocksService {

    private final StocksRepository stocksRepository;
    private final StockPriceFetcher stockPriceFetcher;

    // Constructor Injection
    public StocksServiceImpl(StocksRepository stocksRepository, StockPriceFetcher stockPriceFetcher) {
        this.stocksRepository = stocksRepository;
        this.stockPriceFetcher = stockPriceFetcher;
    }

    @Override
    public StocksDto createStocks(StocksDto stocksDto) {
        Stocks stocks = StocksMapper.mapToStocks(stocksDto);
        Stocks savedStocks = stocksRepository.save(stocks);
        return StocksMapper.mapToStocksDto(savedStocks);
    }

    @Override
    public StocksDto getStocksById(Long stocksId) {
        Stocks stocks = stocksRepository.findById(stocksId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock not exists with given id : " + stocksId));
        return StocksMapper.mapToStocksDto(stocks);
    }

    @Override
    public List<StocksDto> getAllStocks() {
        List<Stocks> stocks = stocksRepository.findAll();
        return stocks.stream()
                .map(stock -> {
                    StocksDto stocksDto = StocksMapper.mapToStocksDto(stock);

                    // Fetch current price and set it in the DTO
                    Double currentPrice = stockPriceFetcher.fetchCurrentPrice(stock.getTicker());
                    System.out.println("API Response: " + currentPrice);
                    stocksDto.setCurrentPrice(currentPrice);

                    return stocksDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public StocksDto updateStocks(Long stocksId, StocksDto updatedStocks) {
        Stocks stocks = stocksRepository.findById(stocksId).orElseThrow(
                () -> new ResourceNotFoundException("Stock not exists with given id : " + stocksId)
        );
        stocks.setName(updatedStocks.getName());
        stocks.setTicker(updatedStocks.getTicker());
        stocks.setQuantity(updatedStocks.getQuantity());
        stocks.setBuyPrice(updatedStocks.getBuyPrice());
        stocks.setUserid(updatedStocks.getUserid());

        Stocks updatedStocksObj = stocksRepository.save(stocks);
        return StocksMapper.mapToStocksDto(updatedStocksObj);
    }

    @Override
    public void deleteStocks(Long stocksId) {

        Stocks stocks = stocksRepository.findById(stocksId).orElseThrow(
                () -> new ResourceNotFoundException("Stock not exists with given id : " + stocksId)
        );

        stocksRepository.deleteById( stocksId);

    }
}
