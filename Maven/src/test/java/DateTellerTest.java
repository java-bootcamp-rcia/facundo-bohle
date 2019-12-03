import static org.junit.jupiter.api.Assertions.*;

class DateTellerTest {

  @org.junit.jupiter.api.Test
  void getDate() {
      assertEquals("03/12/2019",DateTeller.getDate());
      }
}