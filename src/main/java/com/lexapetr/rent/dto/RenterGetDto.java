package com.lexapetr.rent.dto;

import lombok.Data;

@Data
public class RenterGetDto {
    private int renterId;
    private String renterName;
    private String contractDay;
    private String phoneNumber;
    private String email;
    private int debt;
    private boolean debtor;
}
