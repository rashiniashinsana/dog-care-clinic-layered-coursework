package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.AppointmentDto;
import lk.ijse.dogCareClinic.dto.DogDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.DogDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogIMPL implements DogDAO {

    public boolean save(DogDto dto) throws SQLException, ClassNotFoundException {
      return   CrudUtil.executeUpdate("INSERT INTO dog VALUES(?, ?, ?, ?, ?, ?)",dto.getD_ID(),dto.getD_Name(),dto.getGender(),dto.getBreed(),dto.getAge(),dto.getO_ID());

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate("DELETE FROM dog WHERE D_ID = ?",id);

    }

    public List<DogDto> getAll() throws SQLException, ClassNotFoundException {
        List<DogDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM dog");
        while (r.next()) {
          /* String D_ID = r.getString(1);
            String D_Name = r.getString(2);
            String Gender = r.getString(3);
            String Breed = r.getString(4);
            String Age = r.getString(5);
            String O_ID = r.getString(6);

            var dto = new DogDto(D_ID, D_Name, Gender, Breed, Age, O_ID);
            dtoList.add(dto);*/
            dtoList.add(new DogDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)));
        }
        return dtoList;
    }


    public AppointmentDto searchAppointment(String id) throws SQLException, ClassNotFoundException {
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM appointment WHERE Appointment_ID = ?",id);
       // AppointmentDto dto = null;
        r.next();
            /*String AppointmentID = resultSet.getString(1);
            String OwnerID = resultSet.getString(2);
            String EmployeeID = resultSet.getString(3);
            String Date = resultSet.getString(4);
            String Time = resultSet.getString(5);
            String Purpose = resultSet.getString(6);

            dto = new AppointmentDto(AppointmentID, OwnerID, EmployeeID, Date, Time, Purpose);*/
            return  new AppointmentDto(r.getString("AppointmentID"),r.getString("OwnerID"),r.getString("EmployeeID"),r.getString("Date"),r.getString("Time"),r.getString("Purpose"));

    }

    public boolean update(DogDto dto) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate("UPDATE dog SET D_Name = ?, Gender = ?, Breed = ?, Age = ?, O_ID = ? WHERE D_ID = ?",dto.getD_Name(),dto.getGender(),dto.getBreed(),dto.getAge(),dto.getO_ID(),dto.getD_ID());
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE dog SET D_Name = ?, Gender = ?, Breed = ?, Age = ?, O_ID = ? WHERE D_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getD_Name());
        pstm.setString(2, dto.getGender());
        pstm.setString(3, dto.getBreed());
        pstm.setString(4, dto.getAge());
        pstm.setString(5, dto.getO_ID());
        pstm.setString(6, dto.getD_ID());

        return pstm.executeUpdate() > 0;*/
    }

    public DogDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet r =CrudUtil.executeQuery("SELECT * FROM dog WHERE D_ID = ?",id);

       // DogDto dto = null;

       r.next();
           /* String D_ID = resultSet.getString(1);
            String D_Name = resultSet.getString(2);
            String Gender = resultSet.getString(3);
            String Breed = resultSet.getString(4);
            String Age = resultSet.getString(5);
            String O_ID = resultSet.getString(6);*/

           // dto = new DogDto(D_ID, D_Name, Gender, Breed, Age, O_ID);
            return new DogDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6));


    }
}


