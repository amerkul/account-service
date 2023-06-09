package com.example.account.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("bookmark")
@NoArgsConstructor
@AllArgsConstructor
public class Bookmark {

    @Id
    @Column("bookmark_id")
    private Long bookmarkId;
    private String title;
    @Column("release_year")
    private Integer releaseYear;
    @Column("account_id")
    private Long accountId;

}
