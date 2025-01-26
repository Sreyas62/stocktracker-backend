package net.tracker.stocktracker.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockPriceFetcher {
    private static final String API_URL = "https://www.alphavantage.co/query";
    private static final String API_KEY = "XVQWCN6U0PP1E258";

    public Double fetchCurrentPrice(String ticker) {
        try {
            String symbol = ticker + ".BSE"; // Append ".BSE" to the ticker
            String url = API_URL + "?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            // Print the raw JSON response to the console


            // Parse JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            System.out.println("API Response: " + rootNode.path("Global Quote").path("05. price").asDouble());

            // Extract and return the current price
            return rootNode.path("Global Quote").path("05. price").asDouble();

        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exceptions gracefully
        }
    }
}
