package org.known.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.Date;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "mts", "open", "close", "high", "low", "volume" })
public class BitfinexCandle {

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Long mts;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal open;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal close;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal high;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal low;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal volume;

  public Long getMts() {
    return mts;
  }

  public BigDecimal getOpen() {
    return open;
  }

  public BigDecimal getClose() {
    return close;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public BigDecimal getLow() {
    return low;
  }

  public BigDecimal getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "BitfinexCandle{" +
        "mts=" + mts +
        ", open=" + open +
        ", close=" + close +
        ", high=" + high +
        ", low=" + low +
        ", volume=" + volume +
        '}';
  }
}
