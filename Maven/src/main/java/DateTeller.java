import java.text.SimpleDateFormat;
import java.util.Date;

/* Simple Class which can be used to tell today's Date  *
 * in DD/MM/YYYY format.                                *
 */

public class DateTeller {


  public static String getDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String output=formatter.format(date);
    System.out.println("Date: "+output.substring(0,10));
    return output.substring(0,10);
  } //Returns 03/12/2019  as of today
}
