package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.UserDto;

import java.sql.SQLException;

public interface UserBODAO {


    UserDto searchUser(String username) throws SQLException, ClassNotFoundException;

     boolean saveUser(UserDto newUser) throws SQLException, ClassNotFoundException;
}
