package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.RecordBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.RecordIMPL;
import lk.ijse.dogCareClinic.dao.custom.RecordDAO;
import lk.ijse.dogCareClinic.dto.RecordDto;

import java.sql.SQLException;
import java.util.List;

public class RecoardBO implements RecordBODAO {
    RecordDAO recordDAO=new RecordIMPL();
    @Override
    public List<RecordDto> getAllRecord() throws SQLException, ClassNotFoundException {
        return recordDAO.getAll();
    }

    @Override
    public boolean saveRecord(RecordDto dto) throws SQLException, ClassNotFoundException {
        return recordDAO.save(dto);
    }

    @Override
    public boolean deleteRecord(String id) throws SQLException, ClassNotFoundException {
        return recordDAO.delete(id);
    }

    @Override
    public RecordDto searchRecord(String id) throws SQLException, ClassNotFoundException {
        return recordDAO.search(id);
    }

    @Override
    public boolean updateRecord(RecordDto dto) throws SQLException, ClassNotFoundException {
        return recordDAO.update(dto);
    }
}
