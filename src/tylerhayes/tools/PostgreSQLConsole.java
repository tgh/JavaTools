package tylerhayes.tools;

import java.sql.*;

public class PostgreSQLConsole {

  private Connection dbConn;
  
	
  public PostgreSQLConsole(Connection dbConn) {
		this.dbConn = dbConn;
  }
  
  
  public ResultSet select(String selectStatement) throws SQLException {
    Statement sqlStatement = dbConn.createStatement();
    return sqlStatement.executeQuery(selectStatement);
  }
  
  
  public ResultSet selectScrollable(String selectStatement) throws SQLException {
	Statement sqlStatement = dbConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	return sqlStatement.executeQuery(selectStatement);
  }
  
  
  public int update(String updateStatement) throws SQLException {
    Statement sqlStatement = dbConn.createStatement();
    return sqlStatement.executeUpdate(updateStatement);
  }
  
  
  public int insert(String insertStatement) throws SQLException {
    return update(insertStatement);
  }
  
  
  public int delete(String deleteStatement) throws SQLException {
    return update(deleteStatement);
  }
}