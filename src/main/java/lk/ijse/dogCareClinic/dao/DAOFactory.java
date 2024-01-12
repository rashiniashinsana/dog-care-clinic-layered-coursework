package lk.ijse.dogCareClinic.dao;

import lk.ijse.dogCareClinic.dao.IMpl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOtypes{
       APPOINMENT,COMMUNITY,DOG,EMPLOYEE,INVENTORYDETAIL,INVENTORY,OWNER,PAYMENT,PLACEINVENTORY,RECORD,SUPPLIER,TRETMENT,USER
    }

    public Object getDAO(DAOtypes types){
        switch (types){
            case APPOINMENT:
                return new AppointmentIMPL();
            case COMMUNITY:
                return new CommunityIMPL();
            case DOG:
                return new DogIMPL();
            case EMPLOYEE:
                return new EmployeeIMPL();
            case INVENTORYDETAIL:
                return new InventoryDetailIMPL();
            case INVENTORY:
                return new InventoryIMPL();
            case OWNER:
                return new OwnerIMPL();
            case PAYMENT:
                return new PaymentIMPL();
            case PLACEINVENTORY:
                return new PlaceInvetoryIMPL();
            case RECORD:
                return new RecordIMPL();
            case SUPPLIER:
                return new SupplierIMPL();
            case TRETMENT:
                return new TreatmentIMPL();
            case USER:
                return new UserIMPL();
            default:
                return null;
        }
    }
}
