package com.lexapetr.rent.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "renter", schema = "public")
public class Renter{
    @Getter
    @Setter
    @Id
    @Column(name = "renterid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int renterID;

    @Setter
    @Getter
    @Column(name = "rentername")
    private String renterName;

    @Setter
    @Getter
    @Column(name = "contractday")
    private String contractDay;

    @Setter
    @Getter
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Setter
    @Getter
    @Column(name = "email")
    private String email;

    @Setter
    @Getter
    @Column(name = "debt")
    private int debt;

    @Setter
    @Getter
    @Column(name = "isdebtor")
    private boolean debtor;


    //private List<RealEstate> realEstates;


    public Renter(final String renterName, final String contractDay, final String phoneNumber, final String email){
        setRenterName(renterName);
        setContractDay(contractDay);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDebt(0);
        setDebtor(false);
        //realEstates = new ArrayList<RealEstate>();
    }

//    public void addRealEstate(RealEstate realEstate){
//        realEstate.setRenter(this);
//        realEstates.add(realEstate);
//    }

//    public void removeRealEstate(RealEstate realEstate){
//        realEstates.remove(realEstate);
//    }



}
