package com.example.account.command;

import com.example.account.event.BidStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateAccountCommand {

    private String name;
    private Integer balance;
    private Integer reserved;
    @JsonProperty("auction_id")
    private String auctionId;
    private BidStatus status;

}
