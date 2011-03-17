package tylerhayes.tools;

/**
 * This Interface, along with the <tt>TerminationInterceptor</tt> Class,
 * comprise a simple signal handling mechanism for catching a kill signal--more
 * specifically, when a user hits CTRL-C when running a program through a
 * command-line (won't work when clicking the "Termination" button in Eclipse).
 * This can be important when logging program activities with a <tt>Log</tt>
 * object.  Since the Log Class uses a <tt>BufferedWriter</tt> object to write
 * information, not all recent outputs make it to the file on disk when the
 * program is terminated prematurely and doesn't have the opportunity to close
 * the <tt>BufferedWriter</tt> object properly.  <tt>Deltacap</tt>, for example,
 * implements this interface and uses a <tt>TerminationInterceptor</tt> object
 * in order to close the <tt>Log</tt> object properly upon the killing of the
 * program.
 * 
 * @author Tyler Hayes - Portland State University &copy; 2010.
 */
public interface GracefulShutdown {
  /**
   * What is to be run in order to catch a kill signal.
   */
  void start();
  
  /**
   * What is to happen when the program is terminated.
   */
  void shutDown();
}
