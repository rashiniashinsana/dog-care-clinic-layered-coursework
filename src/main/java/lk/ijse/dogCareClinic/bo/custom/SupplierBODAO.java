package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBODAO {

    List<SupplierDto> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;
}
