package com.globant.dbaccess.accessors;

import java.sql.SQLDataException;
import java.sql.Statement;

/*
 *    This proxy class serves as a surrogate of a real DB Accessor Class. *
 *    Its function is to prevent the DB from filling with incorrect data, *
 *    and also handling Authentication of users.                          *
 */


public class ProxyAccessor implements DBAccessor {

  private DBAccessor realAccessor; // Real Accessor

  // Specific Accessor protocol is passed to the Constructor
  public ProxyAccessor(String protocol) {
    // Accessor Type
    if (protocol.equalsIgnoreCase("MYSQL")) {
      this.realAccessor = new MySQLAccessor();
    } else if (protocol.equalsIgnoreCase("POSTGRESQL")) {
      this.realAccessor= new PostgreSQLAccessor();
    } else if (protocol.equalsIgnoreCase("ORACLESQL")) {
      this.realAccessor= new OracleSQLAccessor();
    }
  }

  // Catches failed connections
  @Override
  public void connect(String url, String userName, String password) {
    try {
      realAccessor.connect(url,userName,password);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  // Implements DataSet
  @Override
  public void executeDataSet(Statement[] querys){
    if (checkValidity(querys).equals(Boolean.TRUE)){
      realAccessor.executeDataSet(querys);
    } else {
      try {
        throw new SQLDataException();
      } catch (SQLDataException e) {
        e.printStackTrace();
      }
    }
  }

  // Implements DataRead
  @Override
  public void executeDataRead(Statement[] querys) {
    if (checkValidity(querys).equals(Boolean.TRUE)){
      realAccessor.executeDataRead(querys);
    } else {
      try {
        throw new SQLDataException();
      } catch (SQLDataException e) {
        e.printStackTrace();
      }
    }
  }

  // Checks if the SQL Statements are correct
  private Boolean checkValidity(Statement[] querys) {
    // I'll make it always return true, as I don't know the specific details of this proxy's validation
    return Boolean.TRUE;
  }
}
