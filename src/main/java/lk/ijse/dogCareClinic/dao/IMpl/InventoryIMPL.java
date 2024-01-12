package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.InventoryDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.InvenToryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryIMPL implements InvenToryDAO {


    public static boolean saveInventory(InventoryDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate( "INSERT INTO inventory VALUES(?, ?, ?, ?, ?)",dto.getItem_ID(),dto.getItem_Name(),dto.getDescription(),dto.getUnit_Price(),dto.getQuantity());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO inventory VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getItem_ID());
        pstm.setString(2, dto.getItem_Name());
        pstm.setString(3, dto.getDescription());
        pstm.setString(4, dto.getUnit_Price());
        pstm.setString(5, String.valueOf(dto.getQuantity()));

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/
    }

    @Override
    public boolean save(InventoryDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate( "INSERT INTO inventory VALUES(?, ?, ?, ?, ?)",dto.getItem_ID(),dto.getItem_Name(),dto.getDescription(),dto.getUnit_Price(),dto.getQuantity());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM inventory WHERE Item_ID = ?",id);
    }

    public List<InventoryDto> getAll() throws SQLException, ClassNotFoundException {
        List<InventoryDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM inventory");

        while (r.next()) {
           /* String Item_ID = resultSet.getString(1);
            String Item_Name = resultSet.getString(2);
            String Description = resultSet.getString(3);
            String Unit_Price = resultSet.getString(4);
            String Quantity = resultSet.getString(5);


            var dto = new InventoryDto(Item_ID, Item_Name, Description, Unit_Price, Quantity);
            dtoList.add(dto);*/
            dtoList.add(new InventoryDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5)));
        }
        return dtoList;
    }

    public boolean update(InventoryDto dto) throws SQLException, ClassNotFoundException {
        return  CrudUtil.executeUpdate("UPDATE inventory SET Item_Name = ?, Description = ?, Unit_Price = ?, Quantity = ?  WHERE Item_ID = ?",dto.getItem_Name(),dto.getDescription(),dto.getUnit_Price(),dto.getQuantity(),dto.getItem_ID());

    }

    public InventoryDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM inventory WHERE Item_ID = ?",id);
      //  InventoryDto dto = null;
             r.next();
            return new InventoryDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5));



    }


}
