package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.EmployeeBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.EmployeeIMPL;
import lk.ijse.dogCareClinic.dao.custom.EmployeeDAO;
import lk.ijse.dogCareClinic.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public class EmployyeBO implements EmployeeBODAO {
    EmployeeDAO employeeDAO=new EmployeeIMPL();
    @Override
    public List<EmployeeDto> getAllEmployess() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAll();
    }

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(dto);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public EmployeeDto searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(id);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(dto);
    }
}
