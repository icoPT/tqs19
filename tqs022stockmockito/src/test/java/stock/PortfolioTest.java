package stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PortfolioTest {

    @Mock
    private StockMarket marketMock;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void getTotalValue() {
        Portfolio portfolio = new Portfolio();
        portfolio.setStockMarket(marketMock);

        Mockito.when( marketMock.getPrice("EBAY")).thenReturn( 42.0);
        //Mockito.when( marketMock.getPrice("MSFT")).thenReturn( 66.0);

        Stock ebayStock = new Stock("EBAY", 2);
        portfolio.addStock(ebayStock);

        Assertions.assertEquals(84.00, portfolio.getTotalValue(), 0.001);
    }
}