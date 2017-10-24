package org.known.xchange.bitfinex.v2;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.known.xchange.bitfinex.v2.dto.marketdata.*;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface Bitfinex {

  @GET
  @Path("/tickers")
  List<BitfinexTicker> getTickers(@QueryParam("symbols") List<String> symbols) throws IOException;

  @GET
  @Path("/ticker/{symbol}")
  BitfinexSingleTicker getTicker(@PathParam("symbol") String symbol) throws IOException;

  @GET
  @Path("book/{symbol}/{precision}")
  List<BitfinexBook> getBooks(@PathParam("symbol") String symbol, @PathParam("precision") String precision) throws IOException;

  @GET
  @Path("trades/{symbol}/hist")
  List<BitfinexTrade> getTrades(@PathParam("symbol") String symbol) throws IOException;

  @GET
  @Path("stats1/{key}:{size}:{symbol}:long/last")
  BitfinexStat getStat(@PathParam("key") String key, @PathParam("size") String size, @PathParam("symbol") String symbol) throws IOException;


  @GET
  @Path("candles/trade:{timeframe}:{symbol}/{section}")
  BitfinexCandle getCandle(@PathParam("timeframe") String timeframe, @PathParam("symbol") String symbol, @PathParam("section") String section) throws IOException;

}