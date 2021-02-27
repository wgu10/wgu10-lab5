/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.wgu10.lab4;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author ganGuwen
 */
@ApplicationScoped
@DataSourceDefinition(
        name = "java:app/jdbc/itmd4515DS",
        className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
        serverName = "localhost",
        portNumber = 3306,
        databaseName = "Chinook",
        user = "itmd4515",
        password = "itmd4515",
        properties = {
            "characterEncoding=utf8",
            "useSSL=false",
            "serverTimezone=UTC"            
        }
)
public class Lab4DbConfig {
    
}
