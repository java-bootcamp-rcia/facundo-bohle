package com.globant.abstractfactory.factory;

import com.globant.abstractfactory.connection.PostgreSQL;

public class FactoryProducer {

  public static SQLFactory getFactory(String factoryType) {
    if ("MYSQL".equalsIgnoreCase(factoryType)) {
      return new MySQLFactory();
    } else if ("PostgreSQL".equalsIgnoreCase(factoryType)) {
      return new PostgreSQLFactory();
    }
    return null;
  }
}
