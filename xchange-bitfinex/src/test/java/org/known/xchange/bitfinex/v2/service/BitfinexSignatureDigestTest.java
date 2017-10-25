package org.known.xchange.bitfinex.v2.service;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import si.mazi.rescu.RestInvocation;

import java.util.HashMap;
import java.util.Map;

import static org.powermock.api.mockito.PowerMockito.mock;

import static org.assertj.core.api.Assertions.assertThat;

public class BitfinexSignatureDigestTest {

  private String secretKey = "qZHMUKSgzrYBI9j1pR1BQlmclOIFU8ZwtMxmlxLu6Bo";

  private BitfinexSignatureDigest bitfinexSignatureDigest = BitfinexSignatureDigest.createInstance(secretKey);

  @Test
  public void testEncode() {

    Map<String, String> headers = new HashMap<>();
    headers.put("bfx-nonce", "607596437");

    RestInvocation mockRestInvocation = mock(RestInvocation.class);
    PowerMockito.when(mockRestInvocation.getRequestBody()).thenReturn("{}");
    PowerMockito.when(mockRestInvocation.getPath()).thenReturn("/v2/auth/r/wallets6");
    PowerMockito.when(mockRestInvocation.getHttpHeadersFromParams()).thenReturn(headers);

    String result = bitfinexSignatureDigest.digestParams(mockRestInvocation);

    assertThat(result).isEqualTo("45c2119bdcf3ca57da53f02bed13867a063eafc8aef51ffe027b46b22e752953a3d9ea9678f565538ce9c41e58f17c12");
  }

}
