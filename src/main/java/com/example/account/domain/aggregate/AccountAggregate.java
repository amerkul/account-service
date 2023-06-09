package com.example.account.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Builder
@Table("account")
@AllArgsConstructor
@RequiredArgsConstructor
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
    @Transient
    List<Bookmark> bookmarks;

    public AccountAggregate(Long accountId, String name, Integer balance, Integer reserved, BidStatus status, String auctionId) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
        this.reserved = reserved;
        this.status = status;
        this.auctionId = auctionId;
    }

}
