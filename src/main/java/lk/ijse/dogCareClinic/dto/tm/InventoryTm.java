package lk.ijse.dogCareClinic.dto.tm;

public class InventoryTm {

    private String Item_ID;
    private String Item_Name;
    private String Description;
    private String Unit_Price;
    private double Quantity;


    public InventoryTm(String Item_ID, String Item_Name, String Description, String Unit_Price, double Quantity) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Description = Description;
        this.Unit_Price = Unit_Price;
        this.Quantity = Quantity;
    }

    public String getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(String item_ID) {
        Item_ID = item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(String unit_Price) {
        Unit_Price = unit_Price;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }
}