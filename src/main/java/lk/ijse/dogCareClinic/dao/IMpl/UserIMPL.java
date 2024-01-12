package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.UserDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserIMPL implements UserDAO {

    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO user VALUES(?,?,?,?)",dto.getUsername(),dto.getPassword(),dto.getConfirm_Password(),dto.getEmail());
        /*Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getUsername());
        pstm.setString(2, dto.getPassword());
        pstm.setString(3, dto.getConfirm_Password());
        pstm.setString(4, dto.getEmail());

        int i = pstm.executeUpdate();
        if (i > 0) return true;
        else return false;*/

    }

    @Override
    public boolean delete(String string) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(UserDto userDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<UserDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public UserDto search(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM user WHERE username=?",username);
        resultSet.next();
           return new UserDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));

    }

}
