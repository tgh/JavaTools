package tylerhayes.tools;

import java.sql.*;

/**
 * The <b>DatabaseConnector</b> class simply makes a connection to a database--
 * nothing more, nothing less.  Currently, only connection to a Postgresql
 * database is implemented.
 * 
 * @author Tyler Hayes - Portland State University &copy; 2010.
 */
public class DatabaseConnector {

  /**
   * Connects to a specific Postgresql database with the gievn parameters:
   * database url, user name, and password.
   * <p>
   * In order to connect to a Postgresql database with Java, the JDBC driver is
   * utilized.  At the time of this writing (Aug, 2010), the
   * <tt>postgresql-8.4-701.jdbc4</tt> jar file for the driver can be downloaded
   * here: <a href="http://jdbc.postgresql.org/download.html">
   * http://jdbc.postgresql.org/download.html</a>.
   * </p>
   * <p>
   * If a connection is unable to be made (an Exception was thrown), the stack
   * trace is output to stdout, and the program will terminate.
   * </p>
   * 
   * @param dbUrl The url of the Postgresql database.
   * <p>
   * <b>Example:</b> <tt>"jdbc:postgresql://localhost/dbname"</tt>
   * </p>
   * @param user The user name for the database.
   * @param password The password for the database.
   * @return A <tt>Connection</tt> object that can be used to communicate to the
   * Postgresql database.
   */
  public static Connection connectToPostgres(String dbUrl, String user,
                                             String password) {
    try {
      //load the JDBC driver in order to connect to the postgresql database
      Class.forName("org.postgresql.Driver");
      //connect to the postgresql database
      return DriverManager.getConnection(dbUrl, user, password);
    }
    catch (Exception e) {
      System.out.println("**ERROR: Could not connect to Postgresql database.");
      e.printStackTrace();
      System.exit(1);
    }
    
    //unreachable code
    return null;
  }
}