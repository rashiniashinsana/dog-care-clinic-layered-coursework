package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.TreatmentDto;

import java.sql.SQLException;
import java.util.List;

public interface TreatmentBODAO {

    List<TreatmentDto> getAllTratment() throws SQLException, ClassNotFoundException;

    boolean saveTreatment(TreatmentDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteTreatment(String id) throws SQLException, ClassNotFoundException;

    boolean updateTreatment(TreatmentDto dto) throws SQLException, ClassNotFoundException;
}
