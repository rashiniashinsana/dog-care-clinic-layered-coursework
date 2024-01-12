package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dao.IMpl.PaymentIMPL;
import lk.ijse.dogCareClinic.dto.PaymentDto;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBODAO {
    List<PaymentDto> getAllPayments() throws SQLException, ClassNotFoundException;

    boolean savePayment(PaymentDto dto) throws SQLException, ClassNotFoundException;

    boolean deletePayment(String id) throws SQLException, ClassNotFoundException;

    PaymentIMPL searchPayment(String id) throws SQLException, ClassNotFoundException;

    boolean updatePayment(PaymentDto dto) throws SQLException, ClassNotFoundException;
}
