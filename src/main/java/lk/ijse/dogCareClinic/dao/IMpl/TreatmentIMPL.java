package lk.ijse.dogCareClinic.dao.IMpl;

import lk.ijse.dogCareClinic.dto.TreatmentDto;
import lk.ijse.dogCareClinic.dao.CrudUtil;
import lk.ijse.dogCareClinic.dao.custom.TreatMentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreatmentIMPL implements TreatMentDAO{

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM treatment WHERE T_ID = ?",id);

    }

    public boolean save(TreatmentDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO treatment VALUES(?, ?, ?, ?, ?, ?)",dto.getTreatmentID(),dto.getDate(),dto.getMedication(),dto.getDiagnosis(),dto.getPaymentID(),dto.getDogID());


    }

    public List<TreatmentDto> getAll() throws SQLException, ClassNotFoundException {
        List<TreatmentDto> dtoList = new ArrayList<>();
        ResultSet r = CrudUtil.executeQuery("SELECT * FROM treatment");


        while (r.next()) {
           /* String TreatmentID = resultSet.getString(1);
            String Date = resultSet.getString(2);
            String Medication = resultSet.getString(3);
            String Diagnosis = resultSet.getString(4);
            String DogID = resultSet.getString(5);
            String PaymentID = resultSet.getString(6);

            var dto = new TreatmentDto(TreatmentID, Date, Medication, Diagnosis, DogID, PaymentID);*/
            dtoList.add(new TreatmentDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)));
        }
        return dtoList;
    }

    public boolean update(TreatmentDto dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE treatment SET  Date = ?, Medication = ?, Diagnosis = ?, D_ID =?, p_ID = ? WHERE T_ID = ?",dto.getTreatmentID(),dto.getDate(),dto.getMedication(),dto.getDiagnosis(),dto.getDogID(),dto.getPaymentID());

    }

    public TreatmentDto search(String id) throws SQLException, ClassNotFoundException {
         ResultSet r= CrudUtil.executeQuery( "SELECT * FROM treatment WHERE T_ID = ?",id);

      //  TreatmentDto dto = null;
          r.next();
          return   new TreatmentDto(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6) );



    }

}

