package lk.ijse.dogCareClinic.bo.impl;

import lk.ijse.dogCareClinic.bo.custom.CommunityBODAO;
import lk.ijse.dogCareClinic.dao.IMpl.CommunityIMPL;
import lk.ijse.dogCareClinic.dao.custom.CommunityDAO;
import lk.ijse.dogCareClinic.dto.communityDto;

import java.sql.SQLException;
import java.util.List;

public class CoummunityBO implements CommunityBODAO {
    CommunityDAO communityDAO=new CommunityIMPL();

    @Override
    public boolean saveCommunity(communityDto communityDto) throws SQLException, ClassNotFoundException {
        return communityDAO.save(communityDto);
    }

    @Override
    public boolean deleteCommunity(String id) throws SQLException, ClassNotFoundException {
        return communityDAO.delete(id);
    }

    @Override
    public communityDto searchCommunity(String id) throws SQLException, ClassNotFoundException {
        return communityDAO.search(id);
    }

    @Override
    public boolean updateCommunity(communityDto communityDto) throws SQLException, ClassNotFoundException {
        return communityDAO.update(communityDto);
    }

    @Override
    public List<communityDto> getAllCommunity() throws SQLException, ClassNotFoundException {
        return communityDAO.getAll();
    }
}
