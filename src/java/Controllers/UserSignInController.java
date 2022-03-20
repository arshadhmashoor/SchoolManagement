
package Controllers;

import Hibernate.Connector;
import Models.UserModel;
import java.sql.ResultSet;


public class UserSignInController {

    Connector a = new Connector();
    String fullname = "";
    int class_level = 0;

    UserModel usMo = UserModel.getInstance();

    private static final UserSignInController insUserSignInController = new UserSignInController();

    private UserSignInController() {
    }

    public static UserSignInController getInstance() {
        return insUserSignInController;
    }

    public boolean userSignIn() {
        try {
            String sql = "SELECT * FROM user_registration WHERE username = '" + usMo.getUsername() + "' && password = '" + usMo.getPassword() + "' ";
            ResultSet rset = a.srh(sql);
            if (rset.next()) {

                ResultSet rs = a.srh("SELECT name,class_level FROM student WHERE student_id = '" + rset.getInt(2) + "'");
                if (rs.next()) {
                    fullname = rs.getString(1);
                    class_level = rs.getInt(2);
                }
                UserModel.setLoggedUserId(rset.getInt(1));
                UserModel.setStudent_id(rset.getInt(2));
                UserModel.setLoggedUserFullName(fullname);
                UserModel.setClassLevel(class_level);
                UserModel.setLoggedUserType(rset.getString(5));
                return true;
            } else {
                UserModel.setLoggedUserId(0);
                UserModel.setLoggedUserFullName("");
                UserModel.setLoggedUserType("");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
