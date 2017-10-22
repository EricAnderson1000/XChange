package org.known.xchange.bitfinex.v2.dto.marketdata;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "id", "mts", "amount", "price" })
public class BitfinexTrade {

  /**
   * ID,
   * MTS,
   * AMOUNT,
   * PRICE
   *
   */

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private String id;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Long mts;

  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private BigDecimal amount;

  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private BigDecimal price;

  public String getId() {
    return id;
  }

  public Long getMts() {
    return mts;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "BitfinexTrade{" +
        "id='" + id + '\'' +
        ", mts='" + mts + '\'' +
        ", amount=" + amount +
        ", price=" + price +
        '}';
  }
}
