package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.PaymentBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.PaymentIMPL;
import lk.ijse.dogCareClinic.dao.custom.PaymentDAO;
import lk.ijse.dogCareClinic.dto.PaymentDto;

import java.sql.SQLException;
import java.util.List;

public class PaymentBO implements PaymentBODAO {
    PaymentDAO paymentDAO=new PaymentIMPL();
    @Override
    public List<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException {
        return paymentDAO.getAll();
    }

    @Override
    public boolean savePayment(PaymentDto dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(dto);
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(id);
    }

    @Override
    public PaymentIMPL searchPayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.search(id);
    }

    @Override
    public boolean updatePayment(PaymentDto dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(dto);
    }
}
