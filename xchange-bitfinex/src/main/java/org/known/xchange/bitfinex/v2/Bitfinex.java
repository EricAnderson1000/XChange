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

import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexBook;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexSingleTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTrade;

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

}