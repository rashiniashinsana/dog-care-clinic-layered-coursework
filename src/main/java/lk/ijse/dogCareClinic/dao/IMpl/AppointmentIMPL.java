package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.AppointmentDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.AppointmentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentIMPL implements AppointmentDAO {

    private AppointmentDto dto;

    public boolean save(AppointmentDto dto) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("INSERT INTO appointment VALUES(?, ?, ?, ?, ?, ?)",dto.getAppointmentID(),dto.getOwnerID(),dto.getEmployeeID(),dto.getDate(),dto.getTime(),dto.getPurpose());
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO appointment VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getAppointmentID());
        pstm.setString(2, dto.getOwnerID());
        pstm.setString(3, dto.getEmployeeID());
        pstm.setString(4, dto.getDate());
        pstm.setString(5, dto.getTime());
        pstm.setString(6, dto.getPurpose());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM record WHERE Appointment_ID = ?",id);
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM record WHERE Appointment_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;*/


    }


    public List<AppointmentDto> getAll() throws SQLException, ClassNotFoundException {
        List<AppointmentDto> dtoList = new ArrayList<>();
        ResultSet r=CrudUtil.executeQuery("SELECT * FROM appointment");

        while (r.next()) {
          /*  String Appointment_ID = resultSet.getString(1);
            String Owner_ID = resultSet.getString(2);
            String Employee_ID = resultSet.getString(3);
            String date = resultSet.getString(4);
            String time = resultSet.getString(5);
            String purpose = resultSet.getString(6);


            var dto = new AppointmentDto(Appointment_ID, Owner_ID, Employee_ID, date, time, purpose);
            dtoList.add(dto);*/
            dtoList.add(new AppointmentDto(r.getString("Appointment_ID "),r.getString("Owner_ID"),r.getString("Employee_ID"),r.getString("date"),r.getString("time"),r.getString("purpose")));
        }
        return dtoList;
    }

    public boolean update(AppointmentDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE appointment SET  O_ID = ?, Emp_ID =?, DATE = ?, TIME = ?, purpose = ? WHERE Appointment_ID = ?",dto.getOwnerID(),dto.getEmployeeID(),dto.getDate(),dto.getTime(),dto.getPurpose(),dto.getAppointmentID());
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE appointment SET  O_ID = ?, Emp_ID =?, DATE = ?, TIME = ?, purpose = ? WHERE Appointment_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getOwnerID());
        pstm.setString(2, dto.getEmployeeID());
        pstm.setString(3, dto.getDate());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getPurpose());
        pstm.setString(6, dto.getAppointmentID());
        return pstm.executeUpdate() > 0;*/
    }


    public AppointmentDto search(String id) throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();

        //String sql = "SELECT * FROM appointment WHERE Appointment_ID = ?";
        //PreparedStatement pstm = connection.prepareStatement(sql);
       // pstm.setString(1, id);
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM appointment WHERE Appointment_ID = ?",id);
        r.next();
          /*  String Appointment_ID = resultSet.getString(1);
            String O_ID = resultSet.getString(2);
            String Emp_ID = resultSet.getString(3);
            String Date = resultSet.getString(4);
            String Time = resultSet.getString(5);
            String purpose = resultSet.getString(6);


            dto = new AppointmentDto(Appointment_ID, O_ID, Emp_ID, Date, Time, purpose);*/
            return new AppointmentDto(r.getString("Appointment_ID"),r.getString("O_ID "),r.getString("Emp_ID"),r.getString("Date"),r.getString("Time"),r.getString("purpose"));

        }


    }

