package org.known.xchange.bitfinex.v2.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import org.known.xchange.bitfinex.v2.BitfinexAuthenticated;

import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

public class BitfinexBaseService extends BaseExchangeService implements BaseService {

  protected final String apiKey;
  protected final BitfinexAuthenticated bitfinex;
  protected final ParamsDigest signatureCreator;
  protected final ParamsDigest payloadCreator;

  public BitfinexBaseService(Exchange exchange) {

    super(exchange);

    bitfinex = RestProxyFactory.createProxy(BitfinexAuthenticated.class, exchange.getExchangeSpecification().getSslUri(), getClientConfig());
    apiKey = exchange.getExchangeSpecification().getApiKey();
    signatureCreator = BitfinexSignatureDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
    payloadCreator = new BitfinexPayloadDigest();
  }

}
