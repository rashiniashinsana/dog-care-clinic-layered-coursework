package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.bo.custom.PlaceInventoryBODAO;
import lk.ijse.dogCareClinic.bo.impl.PlaceInverntoryBO;
import lk.ijse.dogCareClinic.dao.custom.PlaceInventoryDAO;
import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.SQLException;

public class PlaceInvetoryIMPL  implements PlaceInventoryDAO {
    // private final invenToryDAO InventoryIMPL = new InventoryIMPL();
    //private final InvenToryDeatailDAO InventoryDetailIMPL = new InventoryDetailIMPL();

    PlaceInventoryBODAO placeInventoryBODAO = new PlaceInverntoryBO();

    public boolean PlaceCustomerOrder(InventoryDto pDto) throws SQLException {
       /* boolean result = false;
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

    }*/
         
        return placeInventoryBODAO.placeInventory(pDto);

    }
}
