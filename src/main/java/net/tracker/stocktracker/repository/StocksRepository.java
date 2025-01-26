package net.tracker.stocktracker.repository;

import net.tracker.stocktracker.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksRepository  extends JpaRepository<Stocks, Long> {
}
