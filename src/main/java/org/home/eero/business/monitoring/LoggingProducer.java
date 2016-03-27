/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.home.eero.business.monitoring;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author eerosihvonen
 */
public class LoggingProducer {
    
    @Produces
    public Logger injectLogger(InjectionPoint ip) {
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        return Logger.getLogger(declaringClass.getName());
    }
    
}
