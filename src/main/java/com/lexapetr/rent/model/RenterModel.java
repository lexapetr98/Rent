package com.lexapetr.rent.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import partial.update.annotation.ChangeLogger;

import javax.persistence.*;

@Data
@ChangeLogger
public class RenterModel {
    private int renterID;
    private String renterName;
    private String contractDay;
    private String phoneNumber;
    private String email;
    private int debt;
    private boolean debtor;


    //private List<RealEstate> realEstates;

//    public RenterModel(final String renterName, final String contractDay, final String phoneNumber, final String email){
//        setRenterName(renterName);
//        setContractDay(contractDay);
//        setPhoneNumber(phoneNumber);
//        setEmail(email);
//        setDebt(0);
//        setDebtor(false);
//        //realEstates = new ArrayList<RealEstate>();
//    }

//    public void addRealEstate(RealEstate realEstate){
//        realEstate.setRenter(this);
//        realEstates.add(realEstate);
//    }

//    public void removeRealEstate(RealEstate realEstate){
//        realEstates.remove(realEstate);
//    }

}
