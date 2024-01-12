package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.InvenToryDeatailDAO;

import java.sql.SQLException;

public class InventoryDetailIMPL implements InvenToryDeatailDAO {
    public  boolean saveInventoryDetails(String ItemId, String UnitPrice, double Quantity) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO inventory_details VALUES(?, ?, ?)",ItemId,UnitPrice,Quantity);
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO inventory_details VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, ItemId);
        pstm.setString(2, UnitPrice);
        pstm.setDouble(3, Quantity);


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/
    }
}

