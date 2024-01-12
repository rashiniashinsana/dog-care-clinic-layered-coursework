package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.PaymentDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.PaymentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentIMPL implements PaymentDAO {


    public boolean save(PaymentDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO payment VALUES(?, ?, ?)",dto.getPaymentId(),dto.getAmount(),dto.getDate());

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM payment WHERE P_ID = ?",id);
    }

    public List<PaymentDto> getAll() throws SQLException, ClassNotFoundException {
        List<PaymentDto> dtoList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM payment");

        while (resultSet.next()) {
            dtoList.add(new PaymentDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
        }
        return dtoList;
    }

    public boolean update(PaymentDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE payment SET Amount = ?, Date = ? WHERE P_ID = ?",dto.getAmount(),dto.getDate(),dto.getPaymentId());

    }


    public PaymentDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM payment WHERE P_ID = ?",id);
        PaymentDto dto = null;
        resultSet.next();
            return new PaymentDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));


    }
}
