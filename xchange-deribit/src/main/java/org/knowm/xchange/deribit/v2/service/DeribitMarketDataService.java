package org.knowm.xchange.deribit.v2.service;

import java.io.IOException;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.deribit.v2.DeribitAdapters;
import org.knowm.xchange.deribit.v2.DeribitExchange;
import org.knowm.xchange.deribit.v2.dto.marketdata.DeribitOrderBook;
import org.knowm.xchange.deribit.v2.dto.marketdata.DeribitTicker;
import org.knowm.xchange.deribit.v2.dto.marketdata.DeribitTrades;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.service.marketdata.MarketDataService;

/**
 * Implementation of the market data service for Bitmex
 *
 * <ul>
 *   <li>Provides access to various market data values
 * </ul>
 */
public class DeribitMarketDataService extends DeribitMarketDataServiceRaw
    implements MarketDataService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public DeribitMarketDataService(DeribitExchange exchange) {

    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
    String deribitInstrumentName = DeribitAdapters.adaptInstrumentName(currencyPair);
    DeribitTicker deribitTicker = super.getDeribitTicker(deribitInstrumentName);
    return DeribitAdapters.adaptTicker(deribitTicker);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
    String deribitInstrumentName = DeribitAdapters.adaptInstrumentName(currencyPair);
    DeribitOrderBook deribitOrderBook = super.getDeribitOrderBook(deribitInstrumentName);
    return DeribitAdapters.adaptOrderBook(deribitOrderBook);
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {
    String deribitInstrumentName = DeribitAdapters.adaptInstrumentName(currencyPair);
    DeribitTrades deribitTrades = super.getDeribitLastTrades(deribitInstrumentName);
    return DeribitAdapters.adaptTrades(deribitTrades);
  }
}
