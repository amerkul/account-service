package com.example.account.domain.event;

import com.example.account.domain.aggregate.AccountAggregate;
import com.example.account.domain.aggregate.BidStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent extends EventEntity {

    @Transient
    private Long accountId;
    @Transient
    private String name;
    @Transient
    private Integer balance;
    @Transient
    private Integer reserved;
    @Transient
    private BidStatus status;
    @Transient
    private String auctionId;

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
