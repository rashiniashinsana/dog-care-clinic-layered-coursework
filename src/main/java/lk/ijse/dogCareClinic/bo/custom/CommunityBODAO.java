package lk.ijse.dogCareClinic.bo.custom;

import lk.ijse.dogCareClinic.dto.communityDto;

import java.sql.SQLException;
import java.util.List;

public interface CommunityBODAO {

    boolean saveCommunity(communityDto communityDto) throws SQLException, ClassNotFoundException;

    boolean deleteCommunity(String id) throws SQLException, ClassNotFoundException;

    communityDto searchCommunity(String id) throws SQLException, ClassNotFoundException;

    boolean updateCommunity(communityDto communityDto) throws SQLException, ClassNotFoundException;

    List<communityDto> getAllCommunity() throws SQLException, ClassNotFoundException;
}
