package org.known.xchange.bitfinex.v2;

import org.known.xchange.bitfinex.v2.dto.account.Wallet;
import org.known.xchange.bitfinex.v2.dto.account.WalletRequest;
import org.known.xchange.bitfinex.v2.dto.marketdata.BitfinexTicker;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/v2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BitfinexAuthenticated extends Bitfinex {

  @POST
  @Path("/auth/r/wallets")
  List<Wallet> getWallets(
      @HeaderParam("bfx-apikey") String apiKey, @HeaderParam("bfx-nonce") String nonce,
      @HeaderParam("bfx-signature") ParamsDigest signature, WalletRequest walletRequest) throws IOException;


}
