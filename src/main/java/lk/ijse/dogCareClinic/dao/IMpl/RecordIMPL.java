package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.RecordDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.RecordDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordIMPL implements RecordDAO {


    public RecordDto searchRecord;

    public boolean save(RecordDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO record VALUES(?, ?, ?)",dto.getRecordId(),dto.getDescription(),dto.getDate());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM record WHERE Record_ID = ?",id);
    }

    public List<RecordDto> getAll() throws SQLException, ClassNotFoundException {
        List<RecordDto> dtoList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM record");


        while (resultSet.next()) {
            /*String record_id = resultSet.getString(1);
            String description = resultSet.getString(2);
            String date = resultSet.getString(3);

            var dto = new RecordDto(record_id, description, date);
            dtoList.add(dto);*/
            dtoList.add(new RecordDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
        }
        return dtoList;
    }

    public boolean update(RecordDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE record SET Description = ?, Date = ? WHERE Record_ID = ?",dto.getDescription(),dto.getDate(),dto.getRecordId());

    }

    public RecordDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM record WHERE Record_ID = ?",id);
         resultSet.next();

            return new RecordDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));



    }

}