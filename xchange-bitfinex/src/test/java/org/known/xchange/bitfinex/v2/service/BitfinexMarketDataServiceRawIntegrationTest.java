package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.known.xchange.bitfinex.v2.BitfinexExchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;

public class BitfinexMarketDataServiceRawIntegrationTest {

  @Test
  public void testGetTickers() throws Exception {

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
    BitfinexMarketDataServiceRaw marketDataServiceRaw = (BitfinexMarketDataServiceRaw) exchange.getMarketDataService();
    List<BitfinexTicker> tickers = marketDataServiceRaw.getTickers(Arrays.asList("tBTCUSD"));

    assertThat(tickers).isNotNull();
    assertThat(tickers.get(0).getSymbol()).isEqualTo("tBTCUSD");
  }

}
