package org.known.xchange.bitfinex.v2.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.knowm.xchange.Exchange;
import org.known.xchange.bitfinex.v2.dto.marketdata.*;

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

  public List<BitfinexTrade> getTradesRaw(String symbol) throws IOException {

     return bitfinex.getTrades(symbol);
  }

  /**
   * Various statistics about the requested pair.
   *
   * see https://docs.bitfinex.com/v2/reference#rest-public-stats
   *
   * @param key (pos.size, funding.size, credits.size, credits.size.sym)
   * @param size (1m)
   * @param symbol
   * @return
   * @throws IOException
   */
  public BitfinexStat getStatRaw(String key, String size, String symbol) throws IOException {

    return bitfinex.getStat(key, size, symbol);
  }

  /**
   * Provides a way to access charting candle info
   *
   * see https://docs.bitfinex.com/v2/reference#rest-public-candles
   *
   * @param timeframe ('1m', '5m', '15m', '30m', '1h', '3h', '6h', '12h', '1D', '7D', '14D', '1M')
   * @param symbol
   * @param section ("last", "hist")
   * @return
   * @throws IOException
   */
  public BitfinexCandle getCandleRaw(String timeframe, String symbol, String section) throws IOException {

    return bitfinex.getCandle(timeframe, symbol, section);
  }

}