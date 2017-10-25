package org.known.xchange.bitfinex.v2.service;

import org.junit.Test;

import java.io.IOException;

public class BitfinexAccountServiceRawIntegrationTest extends BaseAuthenticatedServiceTest {

  private static final String BTC_USD_SYMBOL = "tBTCUSD";


  @Test
  public void testGetWallets() throws IOException {
    BitfinexAccountServiceRaw bitfinexAccountServiceRaw = (BitfinexAccountServiceRaw) exchange.getAccountService();

    bitfinexAccountServiceRaw.getWallets();
  }

}
