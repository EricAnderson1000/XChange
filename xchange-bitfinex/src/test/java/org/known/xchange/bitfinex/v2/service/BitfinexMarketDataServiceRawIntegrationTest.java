package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.known.xchange.bitfinex.v2.BitfinexExchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.*;

public class BitfinexMarketDataServiceRawIntegrationTest {

  private Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());

  private BitfinexMarketDataServiceRaw marketDataServiceRaw = (BitfinexMarketDataServiceRaw) exchange.getMarketDataService();

  private static final String BTC_USD_SYMBOL = "tBTCUSD";

  @Test
  public void testGetTickersRaw() throws IOException {

    List<BitfinexTicker> tickers = marketDataServiceRaw.getTickersRaw(Arrays.asList(BTC_USD_SYMBOL));

    assertThat(tickers).isNotNull();
    assertThat(tickers.get(0).getSymbol()).isEqualTo(BTC_USD_SYMBOL);
  }

  @Test
  public void testGetTickerRaw() throws IOException {

    BitfinexSingleTicker ticker = marketDataServiceRaw.getTickerRaw(BTC_USD_SYMBOL);

    assertThat(ticker).isNotNull();
    assertThat(ticker.getAsk()).isGreaterThan(new BigDecimal(100));
  }

  @Test
  public void testGetBooksRaw() throws IOException {

    List<BitfinexBook> books = marketDataServiceRaw.getBooksRaw(BTC_USD_SYMBOL, Optional.empty());

    assertThat(books).isNotNull();
    assertThat(books.size()).isGreaterThan(1);
  }

  @Test
  public void testGetTradesRaw() throws IOException {

    List<BitfinexTrade> trades = marketDataServiceRaw.getTradesRaw(BTC_USD_SYMBOL);

    assertThat(trades).isNotNull();
    assertThat(trades.size()).isGreaterThan(1);
    System.out.println(trades);
  }

  @Test
  public void testGetStatRaw() throws IOException {

    BitfinexStat bitfinexStat = marketDataServiceRaw.getStatRaw("pos.size", "1m", BTC_USD_SYMBOL);

    assertThat(bitfinexStat).isNotNull();
    assertThat(bitfinexStat.getValue()).isGreaterThan(BigDecimal.ONE);
  }

  @Test
  public void testGetCandleRaw() throws IOException {

    BitfinexCandle bitfinexCandle = marketDataServiceRaw.getCandleRaw("1m", BTC_USD_SYMBOL, "last");

    assertThat(bitfinexCandle).isNotNull();
    assertThat(bitfinexCandle.getOpen()).isGreaterThan(BigDecimal.ONE);
  }

}
