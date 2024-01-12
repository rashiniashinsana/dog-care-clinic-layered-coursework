package lk.ijse.dogCareClinic.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T,ID> {
    boolean save (T t) throws SQLException, ClassNotFoundException;

    boolean delete(ID id)throws SQLException, ClassNotFoundException;

    boolean update(T t)throws SQLException, ClassNotFoundException;
    List<T> getAll()throws SQLException, ClassNotFoundException;

    T search(ID id)throws SQLException, ClassNotFoundException;
}
