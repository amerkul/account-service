CREATE TABLE event (
    event_id VARCHAR(128) NOT NULL,
    type VARCHAR(100) NOT NULL,
    payload VARCHAR(1000) NOT NULL,
    created TIMESTAMP
);