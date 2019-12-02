package com.globant.abstractfactory.factory;

import com.globant.abstractfactory.connection.PostgreSQL;
import com.globant.abstractfactory.connection.SQLConnection;


public class PostgreSQLFactory extends SQLFactory {

  @Override
  public SQLConnection getConnection() {
    return new PostgreSQL();
  }
}
