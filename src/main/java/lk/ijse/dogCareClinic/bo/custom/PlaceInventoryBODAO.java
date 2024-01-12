package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.SQLException;

public interface PlaceInventoryBODAO {
    public boolean placeInventory(InventoryDto pDto) throws SQLException;
}
