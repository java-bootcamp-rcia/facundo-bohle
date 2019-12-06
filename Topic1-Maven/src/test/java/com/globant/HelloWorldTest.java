
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class HelloWorldTest {
  private HelloWorld greeter= new HelloWorld();

  @Test
  public void canReturnHelloWorldMessage() {
    String message= greeter.greet();
    assertThat(message,is("Hello World!"));
  }

}
