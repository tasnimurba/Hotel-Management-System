package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.TransactionModel;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionService
{
    public boolean InsertPayment(TransactionModel transactionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO transaction VALUE('" + transactionModel.getMobile() + "','" + transactionModel.getService()+ "'," + transactionModel.getAmount() + ")";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }
}
