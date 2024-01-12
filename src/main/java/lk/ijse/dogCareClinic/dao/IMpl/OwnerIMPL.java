package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.OwnerDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.OwnerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerIMPL implements OwnerDAO {

    public boolean save(OwnerDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO owner VALUES(?, ?, ?)",dto.getOwnerId(),dto.getOwnerName(),dto.getContacts());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO owner VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getOwnerId());
        pstm.setString(2, dto.getOwnerName());
        pstm.setString(3, dto.getContacts());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate("DELETE FROM owner WHERE O_ID = ?",id);
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM owner WHERE O_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;*/
    }

    public List<OwnerDto> getAll() throws SQLException, ClassNotFoundException {
        List<OwnerDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery( "SELECT * FROM owner");

        while (r.next()) {
         /*   String OwnerID = resultSet.getString(1);
            String OwnerName = resultSet.getString(2);
            String Contacts = resultSet.getString(3);

            var dto = new OwnerDto(OwnerID, OwnerName, Contacts);
            dtoList.add(dto);*/
            dtoList.add(new OwnerDto(r.getString(1),r.getString(2),r.getString(3)));
        }
        return dtoList;
    }

    public boolean update(OwnerDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE owner SET Owner_Name = ?, Contacts = ? WHERE O_ID = ?",dto.getOwnerName(),dto.getContacts(),dto.getOwnerId());
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE owner SET Owner_Name = ?, Contacts = ? WHERE O_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getOwnerName());
        pstm.setString(2, dto.getContacts());
        pstm.setString(3, dto.getOwnerId());

        return pstm.executeUpdate() > 0;*/
    }


    public OwnerDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM owner WHERE O_ID = ?",id);
        OwnerDto dto = null;

        resultSet.next();
          /*  String O_ID = resultSet.getString(1);
            String Owner_Name = resultSet.getString(2);
            String Contacts = resultSet.getString(3);


            dto = new OwnerDto(O_ID, Owner_Name, Contacts);*/
            return new OwnerDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));

    }
}