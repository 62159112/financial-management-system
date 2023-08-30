package com.chongdong.financialmanagementsystem.factory;

import com.chongdong.financialmanagementsystem.model.*;

public class EntityFactory {
    public static Payment createPayment(){return new Payment();}

    public static Income createIncome(){
        return new Income();
    }

    public static Inventory createInventory(){return new Inventory() ;}

    public static Expenses createExpenses(){return new Expenses();}

    public static Labor createLabor(){return new Labor();}

    public static Operate createOperate(){return new Operate();}

    public static Procurement createProcurement(){return new Procurement();}

    public static Purchase createPurchase(){return new Purchase();}

    public static Reimbursement createReimbursement(){return new Reimbursement();}

    public static Sale createSale(){return new Sale();}
}
