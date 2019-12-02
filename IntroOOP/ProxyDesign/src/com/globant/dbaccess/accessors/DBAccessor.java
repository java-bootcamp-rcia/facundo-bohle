package com.globant.dbaccess.accessors;


import java.sql.SQLException;
import java.sql.Statement;

public interface DBAccessor {

  // Connects to the DB
  public void connect(String url, String username, String password) throws SQLException;

  // Accessing
  public void executeDataRead(Statement[] querys);
  public void executeDataSet(Statement[] querys);
}
