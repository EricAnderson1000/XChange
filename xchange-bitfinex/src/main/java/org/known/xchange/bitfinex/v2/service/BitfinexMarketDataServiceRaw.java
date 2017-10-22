package org.known.xchange.bitfinex.v2.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.knowm.xchange.Exchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexBook;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexSingleTicker;
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

  public List<BitfinexTicker> getTickersRaw(List<String> symbols) throws IOException {

    return bitfinex.getTickers(symbols);
  }


  public BitfinexSingleTicker getTickerRaw(String symbol) throws IOException {

    return bitfinex.getTicker(symbol);
  }

  public List<BitfinexBook> getBooksRaw(String symbol, Optional<String> precision) throws IOException {

    return bitfinex.getBooks(symbol, precision.orElse("P0"));
  }
}