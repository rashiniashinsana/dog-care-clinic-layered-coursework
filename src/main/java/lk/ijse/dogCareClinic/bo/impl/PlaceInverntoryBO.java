package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.PlaceInventoryBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.InventoryDetailIMPL;
import lk.ijse.dogCareClinic.dao.IMpl.InventoryIMPL;
import lk.ijse.dogCareClinic.dao.custom.InvenToryDeatailDAO;
import lk.ijse.dogCareClinic.dao.custom.InvenToryDAO;
import lk.ijse.dogCareClinic.db.DbConnection;
import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceInverntoryBO  implements PlaceInventoryBODAO {
    private final InvenToryDAO InventoryIMPL = new InventoryIMPL();
    private final InvenToryDeatailDAO InventoryDetailIMPL = new InventoryDetailIMPL();
    public boolean placeInventory(InventoryDto pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            // InventoryIMPL.s
            boolean isOrderSaved = InventoryIMPL.save(pDto);
            if (isOrderSaved) {
                boolean isUpdated = InventoryDetailIMPL.saveInventoryDetails(pDto.getItem_ID(), pDto.getUnit_Price(), pDto.getQuantity());
                if (isUpdated) {
                    connection.commit();
                    result = true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return result;


    }
}
