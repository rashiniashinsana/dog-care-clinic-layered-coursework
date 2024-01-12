package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.DogDto;

import java.sql.SQLException;
import java.util.List;

public interface DogBODAO {

    List<DogDto> getAllDogs() throws SQLException, ClassNotFoundException;

    boolean saveDog(DogDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteDog(String id) throws SQLException, ClassNotFoundException;

    DogDto searchDog(String id) throws SQLException, ClassNotFoundException;

    boolean updateDog(DogDto dto) throws SQLException, ClassNotFoundException;
}
