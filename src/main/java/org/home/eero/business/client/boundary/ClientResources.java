/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.home.eero.business.client.boundary;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author eerosihvonen
 */
@Path("clients")
@Stateless
public class ClientResources {
    
    @Inject
    Logger LOG;
    
    @Inject
    String name;
    
    
    @GET
    public String clients() {
        LOG.info("Fetching clients!");
        return "Clients jaxrs " + name;
    }
    
}
