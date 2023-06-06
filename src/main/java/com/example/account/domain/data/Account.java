package com.example.account.domain.data;

import com.example.account.domain.aggregate.BidStatus;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@ToString
@Document(indexName = "account")
public class Account {

    @Id
    private Long id;
    @Field(name = "account_id")
    private Long accountId;
    private String name;
    private Integer balance;
    private Integer reserved;
    private BidStatus status;
    @Field(name = "auction_id")
    private String auctionId;

}
