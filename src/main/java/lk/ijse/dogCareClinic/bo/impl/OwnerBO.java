package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.OwnerBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.OwnerIMPL;
import lk.ijse.dogCareClinic.dao.custom.OwnerDAO;
import lk.ijse.dogCareClinic.dto.OwnerDto;

import java.sql.SQLException;
import java.util.List;

public class OwnerBO implements OwnerBODAO {


    OwnerDAO ownerDAO=new OwnerIMPL();
    @Override
    public List<OwnerDto> getAllOwners() throws SQLException, ClassNotFoundException {
        return ownerDAO.getAll();
    }

    @Override
    public boolean saveOwner(OwnerDto dto) throws SQLException, ClassNotFoundException {
        return ownerDAO.save(dto);
    }

    @Override
    public boolean deleteOwner(String id) throws SQLException, ClassNotFoundException {
        return ownerDAO.delete(id);
    }

    @Override
    public OwnerDto searchOwner(String id) throws SQLException, ClassNotFoundException {
        return ownerDAO.search(id);
    }

    @Override
    public boolean updateOwner(OwnerDto dto) throws SQLException, ClassNotFoundException {
        return ownerDAO.update(dto);
    }
}
