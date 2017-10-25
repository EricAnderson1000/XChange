package org.known.xchange.bitfinex.v2.service;

import org.junit.BeforeClass;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.known.xchange.bitfinex.v2.BitfinexExchange;

/**
 *
 * -Dbitfinex_api_key=XXXXXX
 * -Dbitfinex_secret_key=YYYYYYYYY
 *
 */
public class BaseAuthenticatedServiceTest {

  protected static Exchange exchange;

  private static final String API_KEY = "bitfinex_api_key";
  private static final String SECRET_KEY = "bitfinex_secret_key";

  public static String getApiKey() {
    return System.getProperty(API_KEY);
  }

  public static String getSecret() {
    return System.getProperty(SECRET_KEY);
  }

  @BeforeClass
  public static void setUpBaseClass() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(BitfinexExchange.class);
    exchangeSpecification.setApiKey(getApiKey());
    exchangeSpecification.setSecretKey(getSecret());

    exchange = ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);
  }

}