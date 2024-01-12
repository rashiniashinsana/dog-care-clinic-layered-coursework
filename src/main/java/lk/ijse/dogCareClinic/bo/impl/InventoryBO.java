package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.InvenToryBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.InventoryIMPL;
import lk.ijse.dogCareClinic.dao.custom.InvenToryDAO;
import lk.ijse.dogCareClinic.dto.InventoryDto;

import java.sql.SQLException;
import java.util.List;

public class InventoryBO implements InvenToryBODAO {
     InvenToryDAO invenToryDAO=new InventoryIMPL();
    @Override
    public List<InventoryDto> getAllInvenTory() throws SQLException, ClassNotFoundException {
        return invenToryDAO.getAll();
    }

    @Override
    public boolean deleteInventory(String id) throws SQLException, ClassNotFoundException {
        return invenToryDAO.delete(id);
    }

    @Override
    public InventoryDto searchInventory(String id) throws SQLException, ClassNotFoundException {
        return invenToryDAO.search(id);
    }

    @Override
    public boolean updateInventory(InventoryDto dto) throws SQLException, ClassNotFoundException {
        return invenToryDAO.update(dto);
    }
}
