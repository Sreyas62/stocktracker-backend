package net.tracker.stocktracker.mapper;

import net.tracker.stocktracker.dto.StocksDto;
import net.tracker.stocktracker.entity.Stocks;

public class StocksMapper {

    // Map from Entity to DTO
    public static StocksDto mapToStocksDto(Stocks stocks) {
        return new StocksDto(
                stocks.getId(),       // Maps ID
                stocks.getName(),     // Maps Name
                stocks.getTicker(),   // Maps Ticker
                stocks.getQuantity(), // Maps Quantity
                stocks.getBuyPrice(), // Maps Buy Price
                stocks.getUserid()    // Maps User ID
        );
    }

    // Map from DTO to Entity
    public static Stocks mapToStocks(StocksDto stocksDto) {
        return new Stocks(
                stocksDto.getId(),        // Maps ID
                stocksDto.getName(),      // Maps Name
                stocksDto.getTicker(),    // Maps Ticker
                stocksDto.getQuantity(),  // Maps Quantity
                stocksDto.getBuyPrice(),  // Maps Buy Price
                stocksDto.getUserid()     // Maps User ID
        );
    }
}
