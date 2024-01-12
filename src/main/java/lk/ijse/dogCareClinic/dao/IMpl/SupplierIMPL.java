package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.SupplierDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.SupplierDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierIMPL implements SupplierDAO {


    public boolean save(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO supplier VALUES(?, ?, ?, ?)",dto.getSupplierID(),dto.getSupplierName(),dto.getContact(),dto.getSupplierment());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM supplier WHERE Sup_ID = ?",id);
    }

    public List<SupplierDto> getAll() throws SQLException, ClassNotFoundException {
        List<SupplierDto> dtoList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM supplier");
        while (resultSet.next()) {
           /* String SupplierID = resultSet.getString(1);
            String SupplierName = resultSet.getString(2);
            String Contact = resultSet.getString(3);
            String Supplierment = resultSet.getString(4);


            var dto = new SupplierDto(SupplierID, SupplierName, Contact, Supplierment);
            dtoList.add(dto);*/
            dtoList.add(new SupplierDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return dtoList;
    }

    public boolean update(SupplierDto dto) throws SQLException, ClassNotFoundException {

        return CrudUtil.executeUpdate("UPDATE supplier SET  Sup_Name= ?,  Contact = ?, Supplierment = ? WHERE Sup_ID = ?",dto.getSupplierName(),dto.getContact(),dto.getSupplierment(),dto.getSupplierID());

    }

    public SupplierDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM supplier WHERE Sup_ID = ?",id);
        SupplierDto dto = null;
        resultSet.next();
           /* String Sup_ID = resultSet.getString(1);
            String Sup_Name = resultSet.getString(2);
            String Contact = resultSet.getString(3);
            String Supplierment = resultSet.getString(4);


            dto = new SupplierDto(Sup_ID, Sup_Name, Contact, Supplierment);*/
            return new SupplierDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));



    }
}

