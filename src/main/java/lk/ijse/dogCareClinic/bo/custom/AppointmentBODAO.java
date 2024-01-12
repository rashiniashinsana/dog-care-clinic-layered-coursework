package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.AppointmentDto;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentBODAO {
    List<AppointmentDto> getAllAppoinment() throws SQLException, ClassNotFoundException;

    boolean saveAppointment(AppointmentDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteAppointmnet(String id) throws SQLException, ClassNotFoundException;

    AppointmentDto searchAppointment(String id) throws SQLException, ClassNotFoundException;

    boolean updateAppointment(AppointmentDto dto) throws SQLException, ClassNotFoundException;
}
