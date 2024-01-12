package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.SQLException;
import java.util.List;

public interface InvenToryBODAO {

    List<InventoryDto> getAllInvenTory() throws SQLException, ClassNotFoundException;

    boolean deleteInventory(String id) throws SQLException, ClassNotFoundException;

    InventoryDto searchInventory(String id) throws SQLException, ClassNotFoundException;

    boolean updateInventory(InventoryDto dto) throws SQLException, ClassNotFoundException;
}
