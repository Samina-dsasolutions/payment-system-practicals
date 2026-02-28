CREATE TABLE transaction_history (
                                     id VARCHAR(50) PRIMARY KEY,
                                     account_id VARCHAR(50) NOT NULL,
                                     amount DECIMAL(19, 2) NOT NULL,
                                     transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     status VARCHAR(20) NOT NULL
);