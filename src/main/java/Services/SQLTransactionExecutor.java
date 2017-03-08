package Services;

import DAO.JDBCConnect;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by root on 08/03/17.
 */
public class SQLTransactionExecutor implements TransactionExecutor {

    public Object executeTransaction(Transaction transaction) {

        Connection connection = new JDBCConnect().getConnection();
        Object result = null;

        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            result = transaction.execute();

            connection.commit();
        } catch (SQLException ex) {
            rollbackTransaction(connection);

        }

        return result;
    }

    private void rollbackTransaction(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println("Cant rollback transaction");
            ex.printStackTrace();
        }
    }
}
