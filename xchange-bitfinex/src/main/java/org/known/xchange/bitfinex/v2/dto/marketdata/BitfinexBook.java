package org.known.xchange.bitfinex.v2.dto.marketdata;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"price", "count", "amount"})
public class BitfinexBook {

  private BigDecimal price;
  private BigDecimal count;
  private BigDecimal amount;

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getCount() {
    return count;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "BitfinexBooks{" +
        "price=" + price +
        ", count=" + count +
        ", ammount=" + amount +
        '}';
  }
}
