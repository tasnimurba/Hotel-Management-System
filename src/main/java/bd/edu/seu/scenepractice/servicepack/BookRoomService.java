package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.BookRoomModel;

import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRoomService {
    public boolean bookRoomNow(BookRoomModel bookRoomModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO book VALUE('" + bookRoomModel.getTelephoneNum() + "','" + bookRoomModel.getQuality() + "','" + bookRoomModel.getDate() + "','" + bookRoomModel.getQuantity() + "','" + bookRoomModel.getPrice() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }


    public List<BookRoomModel> getBookRoomDetails() {
        List<BookRoomModel> roomDetailList = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM book;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String number = resultSet.getString("tele");
                String quality = resultSet.getString("quality");
                String date = resultSet.getString("date");
                int numberOfRoom = resultSet.getInt("numberRoom");
                double price = resultSet.getDouble("price");

                BookRoomModel bookRoomModel = new BookRoomModel(number, quality, date, numberOfRoom, price);
                roomDetailList.add(bookRoomModel);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomDetailList;


    }

    //update
    public boolean updateInfo(BookRoomModel bookRoomModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "UPDATE book SET quality='" + bookRoomModel.getQuality() + "', date= '" + bookRoomModel.getDate() + "', numberRoom = '" + bookRoomModel.getQuantity() + "', price = '" + bookRoomModel.getPrice() + "' WHERE tele = '" + bookRoomModel.getTelephoneNum() + "'";
            System.out.println(query);
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    //delete
    public boolean deleteInfo(BookRoomModel bookRoomModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "Delete From book Where tele=('" + bookRoomModel.getTelephoneNum() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }

    //multiply
//    public boolean multiply(BookRoomModel bookRoomModel) {
//        try {
//            Connection connection = SingletonConnection.getConnection();
//            Statement statement = connection.createStatement();
//
//            String query = "select price*numberRoom as total_price from book where tele='" + bookRoomModel.getTelephoneNum() + "'";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            if (resultSet.next()) {
//                double totalPrice = resultSet.getDouble("total_price");
//                System.out.println("Total price=" + totalPrice);
//                return true;
//            } else {
//                System.out.println("No record found for the given tele number");
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
       // }

    //}

}


