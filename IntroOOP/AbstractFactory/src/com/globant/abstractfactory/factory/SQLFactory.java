package com.globant.abstractfactory.factory;
import com.globant.abstractfactory.connection.SQLConnection;
import java.sql.Connection;

public abstract class SQLFactory {
  public abstract SQLConnection getConnection() ;
}
