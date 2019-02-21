/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqsua.lab203geocoding;

import java.io.IOException;

/**
 *
 * @author ico
 */
public interface ITqsHttpClient {
    
    public String get(String url) throws IOException;
}
