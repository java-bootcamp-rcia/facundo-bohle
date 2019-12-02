package com.globant.abstractfactory.factory;
import com.globant.abstractfactory.connection.MySQL;
import com.globant.abstractfactory.connection.SQLConnection;

public class MySQLFactory extends SQLFactory {

  @Override
  public SQLConnection getConnection() {
    return new MySQL();
  }
}
