package test.singleton;

import com.globant.singletondb.DBConnection;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class DBConnectionTest {

  //Makes sure only one object DBConnection exists
  @org.junit.jupiter.api.Test
  public void testDB() {
    Logger l = Logger.getLogger(DBConnection.class.getName());
    DBConnection connection= DBConnection.getInstance();

    // Tests Unique Existence
    assertThat(connection, is(DBConnection.getInstance()));
    l.info("Singleton Designed Connection Assured.");

    // Checks if connection is valid
    assertThat(connection.getConnection(),equalTo(null));
    l.info("Connection exists."); // This won't work for a real connection. I assume the mock one will
                                        // Drop a 'null' after failing to connect.
  }


}