package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.communityDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.CommunityDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityIMPL implements CommunityDAO {


    public boolean save(final communityDto dto) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("INSERT INTO community_project VALUES(?, ?, ?, ?)",dto.getProjectId(),dto.getName(),dto.getDate(),dto.getLocation());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO community_project VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProjectId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getDate());
        pstm.setString(4, dto.getLocation());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;*/
    }

    public List<communityDto> getAll() throws SQLException, ClassNotFoundException {
        List<communityDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM community_project");

        while (r.next()) {
            dtoList.add(new communityDto(r.getString("id"),r.getString("name"),r.getString("date"),r.getString("location")));
        }
        return dtoList;
    }

    public boolean update(communityDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate( "UPDATE community_project SET Project_Name = ?, Date = ?, Location = ? WHERE Project_ID = ?",dto.getName(),dto.getDate(),dto.getLocation(),dto.getProjectId());
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE community_project SET Project_Name = ?, Date = ?, Location = ? WHERE Project_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getDate());
        pstm.setString(3, dto.getLocation());
        pstm.setString(4, dto.getProjectId());

        return pstm.executeUpdate() > 0;*/
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM community_project WHERE Project_ID = ?",id);
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM community_project WHERE Project_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;*/
    }

    public communityDto search(String id) throws SQLException, ClassNotFoundException {
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM community_project WHERE Project_ID = ?");
       // communityDto dto = null;
        r.next();
          return   new communityDto(r.getString("ProjectID"),r.getString("ProjectName"),r.getString("Date"),r.getString("Location"));

        }

}