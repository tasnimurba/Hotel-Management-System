package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.DiscountRoomModel;
import bd.edu.seu.scenepractice.model.OtherOptionModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountRoomService
{
    public boolean discountRoom(DiscountRoomModel discountRoomModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO subbenefitforroom VALUE('" + discountRoomModel.getType() + "','" + discountRoomModel.getQuantity()+ "','" + discountRoomModel.getDate() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }
}
