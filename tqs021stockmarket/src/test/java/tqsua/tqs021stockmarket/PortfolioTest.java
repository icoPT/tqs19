package tqsua.tqs021stockmarket;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PortfolioTest extends EasyMockSupport {
    
    /// @Mock
    private StockMarket marketMock;

    //// @TestSubject
    private Portfolio portfolio = new Portfolio();

    @BeforeEach
    public void setUp() {

        portfolio.setName("Portfolio 1");
        marketMock = EasyMock.createStrictMock(StockMarket.class);
        portfolio.setStockMarket(marketMock);
    }

    @Test
    public void testGetTotalValue() {

        /* = Setup our mock object with the expected values */
        EasyMock.expect(marketMock.getPrice("EBAY")).andReturn(42.00);
        // EasyMock.expect(marketMock.getPrice("MSFT")).andReturn(50.00);
        // EasyMock.expect(marketMock.getPrice("ORAC")).andReturn(142.00);
        EasyMock.replay(marketMock);

        /* = Now start testing our portfolio */
        Stock ebayStock = new Stock("EBAY", 2);
        portfolio.addStock(ebayStock);
        
        Assertions.assertEquals(84.00, portfolio.getTotalValue(), 0.001);
        EasyMock.verify(marketMock);
    }

}
