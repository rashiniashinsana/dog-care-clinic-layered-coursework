package lk.ijse.dogCareClinic.dao.custom;

import java.sql.SQLException;

public interface InvenToryDeatailDAO {
    boolean saveInventoryDetails(String ItemId, String UnitPrice, double Quantity) throws SQLException, ClassNotFoundException ;


}
