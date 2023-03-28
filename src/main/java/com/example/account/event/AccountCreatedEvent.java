package com.example.account.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent{

    private Long id;
    private String name;
    private Integer balance;
    private Integer reserved;
    private BidStatus status;
    private Long auctionId;

}
