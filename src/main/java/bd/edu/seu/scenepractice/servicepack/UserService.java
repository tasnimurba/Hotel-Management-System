package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.*;

public class UserService {
    public boolean memberCreate(UserModel userModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO hotel VALUE('" + userModel.getName() + "','" + userModel.getNumber() + "','" + userModel.getPassword() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }

    public UserModel login(String number, String password) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM hotel WHERE number='" + number + "' AND password='" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String num = resultSet.getString("number");

                String name = resultSet.getString("name");
                System.out.println(number +"," +name);
                return new UserModel(num, name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
