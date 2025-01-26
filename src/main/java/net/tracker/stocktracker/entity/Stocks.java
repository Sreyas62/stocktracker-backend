package net.tracker.stocktracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocks") // Ensure the table name matches your database
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") // Maps to the "name" column in the database
    private String name;

    @Column(name = "ticker") // Maps to the "ticker" column in the database
    private String ticker;

    @Column(name = "quantity") // Maps to the "quantity" column in the database
    private int quantity;

    @Column(name = "buyprice") // Maps to the "buyprice" column in the database
    private double buyPrice;

    @Column(name = "userid") // Maps to the "userid" column in the database
    private String userid;

    // Getters (if required explicitly)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public String getUserid() {
        return userid;
    }
}
