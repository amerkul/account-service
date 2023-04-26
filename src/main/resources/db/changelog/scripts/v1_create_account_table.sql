CREATE TABLE event (
    event_id VARCHAR(128) NOT NULL,
    type VARCHAR(100) NOT NULL,
    payload VARCHAR(1000) NOT NULL,
    created TIMESTAMP
);

CREATE TABLE account (
    account_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance INTEGER NOT NULL,
    reserved INTEGER NOT NULL,
    status VARCHAR(10) NOT NULL,
    auctionId BIGINT NOT NULL
);
