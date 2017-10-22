package org.known.xchange.bitfinex.v2.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexBook;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexSingleTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTrade;

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

    BitfinexSingleTicker ticker = getTickerRaw(BitfinexAdapters.adaptCurrencyPair(currencyPair));

    return BitfinexAdapters.adaptTicker(ticker, currencyPair);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    String precision = (args == null || args.length == 0) ?
        null : (String) args[0];

    List<BitfinexBook> books = getBooksRaw(BitfinexAdapters.adaptCurrencyPair(currencyPair), Optional.ofNullable(precision));

    return BitfinexAdapters.adaptOrderBooks(books, currencyPair);
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    List<BitfinexTrade> trades = getTradesRaw(BitfinexAdapters.adaptCurrencyPair(currencyPair));
    return BitfinexAdapters.adaptTrades(trades, currencyPair);
  }
}
