package lk.ijse.dogCareClinic.dao.custom;

import lk.ijse.dogCareClinic.dto.AppointmentDto;
import lk.ijse.dogCareClinic.dto.DogDto;
import lk.ijse.dogCareClinic.dao.CrudDAO;

import java.sql.SQLException;

public interface DogDAO extends CrudDAO<DogDto,String> {
 AppointmentDto searchAppointment(String id) throws SQLException, ClassNotFoundException;
}
