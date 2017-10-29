package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.known.xchange.bitfinex.v2.dto.account.Order;
import org.known.xchange.bitfinex.v2.dto.account.Wallet;

import java.io.IOException;
import java.util.List;

public class BitfinexAccountServiceRawIntegrationTest extends BaseAuthenticatedServiceTest {

  private static final String BTC_USD_SYMBOL = "tBTCUSD";


  @Test
  public void testGetWallets() throws IOException {

    BitfinexAccountServiceRaw bitfinexAccountServiceRaw = (BitfinexAccountServiceRaw) exchange.getAccountService();
    List<Wallet> wallets = bitfinexAccountServiceRaw.getWallets();

    assertThat(wallets).isNotNull();
  }

  @Test
  public void testGetOrders() throws IOException {

    BitfinexAccountServiceRaw bitfinexAccountServiceRaw = (BitfinexAccountServiceRaw) exchange.getAccountService();
    List<Order> orders = bitfinexAccountServiceRaw.getOrders(BTC_USD_SYMBOL);

    assertThat(orders).isNotNull();
  }

}
