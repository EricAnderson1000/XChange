package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.known.xchange.bitfinex.v2.BitfinexExchange;

public class BitfinexMarketDataServiceIntegrationTest {

  @Test
  public void testGetTicker_BTCUSD() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
    MarketDataService marketDataService = exchange.getMarketDataService();

    Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);

    assertThat(ticker).isNotNull();
    assertThat(ticker.getAsk()).isGreaterThan(new BigDecimal("1"));
  }

}
