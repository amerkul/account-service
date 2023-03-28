CREATE TABLE event (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    balance INT NOT NULL,
    reserved INT NOT NULL,
    type VARCHAR(100) NOT NULL,
    status VARCHAR(30) NOT NULL,
    auction_id VARCHAR(30) NOT NULL,
    event_id VARCHAR(128) NOT NULL,
    created TIMESTAMP
);