package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.SupplierBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.SupplierIMPL;
import lk.ijse.dogCareClinic.dao.custom.SupplierDAO;
import lk.ijse.dogCareClinic.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public class SupplierBO implements SupplierBODAO {
    SupplierDAO supplierDAO=new SupplierIMPL();
    @Override
    public List<SupplierDto> getAllSupplier() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAll();
    }

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(dto);
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(dto);
    }
}
