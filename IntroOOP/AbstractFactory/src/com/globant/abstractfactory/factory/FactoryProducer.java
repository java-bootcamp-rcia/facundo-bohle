package com.globant.abstractfactory.factory;

public class FactoryProducer {

  public static SQLFactory getFactory(String factoryType) {
    if (factoryType.equalsIgnoreCase("MySQL")) {
      return new MySQLFactory();
    } else if (factoryType.equalsIgnoreCase("PostgreSQL")) {
      return new PostgreSQLFactory();
    }
    return null;
  }
}
