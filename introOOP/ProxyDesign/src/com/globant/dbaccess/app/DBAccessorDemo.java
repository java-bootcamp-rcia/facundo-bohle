package com.globant.dbaccess.app;

import com.globant.dbaccess.accessors.DBAccessor;
import com.globant.dbaccess.accessors.ProxyAccessor;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBAccessorDemo {

  public static void main(String[] args) throws SQLException {
    Logger log= Logger.getLogger(DBAccessorDemo.class.getName());

    // Creates a proxy of a MySQL DB Accesor
    String protocol="MYSQL";
    log.info("Creating a.. "+protocol+" DB Accesor");
    DBAccessor accessor= new ProxyAccessor(protocol);

    // Checks connection (Will fail as It's a Mock DB)
    accessor.connect("jdbc:mysql://localhost:5432/jdbc", "root","admin");

    // Executes DataSet
    accessor.executeDataSet(null);

    // Executes DataRead
    accessor.executeDataRead(null);
  }
}
