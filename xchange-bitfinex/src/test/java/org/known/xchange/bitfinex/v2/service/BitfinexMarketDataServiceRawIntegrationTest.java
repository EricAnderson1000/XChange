package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.known.xchange.bitfinex.v2.BitfinexExchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexBook;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexSingleTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;

public class BitfinexMarketDataServiceRawIntegrationTest {

  private Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
  private BitfinexMarketDataServiceRaw marketDataServiceRaw = (BitfinexMarketDataServiceRaw) exchange.getMarketDataService();

  @Test
  public void testGetTickersRaw() throws Exception {

    List<BitfinexTicker> tickers = marketDataServiceRaw.getTickersRaw(Arrays.asList("tBTCUSD"));

    assertThat(tickers).isNotNull();
    assertThat(tickers.get(0).getSymbol()).isEqualTo("tBTCUSD");
  }

  @Test
  public void testGetTickerRaw() throws Exception {

    BitfinexSingleTicker ticker = marketDataServiceRaw.getTickerRaw("tBTCUSD");

    assertThat(ticker).isNotNull();
    assertThat(ticker.getAsk()).isGreaterThan(new BigDecimal(100));
  }

  @Test
  public void testGetBooksRaw() throws Exception {

    List<BitfinexBook> books = marketDataServiceRaw.getBooksRaw("tBTCUSD", Optional.empty());

    assertThat(books).isNotNull();
    assertThat(books.size()).isGreaterThan(1);
  }

}
