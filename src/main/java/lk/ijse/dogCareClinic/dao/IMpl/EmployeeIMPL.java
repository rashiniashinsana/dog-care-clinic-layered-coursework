package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.EmployeeDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.EmployeeDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeIMPL implements EmployeeDAO {

    public boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)",dto.getEmployeeId(),dto.getEmployeeName(),dto.getNIC(),dto.getSex(),dto.getContact(),dto.getJobRole());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEmployeeId());
        pstm.setString(2, dto.getEmployeeName());
        pstm.setString(3, dto.getNIC());
        pstm.setString(4, dto.getSex());
        pstm.setString(5, dto.getContact());
        pstm.setString(6, dto.getJobRole());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM employee WHERE Emp_ID = ?",id);

    }

    public List<EmployeeDto> getAll() throws SQLException, ClassNotFoundException {
        List<EmployeeDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM employee");

        while (r.next()) {
           /* String Emp_ID = resultSet.getString(1);
            String Emp_Name = resultSet.getString(2);
            String NIC = resultSet.getString(3);
            String Sex = resultSet.getString(4);
            String Contact = resultSet.getString(5);
            String JobRole = resultSet.getString(6);

            var dto = new EmployeeDto(Emp_ID, Emp_Name, NIC, Sex, Contact, JobRole);
            dtoList.add(dto);*/
            dtoList.add(new EmployeeDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)));
        }
        return dtoList;
    }

    public boolean updatess(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate("UPDATE employee SET  Emp_Name = ?, NIC = ?, Sex = ?, Contact = ?, JobRole =? WHERE Emp_ID = ?",dto.getEmployeeName(),dto.getNIC(),dto.getSex(),dto.getContact(),dto.getJobRole(),dto.getEmployeeId());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE employee SET  Emp_Name = ?, NIC = ?, Sex = ?, Contact = ?, JobRole =? WHERE Emp_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEmployeeName());
        pstm.setString(2, dto.getNIC());
        pstm.setString(3, dto.getSex());
        pstm.setString(4, dto.getContact());
        pstm.setString(5, dto.getJobRole());
        pstm.setString(6, dto.getEmployeeId());

        return pstm.executeUpdate() > 0;*/
    }

    public EmployeeDto search(String id) throws SQLException, ClassNotFoundException {

        ResultSet r = CrudUtil.executeQuery("SELECT * FROM employee WHERE Emp_ID = ?",id);
        EmployeeDto dto = null;
        r.next();
           /* String EmployeeID = resultSet.getString(1);
            String EmployeeName = resultSet.getString(2);
            String NIC = resultSet.getString(3);
            String Sex = resultSet.getString(4);
            String Contact = resultSet.getString(5);
            String JobRole = resultSet.getString(6);

            dto = new EmployeeDto(EmployeeID, EmployeeName, NIC, Sex, Contact, JobRole);*/
            return new EmployeeDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6));
        }


    public boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate( "UPDATE employee SET  Emp_Name = ?,  NIC  =?, Sex= ?, Contact = ?, JobRole = ? WHERE Emp_ID = ?",dto.getEmployeeId(),dto.getEmployeeName(),dto.getNIC(),dto.getSex(),dto.getContact(),dto.getJobRole());
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE employee SET  Emp_Name = ?,  NIC  =?, Sex= ?, Contact = ?, JobRole = ? WHERE Emp_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getEmployeeName());
        pstm.setString(2, dto.getEmployeeName());
        pstm.setString(3, dto.getNIC());
        pstm.setString(4, dto.getSex());
        pstm.setString(5, dto.getContact());
        pstm.setString(6, dto.getJobRole());
        return pstm.executeUpdate() > 0;*/

    }
}


