package lk.ijse.dogCareClinic.dao.custom;

import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.SQLException;

public interface PlaceInventoryDAO {
        public boolean PlaceCustomerOrder(InventoryDto pDto) throws SQLException ;
}
