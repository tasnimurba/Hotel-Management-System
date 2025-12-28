package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.OtherTransactionModel;
import bd.edu.seu.scenepractice.model.TransactionModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OtherTransactionService
{
    public boolean InsertPaymentOther(OtherTransactionModel otherTransactionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO transaction VALUE('" + otherTransactionModel.getMobile() + "','" + otherTransactionModel.getService()+ "'," + otherTransactionModel.getAmount() + ")";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }
}
