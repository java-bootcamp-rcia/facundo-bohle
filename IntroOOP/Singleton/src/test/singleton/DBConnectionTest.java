package test.singleton;

import com.globant.singletondb.DBConnection;
import java.sql.SQLException;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class DBConnectionTest {


  @org.junit.jupiter.api.Test
  public void whenConnectionIsCreated_thenReturnTrue() throws SQLException {
    Logger l = Logger.getLogger(DBConnection.class.getName());
    DBConnection connection= DBConnection.getInstance();


    assertThat(connection, is(DBConnection.getInstance()));
    l.info("Singleton Designed Connection Assured.");


    assertThat(connection.getConnection(),equalTo(true));
    l.info("Connection exists.");


}}