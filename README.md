# account-service

Account service creates a bid and Kafka producer sends an event with the PENDING status to the Auction application. Auction application returns an UpdateAccountCommand with the ACCEPTED or REJECTED status. The bidder account is updated and a new one event is created. The aggregate and event are stored in the database.
