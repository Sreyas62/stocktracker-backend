package net.tracker.stocktracker.dto;

public class StocksDto {
    private Long id;
    private String name;
    private String ticker;
    private int quantity;
    private double buyPrice;
    private String userid;
    private Double currentPrice;

    // Default no-argument constructor (required by Jackson)
    public StocksDto() {
    }

    // Constructor with all fields
    public StocksDto(Long id, String name, String ticker, int quantity, double buyPrice, String userid, Double currentPrice) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.userid = userid;
        this.currentPrice = currentPrice;
    }

    // Existing constructor without `currentPrice` for compatibility
    public StocksDto(Long id, String name, String ticker, int quantity, double buyPrice, String userid) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.userid = userid;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
