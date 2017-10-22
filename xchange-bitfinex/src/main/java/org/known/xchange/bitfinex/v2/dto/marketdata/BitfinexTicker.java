package org.known.xchange.bitfinex.v2.dto.marketdata;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "symbol", "bid", "bidSize", "ask", "askSize", "dailyChange", "dailyChangePerc", "lastPrice", "volume", "high", "low" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitfinexTicker {

  /**
   *
   * Example response
   *  [["tBTCUSD",5957.7,87.12840151,5957.8,89.47708838,-185.1,-0.0301,5957.8,58375.57413207,6159.5,5705]]
   *
   *  SYMBOL,
   * BID,
   * BID_SIZE,
   * ASK,
   * ASK_SIZE,
   * DAILY_CHANGE,
   * DAILY_CHANGE_PERC,
   * LAST_PRICE,
   * VOLUME,
   * HIGH,
   * LOW
   *
   */

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private String symbol;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal bid;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal bidSize;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal ask;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal askSize;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal dailyChange;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal dailyChangePerc;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal lastPrice;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Integer volume;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal high;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal low;

  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getBid() {
    return bid;
  }

  public BigDecimal getBidSize() {
    return bidSize;
  }

  public BigDecimal getAsk() {
    return ask;
  }

  public BigDecimal getAskSize() {
    return askSize;
  }

  public BigDecimal getDailyChange() {
    return dailyChange;
  }

  public BigDecimal getDailyChangePerc() {
    return dailyChangePerc;
  }

  public BigDecimal getLastPrice() {
    return lastPrice;
  }

  public Integer getVolume() {
    return volume;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public BigDecimal getLow() {
    return low;
  }

  @Override
  public String toString() {
    return "BitfinexTicker{" +
        "symbol='" + symbol + '\'' +
        ", bid=" + bid +
        ", bidSize=" + bidSize +
        ", ask=" + ask +
        ", askSize=" + askSize +
        ", dailyChange=" + dailyChange +
        ", dailyChangePerc=" + dailyChangePerc +
        ", lastPrice=" + lastPrice +
        ", volume=" + volume +
        ", high=" + high +
        ", low=" + low +
        '}';
  }
}
