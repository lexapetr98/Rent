package com.lexapetr.rent.dto;

import lombok.Data;

@Data
public class RenterCreateDto {
    private String renterName;
    private String contractDay;
    private String phoneNumber;
    private String email;
    private int debt;
    private boolean debtor;
}
