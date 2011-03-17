package tylerhayes.tools;


/**
 * This Class, along with the <tt>GracefulShutdown</tt> Interface, comprise a
 * simple signal handling mechanism for catching a kill signal--more
 * specifically, when a user hits CTRL-C when running a program through a
 * command-line (won't work when clicking the "Termination" button in Eclipse).
 * <p>
 * In order to have a kill signal handler, the call to <tt>
 * Runtime.getRuntime().addShutdownHook(Thread)</tt> must be given a <tt>Thread
 * </tt> object.  This object extends <tt>Thread</tt> and is used as such.  It
 * is only run upon the termination of the program, thus the {@link #run()}
 * method's simple call to the <tt>shutDown()</tt> method of its private
 * <tt>GracefulShutdown</tt> Interface instance.
 * </p>
 * 
 * @author Tyler Hayes - Portland State University &copy; 2010.
 */
public class TerminationInterceptor extends Thread {
  private GracefulShutdown gracefulShutdown;
  
  /**
   * Creates a new <tt>TerminationInterceptor</tt> object with the given
   * <tt>GracefulShutdown</tt> Interface instance.
   * 
   * @param gracefulShutdown Usually an instance of the class that contains the
   * <tt>main</tt> method of the program (which has to implement the
   * <tt>GracefulShutdown</tt> Interface, of course).
   */
  public TerminationInterceptor(GracefulShutdown gracefulShutdown) {
    this.gracefulShutdown = gracefulShutdown;
  }
  
  /**
   * Calls the object's <tt>GracefulShutdown</tt> instance's <tt>shutDown()</tt>
   * method.  This is run when the program terminates--either in code, or by
   * the user hitting CTRL-C when running the program from the command-line.
   */
  public void run() {
    gracefulShutdown.shutDown();
  }
}