package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.AppointmentBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.AppointmentIMPL;
import lk.ijse.dogCareClinic.dao.custom.AppointmentDAO;
import lk.ijse.dogCareClinic.dto.AppointmentDto;

import java.sql.SQLException;
import java.util.List;

public class AppointmentBO implements AppointmentBODAO {

    AppointmentDAO appointmentDAO=new AppointmentIMPL();
    @Override
    public List<AppointmentDto> getAllAppoinment() throws SQLException, ClassNotFoundException {
        return appointmentDAO.getAll();
    }

    @Override
    public boolean saveAppointment(AppointmentDto dto) throws SQLException, ClassNotFoundException {
        return appointmentDAO.save(dto);
    }

    @Override
    public boolean deleteAppointmnet(String id) throws SQLException, ClassNotFoundException {
        return appointmentDAO.delete(id);
    }

    @Override
    public AppointmentDto searchAppointment(String id) throws SQLException, ClassNotFoundException {
        return appointmentDAO.search(id);
    }

    @Override
    public boolean updateAppointment(AppointmentDto dto) throws SQLException, ClassNotFoundException {
        return appointmentDAO.update(dto);
    }
}
