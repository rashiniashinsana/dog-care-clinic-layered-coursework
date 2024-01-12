package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.TreatmentBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.TreatmentIMPL;
import lk.ijse.dogCareClinic.dao.custom.TreatMentDAO;
import lk.ijse.dogCareClinic.dto.TreatmentDto;

import java.sql.SQLException;
import java.util.List;

public class TreatmentBO implements TreatmentBODAO {

    TreatMentDAO treatMentDAO=new TreatmentIMPL();

    @Override
    public List<TreatmentDto> getAllTratment() throws SQLException, ClassNotFoundException {
        return treatMentDAO.getAll();
    }

    @Override
    public boolean saveTreatment(TreatmentDto dto) throws SQLException, ClassNotFoundException {
        return treatMentDAO.save(dto);
    }

    @Override
    public boolean deleteTreatment(String id) throws SQLException, ClassNotFoundException {
        return treatMentDAO.delete(id);
    }

    @Override
    public boolean updateTreatment(TreatmentDto dto) throws SQLException, ClassNotFoundException {
        return treatMentDAO.update(dto);
    }
}
