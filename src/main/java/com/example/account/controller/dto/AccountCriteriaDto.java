package com.example.account.controller.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountCriteriaDto {

    private String name;
    private Integer balanceGte;
    private Integer balanceLte;
    private Integer reservedGte;
    private Integer reservedLte;
    private String status;
    private String auctionId;

}
