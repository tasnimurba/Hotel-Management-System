package bd.edu.seu.scenepractice.servicepack;


import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.model.OwnerPageModel;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerPageService
{

    public OwnerPageModel ownerInfo(String number, String password) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM ownerinfo WHERE mobile='" + number + "' AND password='" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String numberOfOwner = resultSet.getString("mobile");

                String passOfOwner = resultSet.getString("password");

                return new OwnerPageModel(numberOfOwner,passOfOwner);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
