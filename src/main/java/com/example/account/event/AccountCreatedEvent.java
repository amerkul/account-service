package com.example.account.event;

import com.example.account.aggregate.AccountAggregate;
import com.example.account.aggregate.BidStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent extends EventEntity {

    private Long accountId;
    private String name;
    private Integer balance;
    private Integer reserved;
    private BidStatus status;
    private Long auctionId;

    @SneakyThrows
    public void apply (AccountAggregate accountAggregate) {
        this.name = accountAggregate.getName();
        this.balance = accountAggregate.getBalance();
        this.status = accountAggregate.getStatus();
        this.auctionId = accountAggregate.getAuctionId();
        this.reserved = accountAggregate.getReserved();
        this.accountId = accountAggregate.getAccountId();
        ObjectMapper objectMapper = new ObjectMapper();
        super.setPayload(objectMapper.writeValueAsString(this));
        super.setType(AccountCreatedEvent.class.getName());
    }

}
