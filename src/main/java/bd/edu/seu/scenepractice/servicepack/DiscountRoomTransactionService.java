package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.DiscountRoomModel;
import bd.edu.seu.scenepractice.model.DiscountRoomTransactionModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountRoomTransactionService
{
    public boolean discountRoomTransaction(DiscountRoomTransactionModel discountRoomTransactionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO discountroomtransaction VALUE('" + discountRoomTransactionModel.getMobile() + "','" + discountRoomTransactionModel.getAmount()+ "','" + discountRoomTransactionModel.getService() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }
}
