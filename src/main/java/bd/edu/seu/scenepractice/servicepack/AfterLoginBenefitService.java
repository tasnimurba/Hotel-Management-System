package bd.edu.seu.scenepractice.servicepack;

import bd.edu.seu.scenepractice.model.AfterLoginBenefitModel;
import bd.edu.seu.scenepractice.model.UserModel;
import bd.edu.seu.scenepractice.singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AfterLoginBenefitService
{
    public boolean insertToBookBenefit(AfterLoginBenefitModel afterLoginBenefitModel) {
        try {
            Connection connection = SingletonConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO benefit VALUE('" + afterLoginBenefitModel.getChoose() + "','" + afterLoginBenefitModel.getDate() + "','" + afterLoginBenefitModel.getNumberOfPerson() + "')";
            statement.execute(query);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return false;

    }
}
