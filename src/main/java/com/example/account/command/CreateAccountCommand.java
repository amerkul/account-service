package com.example.account.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateAccountCommand {

    private String name;
    private Integer balance;
    private Integer reserved;
    @JsonProperty("auction_id")
    private Long auctionId;

}
