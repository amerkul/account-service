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
@Table("event")
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent extends Event {

    @Id
    private Long id;
    private String name;
    private Integer balance;
    private Integer reserved;
    private BidStatus status;
    @Column("auction_id")
    private Long auctionId;

}
