package com.globant.abstractfactory.connection;
import java.util.logging.Logger;

public class PostgreSQL implements SQLConnection {
  // Session Data
  private String userName;
  private String password;
  private String url;
  private String protocol= "postgre";

  // Logging
  private Logger log= Logger.getLogger(PostgreSQL.class.getName());

  @Override
  // This method should actually return a java.sql.Connection type Object
  // But since it's a Mock, it just returns void

  public void connect(){
    log.info("Connecting to POSTGRESQL Database...");

    log.info("Success: Connection to PostgreSQL Established.");
  }
}
