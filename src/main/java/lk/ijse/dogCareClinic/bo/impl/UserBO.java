package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.UserBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.UserIMPL;
import lk.ijse.dogCareClinic.dao.custom.UserDAO;
import lk.ijse.dogCareClinic.dto.UserDto;

import java.sql.SQLException;

public class UserBO implements UserBODAO {

    UserDAO userDAO=new UserIMPL();
    @Override
    public UserDto searchUser(String username) throws SQLException, ClassNotFoundException {
        return userDAO.search(username);
    }

    @Override
    public boolean saveUser(UserDto newUser) throws SQLException, ClassNotFoundException {
       return userDAO.save(newUser);

    }
}
