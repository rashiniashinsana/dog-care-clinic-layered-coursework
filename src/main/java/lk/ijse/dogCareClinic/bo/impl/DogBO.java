package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.DogBODAO;
import lk.ijse.dogCareClinic.bo.custom.UserBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.DogIMPL;
import lk.ijse.dogCareClinic.dao.custom.DogDAO;
import lk.ijse.dogCareClinic.dto.DogDto;

import java.sql.SQLException;
import java.util.List;

public class DogBO implements DogBODAO {
    DogDAO dogDAO=new DogIMPL();

    @Override
    public List<DogDto> getAllDogs() throws SQLException, ClassNotFoundException {
        return dogDAO.getAll();
    }

    @Override
    public boolean saveDog(DogDto dto) throws SQLException, ClassNotFoundException {
        return dogDAO.save(dto);
    }

    @Override
    public boolean deleteDog(String id) throws SQLException, ClassNotFoundException {
        return dogDAO.delete(id);
    }

    @Override
    public DogDto searchDog(String id) throws SQLException, ClassNotFoundException {
        return dogDAO.search(id);
    }

    @Override
    public boolean updateDog(DogDto dto) throws SQLException, ClassNotFoundException {
        return dogDAO.update(dto);
    }
}
