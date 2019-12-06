/**
 * <p>This proxy class serves as a surrogate of a real {@link com.globant.dbaccess.accessors.DBAccessor} type class. </p>
 * <p>Its function is to prevent the DB from filling with incorrect data,
 * and also handling the authentication of users.</p>
 * <p>For more info on the methods, see {@link com.globant.dbaccess.accessors.DBAccessor} Interface</p>
 * @author bohledevs
 * @version 1.1
 * @see <a href="https://github.com/bohledevs">My GitHub</a>
 *
 */
package com.globant.dbaccess.accessors;

import java.sql.SQLDataException;
import java.sql.Statement;

public class ProxyAccessor implements DBAccessor {

  private DBAccessor realAccessor; // Real Accessor

  public ProxyAccessor(String protocol) {
    if ("MYSQL".equalsIgnoreCase(protocol)) {
      this.realAccessor = new MySQLAccessor();
    } else if ("POSTGRESQL".equalsIgnoreCase(protocol)) {
      this.realAccessor= new PostgreSQLAccessor();
    } else if ("ORACLESQL".equalsIgnoreCase(protocol)) {
      this.realAccessor= new OracleSQLAccessor();
    }
  }

  /**
   * @return true
   * @since 1.1
   */
  @Override
  public boolean connect(String url, String userName, String password) {
    try {
      realAccessor.connect(url,userName,password);
    } catch(Exception e) {
      e.printStackTrace();
    }
    return true;
  }

  /**
   * @return true
   * @since 1.1
   */
  @Override
  public boolean executeDataSet(Statement[] querys){
    if (checkValidity(querys)){
      realAccessor.executeDataSet(querys);
    } else {
      try {
        throw new SQLDataException();
      } catch (SQLDataException e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  /**
   * @return true
   * @since 1.1
   */
  @Override
  public boolean executeDataRead(Statement[] querys) {
    if (checkValidity(querys)){
      realAccessor.executeDataRead(querys);
    } else {
      try {
        throw new SQLDataException();
      } catch (SQLDataException e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  private boolean checkValidity(Statement[] querys) {
    return true;
  }
}
