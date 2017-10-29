package org.known.xchange.bitfinex.v2.service;

import java.math.BigInteger;

import javax.crypto.Mac;

import org.knowm.xchange.service.BaseParamsDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.mazi.rescu.RestInvocation;

public class BitfinexSignatureDigest extends BaseParamsDigest {

  private static Logger LOGGER = LoggerFactory.getLogger(BitfinexSignatureDigest.class);


  /**
   * Constructor
   *
   * @param base64secretKey
   * @throws IllegalArgumentException if key is invalid (cannot be base-64-decoded or the decoded key is invalid).
   */
  private BitfinexSignatureDigest(String base64secretKey) {

    super(base64secretKey, HMAC_SHA_384);
  }

  public static BitfinexSignatureDigest createInstance(String base64secretKey) {

    return new BitfinexSignatureDigest(base64secretKey);
  }

  /**
   * Signature generation. See https://docs.bitfinex.com/v2/docs/rest-auth
   *
   * @param restInvocation
   * @return
   */
  @Override
  public String digestParams(RestInvocation restInvocation) {

    String body = (restInvocation.getRequestBody() != null) ?
        restInvocation.getRequestBody()
        : "{}";

    String signature = "/api" + restInvocation.getPath() +
        restInvocation.getHttpHeadersFromParams().get("bfx-nonce") + body;

    return digestParamsDirect(signature);
  }

  protected String digestParamsDirect(String value) {

    Mac mac = getMac();
    mac.update(value.getBytes());

    return String.format("%096x", new BigInteger(1, mac.doFinal()));
  }

}
