package com.example.account.domain.data.criteria;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountCriteria {

    private String name;
    private Integer balanceGte;
    private Integer balanceLte;
    private Integer reservedGte;
    private Integer reservedLte;
    private String status;
    private String auctionId;

}
