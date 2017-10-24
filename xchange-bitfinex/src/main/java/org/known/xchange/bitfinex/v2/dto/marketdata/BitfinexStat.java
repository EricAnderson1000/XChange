package org.known.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.Date;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "mts", "value" })
public class BitfinexStat {

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Long mts;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal value;

  public Date getTimestamp() {
    return new Date(mts);
  }

  public Long getMts() {
    return mts;
  }

  public BigDecimal getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "BitfinexStat{" +
        "mts=" + mts +
        ", value=" + value +
        '}';
  }
}
