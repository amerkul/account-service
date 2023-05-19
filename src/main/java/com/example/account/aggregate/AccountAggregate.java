package com.example.account.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("account")
@NoArgsConstructor
@AllArgsConstructor
public class AccountAggregate {

    @Id
    @Column("account_id")
    private Long accountId;
    private String name;
    private Integer balance;
    private Integer reserved;
    private BidStatus status;
    @Column("auction_id")
    private String auctionId;

}
