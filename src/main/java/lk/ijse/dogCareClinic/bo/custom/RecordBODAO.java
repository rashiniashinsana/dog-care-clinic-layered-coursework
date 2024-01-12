package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.RecordDto;

import java.sql.SQLException;
import java.util.List;

public interface RecordBODAO {
    List<RecordDto> getAllRecord() throws SQLException, ClassNotFoundException;

    boolean saveRecord(RecordDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteRecord(String id) throws SQLException, ClassNotFoundException;

    RecordDto searchRecord(String id) throws SQLException, ClassNotFoundException;

    boolean updateRecord(RecordDto dto) throws SQLException, ClassNotFoundException;
}
