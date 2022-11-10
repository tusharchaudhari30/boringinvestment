package com.boringinvestment.controller;

import com.boringinvestment.model.Asset;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/asset")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class AssetInfoController {

    @GET
    @Path("/search")
    public List<Asset> searchListAsset(@QueryParam("keyword") String keyword){
        return Asset.find("assetName like ?1","/^"+keyword+"/i").list();
    }
}
