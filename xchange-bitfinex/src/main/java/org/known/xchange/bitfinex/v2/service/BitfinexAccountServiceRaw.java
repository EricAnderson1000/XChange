package org.known.xchange.bitfinex.v2.service;

import org.knowm.xchange.Exchange;
import org.known.xchange.bitfinex.v2.dto.account.Order;
import org.known.xchange.bitfinex.v2.dto.account.Wallet;
import org.known.xchange.bitfinex.v2.dto.account.EmptyRequest;

import java.io.IOException;
import java.util.List;

public class BitfinexAccountServiceRaw extends BitfinexBaseService {

  private static final EmptyRequest EMPTY_REQUEST = new EmptyRequest();

  public BitfinexAccountServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public List<Wallet> getWallets() throws IOException {

    return bitfinex.getWallets(apiKey, String.valueOf(exchange.getNonceFactory().createValue()), signatureCreator, EMPTY_REQUEST);
  }

  public List<Order> getOrders(String symbol) throws IOException {

    return bitfinex.getOrders(apiKey, String.valueOf(exchange.getNonceFactory().createValue()), signatureCreator, symbol, EMPTY_REQUEST);
  }





}
