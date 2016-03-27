/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.home.eero.business.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eerosihvonen
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Startup
@Path("configurations")
@Produces(MediaType.APPLICATION_JSON)
public class Configurator {
    
    private static final Map<String, String> properties = new HashMap<>();
    
    private ResourceBundle bundle;
    
    @PostConstruct
    public void init() {
        this.bundle = ResourceBundle.getBundle("configurations");
        loadResourceBundleValuesToMap();
    }

    private void loadResourceBundleValuesToMap() {
        bundle.keySet().stream().forEach(key -> properties.put(key, bundle.getString(key)));              
    }
    
    @GET
    public JsonArray configuration() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        properties.keySet().forEach(k -> Json.createObjectBuilder().add(k, properties.get(k)));
        return builder.build();
    }
    
    @javax.enterprise.inject.Produces
    public String injectProperty(InjectionPoint ip) {
        String key = ip.getMember().getName();        
        return properties.containsKey(key) ? properties.get(key) : null;        
    }
    
    
}
