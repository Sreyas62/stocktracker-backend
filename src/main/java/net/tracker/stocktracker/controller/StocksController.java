package net.tracker.stocktracker.controller;

import lombok.AllArgsConstructor;
import net.tracker.stocktracker.dto.StocksDto;
import net.tracker.stocktracker.service.StocksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/stocks")
public class StocksController {

    private StocksService stocksService;

    //REST APIS
    @PostMapping
    public ResponseEntity<StocksDto> createStocks(@RequestBody StocksDto stocksDto) {
        StocksDto savedStocks = stocksService.createStocks(stocksDto);
        return new ResponseEntity<>(savedStocks, HttpStatus.CREATED);
    }

    //Build Get Api
    @GetMapping("{id}")
    public ResponseEntity<StocksDto> getStocksById(@PathVariable("id") Long stocksId) {
        StocksDto stocksDto = stocksService.getStocksById(stocksId);
        return ResponseEntity.ok(stocksDto);
    }

    //Build get all stocks api
    @GetMapping
    public ResponseEntity<List<StocksDto>> getAllStocks(){
        List<StocksDto> stocks = stocksService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    //Build update stock api
    @PutMapping("{id}")
    public ResponseEntity<StocksDto> updateStocks(@PathVariable("id") Long stocksId, @RequestBody StocksDto updatedStocks){
        StocksDto stocksDto = stocksService.updateStocks(stocksId, updatedStocks);
        return ResponseEntity.ok(stocksDto);
    }

    //Build delete stock api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStocks(@PathVariable("id") Long stocksId){
        stocksService.deleteStocks(stocksId);
        return ResponseEntity.ok("Stock deleted Successfully");
    }
}
