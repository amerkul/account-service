package com.example.account.domain.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateAccountCommand {

    private String name;
    private Integer balance;
    private Integer reserved;
    @JsonProperty("auction_id")
    private String auctionId;

}
