package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBODAO {
    List<EmployeeDto> getAllEmployess() throws SQLException, ClassNotFoundException;

    boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    EmployeeDto searchEmployee(String id) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
}
