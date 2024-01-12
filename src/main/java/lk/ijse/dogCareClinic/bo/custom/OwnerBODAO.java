package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.OwnerDto;

import java.sql.SQLException;
import java.util.List;

public interface OwnerBODAO {
    List<OwnerDto> getAllOwners() throws SQLException, ClassNotFoundException;

    boolean saveOwner(OwnerDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteOwner(String id) throws SQLException, ClassNotFoundException;

    OwnerDto searchOwner(String id) throws SQLException, ClassNotFoundException;

    boolean updateOwner(OwnerDto dto) throws SQLException, ClassNotFoundException;
}
