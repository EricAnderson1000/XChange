package org.known.xchange.bitfinex.v2.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.known.xchange.bitfinex.v2.Bitfinex;
import org.known.xchange.bitfinex.v2.BitfinexAdapters;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;

import com.google.gdata.util.common.base.Preconditions;

/**
 * <p>
 * Implementation of the market data service for Bitfinex
 * </p>
 * <ul>
 * <li>Provides access to various market data values</li>
 * </ul>
 */
public class BitfinexMarketDataService extends BitfinexMarketDataServiceRaw implements MarketDataService {

  public BitfinexMarketDataService(Exchange exchange) {

    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    List<BitfinexTicker> tickers = getTickersRaw(Arrays.asList(BitfinexAdapters.adaptCurrencyPair(currencyPair)));
    if (tickers.size() != 1) {
      throw new IllegalStateException("Expected 1 result for getTickets, but found " + tickers.size());
    }

    return BitfinexAdapters.adaptTicker(tickers.get(0), currencyPair);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
    return null;
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
    return null;
  }
}
