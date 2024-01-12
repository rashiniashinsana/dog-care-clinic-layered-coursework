package lk.ijse.dogCareClinic.dao.custom;

import lk.ijse.dogCareClinic.dto.EmployeeDto;
import lk.ijse.dogCareClinic.dao.CrudDAO;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeDto,String> {
    boolean updatess(EmployeeDto dto) throws SQLException, ClassNotFoundException;
}
