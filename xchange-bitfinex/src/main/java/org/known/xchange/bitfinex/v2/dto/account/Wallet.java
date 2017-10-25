package org.known.xchange.bitfinex.v2.dto.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"walletType", "currency", "balance", "unsettledInterest", "balanceAvailable"})
public class Wallet {

  private String walletType;

  private String currency;

  private BigDecimal balance;

  private BigDecimal unsettledInterest;

  private BigDecimal balanceAvailable;

  public String getWalletType() {
    return walletType;
  }

  public String getCurrency() {
    return currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public BigDecimal getUnsettledInterest() {
    return unsettledInterest;
  }

  public BigDecimal getBalanceAvailable() {
    return balanceAvailable;
  }

  @Override
  public String toString() {
    return "Wallet{" +
        "walletType='" + walletType + '\'' +
        ", currency='" + currency + '\'' +
        ", balance=" + balance +
        ", unsettledInterest=" + unsettledInterest +
        ", balanceAvailable=" + balanceAvailable +
        '}';
  }
}
