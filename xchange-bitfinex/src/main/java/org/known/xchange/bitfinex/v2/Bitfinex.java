package org.known.xchange.bitfinex.v2;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface Bitfinex {

  //TODO add optional query params
  @GET
  @Path("/tickers")
  List<BitfinexTicker> getTickers(@QueryParam("symbols") List<String> symbols) throws IOException;

}