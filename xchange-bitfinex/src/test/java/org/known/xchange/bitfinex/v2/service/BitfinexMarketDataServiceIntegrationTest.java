package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.known.xchange.bitfinex.v2.BitfinexExchange;

public class BitfinexMarketDataServiceIntegrationTest {

  private Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());

  private MarketDataService marketDataService = exchange.getMarketDataService();

  @Test
  public void testGetTicker_BTCUSD() throws Exception {

    Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);

    assertThat(ticker).isNotNull();
    assertThat(ticker.getAsk()).isGreaterThan(new BigDecimal("1"));
  }

  @Test
  public void testGetOrderBook_BTCUSD() throws Exception {

    OrderBook orderBook = marketDataService.getOrderBook(CurrencyPair.BTC_USD);

    assertThat(orderBook).isNotNull();
    assertThat(orderBook.getBids().size()).isGreaterThan(1);
    assertThat(orderBook.getAsks().size()).isGreaterThan(1);
    assertThat(orderBook.getAsks().get(0).getLimitPrice()).isGreaterThan(orderBook.getBids().get(0).getLimitPrice());
  }

}
