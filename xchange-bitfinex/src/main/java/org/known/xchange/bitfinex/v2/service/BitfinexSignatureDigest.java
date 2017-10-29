package org.known.xchange.bitfinex.v2.service;

import net.iharder.Base64;
import org.knowm.xchange.service.BaseParamsDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.RestInvocation;

import javax.crypto.Mac;
import java.math.BigInteger;

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

//  /**
//   * Signature generation. See https://docs.bitfinex.com/v2/docs/rest-auth
//   *
//   * @param restInvocation
//   * @return
//   */
  @Override
  public String digestParams(RestInvocation restInvocation) {

    String body = (restInvocation.getRequestBody() != null) ?
        restInvocation.getRequestBody()
        : "{}";

    String signature = "/api" + restInvocation.getPath() +
        restInvocation.getHttpHeadersFromParams().get("bfx-nonce") + body;

    System.out.println("About to sign: " + signature);

    return digestParamsDirect(signature);
  }

  public String digestParamsDirect(String value) {

    Mac mac = getMac();
    mac.update(value.getBytes());

    return String.format("%096x", new BigInteger(1, mac.doFinal()));
  }




//  @Override
//  public String digestParams(RestInvocation restInvocation) {
//
//    Mac mac = getMac();
//    mac.update(restInvocation.getMethodPath().getBytes());
//    mac.update(new byte[]{0});
//    mac.update(restInvocation.getRequestBody().getBytes());
//
//    return Base64.encodeBytes(mac.doFinal()).trim();
//  }
}
