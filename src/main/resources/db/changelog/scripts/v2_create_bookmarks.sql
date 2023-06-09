CREATE TABLE bookmark (
    bookmark_id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    releaseYear INT NOT NULL,
    account_id BIGINT NOT NULL,
    CONSTRAINT bookmark_account_fk
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);
