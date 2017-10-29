package org.known.xchange.bitfinex.v2.dto.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"id", "gid", "cid", "symbol", "mtsCreate", "mtsUpdate", "amount", "amountOrig", "type", "typePrev", "flags", "orderStatus",
                       "price", "priceAvg", "priceTrailing", "priceAuxLimit", "notify", "hidden", "placedId"})
public class Order {

  private BigDecimal id;

  private BigDecimal gid;

  private BigDecimal cid;

  private String symbol;

  private BigDecimal mtsCreate;

  private BigDecimal mtsUpdate;

  private BigDecimal amount;

  private BigDecimal amountOrig;

  private String type;

  private String typePrev;

  private String flags;

  private String orderStatus;

  private BigDecimal price;

  private BigDecimal priceAvg;

  private BigDecimal priceTrailing;

  private BigDecimal priceAuxLimit;

  private Boolean notifiy;

  private Boolean hidden;

  private BigDecimal placedId;





}
