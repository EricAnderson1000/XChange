package org.known.xchange.bitfinex.v2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexBook;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexSingleTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTrade;

public class BitfinexAdapters {

  public static Ticker adaptTicker(BitfinexSingleTicker bitfinexTicker, CurrencyPair currencyPair) {

    BigDecimal last = bitfinexTicker.getLastPrice();
    BigDecimal bid = bitfinexTicker.getBid();
    BigDecimal ask = bitfinexTicker.getAsk();
    BigDecimal high = bitfinexTicker.getHigh();
    BigDecimal low = bitfinexTicker.getLow();
    BigDecimal volume = bitfinexTicker.getVolume();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .volume(volume)
        .build();
  }

  public static String adaptCurrencyPair(CurrencyPair currencyPair) {

    return "t" + currencyPair.base + currencyPair.counter;
  }

  public static LimitOrder adaptBook(BitfinexBook bitfinexBook, CurrencyPair currencyPair, Date timestamp) {

    Order.OrderType orderType = getOrderTypeFromAmount(bitfinexBook.getAmount());
    return new LimitOrder(orderType, bitfinexBook.getAmount(), currencyPair, "", timestamp, bitfinexBook.getPrice());
  }

  public static OrderBook adaptOrderBooks(List<BitfinexBook> books, CurrencyPair currencyPair) {

    Date artificialTimestamp = new Date();

    List<LimitOrder> asks = new ArrayList<>();
    List<LimitOrder> bids = new ArrayList<>();
    for (BitfinexBook bitfinexBook : books) {
      LimitOrder limitOrder = adaptBook(bitfinexBook, currencyPair, artificialTimestamp);

      if (limitOrder.getType() == Order.OrderType.BID) {
        bids.add(limitOrder);
      } else {
        asks.add(limitOrder);
      }
    }

    return new OrderBook(artificialTimestamp, asks, bids);
  }

  public static Trades adaptTrades(List<BitfinexTrade> trades, CurrencyPair currencyPair) {

    List<Trade> convertedTrades = trades.stream()
        .map( bitfinexTrade -> adaptTrade(bitfinexTrade, currencyPair))
        .collect(Collectors.toList());

    return new Trades(convertedTrades, Trades.TradeSortType.SortByTimestamp);
  }

  public static Trade adaptTrade(BitfinexTrade trade, CurrencyPair currencyPair) {

    return new Trade.Builder()
        .type(getOrderTypeFromAmount(trade.getAmount()))
        .currencyPair(currencyPair)
        .id(trade.getId())
        .originalAmount(trade.getAmount().abs())
        .price(trade.getPrice())
        .timestamp(new Date(trade.getMts()))
        .build();
  }

  public static Order.OrderType getOrderTypeFromAmount(BigDecimal amount) {
    return (amount.compareTo(BigDecimal.ZERO)) > 0 ?
        Order.OrderType.BID :
        Order.OrderType.ASK;
  }

}
