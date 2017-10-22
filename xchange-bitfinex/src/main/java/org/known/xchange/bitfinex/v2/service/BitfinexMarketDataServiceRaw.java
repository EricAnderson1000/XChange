package org.known.xchange.bitfinex.v2.service;

import java.io.IOException;
import java.util.List;

import org.knowm.xchange.Exchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;

/**
 * Provides RAW access to the public APIs.
 *
 * See https://bitfinex.readme.io/v2/reference
 */
public class BitfinexMarketDataServiceRaw extends BitfinexBaseService {

  public BitfinexMarketDataServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public List<BitfinexTicker> getTickersRaw(List<String> currencyPairs) throws IOException {

    return bitfinex.getTickers(currencyPairs);
  }

}