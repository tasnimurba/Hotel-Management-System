package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.BookRoomModel;
import bd.edu.seu.scenepractice.model.OtherOptionModel;

import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OtherService
{
    public boolean otherRoomBook(OtherOptionModel otherOptionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO other VALUE('" + otherOptionModel.getTelephone() + "','" + otherOptionModel.getName()+ "','" + otherOptionModel.getDateOther() + "','" + otherOptionModel.getOtherQuality()+ "','"+otherOptionModel.getIdentity()+ "','"+otherOptionModel.getPrice()+ "','"+otherOptionModel.getNumberRoomOther()+"')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }




    public List<OtherOptionModel> getOtherBookRoomDetails() {
        List<OtherOptionModel> roomOtherDetailList = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM other;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String number = resultSet.getString("telephone");
                String identity = resultSet.getString("indentity");
                String date = resultSet.getString("date");
                String quality = resultSet.getString("type");
                String name = resultSet.getString("name");
                int numberOfRoom = resultSet.getInt("roomQuantity");
                double price = resultSet.getDouble("price");

                OtherOptionModel otherOptionModel = new OtherOptionModel(identity,date,numberOfRoom,number,name,quality,price);
                roomOtherDetailList.add(otherOptionModel);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomOtherDetailList;


    }


    //update
    public boolean updateOtherInfo(OtherOptionModel otherOptionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "UPDATE other SET type='" + otherOptionModel.getOtherQuality() + "', identity= '" + otherOptionModel.getName() + "', date = '" + otherOptionModel.getDateOther() + "', name = '" + otherOptionModel.getIdentity()  + "', price = '" + otherOptionModel.getPrice() + "', roomQuantity = '" + otherOptionModel.getNumberRoomOther()+ "' WHERE telephone = '" + otherOptionModel.getTelephone() + "'";
            System.out.println(query);
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //delete
    public boolean deleteOtherInfo(OtherOptionModel otherOptionModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "Delete From other Where telephone=('" + otherOptionModel.getTelephone() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }


}
