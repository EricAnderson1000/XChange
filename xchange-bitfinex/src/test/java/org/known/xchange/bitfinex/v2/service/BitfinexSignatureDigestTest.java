package org.known.xchange.bitfinex.v2.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import si.mazi.rescu.RestInvocation;

public class BitfinexSignatureDigestTest {

  private String secretKey = "dAEJS14Oo1XgidftMl9axmPeSSsGrkF2xGxItVuI8Fm";

  private BitfinexSignatureDigest bitfinexSignatureDigest = BitfinexSignatureDigest.createInstance(secretKey);

  @Test
  public void testEncode() {

    String result = bitfinexSignatureDigest.digestParamsDirect("/api/v2/auth/r/alerts1509293963223{\"type\":\"price\"}");

    assertThat(result).isEqualTo("feab05bfe98b12ee99c82f47d90fef07dd7376fbd28939a66eef8761fdae3a7bfdf10a87a5d2529c82b7d7a1090c9ab7");
  }

}
