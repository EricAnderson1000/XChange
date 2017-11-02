package org.known.xchange.bitfinex.v2;

import org.known.xchange.bitfinex.v2.dto.account.Order;
import org.known.xchange.bitfinex.v2.dto.account.Wallet;
import org.known.xchange.bitfinex.v2.dto.account.EmptyRequest;

import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/v2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BitfinexAuthenticated extends Bitfinex {

  /**
   * Get account wallets
   * https://docs.bitfinex.com/v2/reference#rest-auth-wallets
   */
  @POST
  @Path("/auth/r/wallets")
  List<Wallet> getWallets(
      @HeaderParam("bfx-apikey") String apiKey, @HeaderParam("bfx-nonce") String nonce,
      @HeaderParam("bfx-signature") ParamsDigest signature, EmptyRequest walletRequest) throws IOException;

  /**
   * Get active orders
   * https://docs.bitfinex.com/v2/reference#rest-auth-orders
   */
  @POST
  @Path("auth/r/orders/${symbol}")
  List<Order> getOrders(@HeaderParam("bfx-apikey") String apiKey, @HeaderParam("bfx-nonce") String nonce,
      @HeaderParam("bfx-signature") ParamsDigest signature, @PathParam("symbol") String symbol, EmptyRequest emptyRequest) throws IOException;

  /**
   * https://docs.bitfinex.com/v2/reference#rest-auth-calc-bal-avail
   */
  @POST
  @Path("auth/calc/order/avail")
  void getBalance(@HeaderParam("bfx-apikey") String apiKey, @HeaderParam("bfx-nonce") String nonce,
      @HeaderParam("bfx-signature") ParamsDigest signature) throws IOException;




}
