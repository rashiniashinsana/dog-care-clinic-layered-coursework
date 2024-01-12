package lk.ijse.dogCareClinic.dao.custom;

import lk.ijse.dogCareClinic.dto.InventoryDto;
import lk.ijse.dogCareClinic.dao.CrudDAO;

import java.sql.SQLException;

public interface InvenToryDAO extends CrudDAO<InventoryDto,String> {

    public static boolean saveInventory(InventoryDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

}
