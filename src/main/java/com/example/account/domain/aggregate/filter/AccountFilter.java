package com.example.account.domain.aggregate.filter;

import com.example.account.domain.aggregate.BidStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountFilter {

    private String name;
    private BidStatus status;

}
