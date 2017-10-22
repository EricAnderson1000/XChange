package org.known.xchange.bitfinex.v2;

import java.io.IOException;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.utils.nonce.AtomicLongIncrementalTime2013NonceFactory;
import org.known.xchange.bitfinex.v2.service.BitfinexMarketDataService;

import si.mazi.rescu.SynchronizedValueFactory;

public class BitfinexExchange extends BaseExchange implements Exchange {

  private SynchronizedValueFactory<Long> nonceFactory = new AtomicLongIncrementalTime2013NonceFactory();

  @Override
  protected void initServices() {
    this.marketDataService = new BitfinexMarketDataService(this);
//    this.accountService = new BitfinexAccountService(this);
//    this.tradeService = new BitfinexTradeService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://api.bitfinex.com");
    exchangeSpecification.setHost("api.bitfinex.com");
    exchangeSpecification.setPort(443);
    exchangeSpecification.setExchangeName("BitFinex");
    exchangeSpecification.setExchangeDescription("BitFinex is a bitcoin exchange.");

    return exchangeSpecification;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {

    return nonceFactory;
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {

//    BitfinexMarketDataServiceRaw dataService = (BitfinexMarketDataServiceRaw) this.marketDataService;
//    List<CurrencyPair> currencyPairs = dataService.getExchangeSymbols();
//    exchangeMetaData = BitfinexAdapters.adaptMetaData(currencyPairs, exchangeMetaData);

  }

}
