package com.example.account.graphql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountInput {

    private String name;
    private Integer balance;
    private Integer reserved;
    private String auctionId;

}
