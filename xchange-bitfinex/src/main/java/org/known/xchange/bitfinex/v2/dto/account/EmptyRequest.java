package org.known.xchange.bitfinex.v2.dto.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 *
 * For some reason, all Bitfinex requests need to have an empty JSON body, or they fail signature validation
 *
 */
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.NONE)
public class EmptyRequest {


}
