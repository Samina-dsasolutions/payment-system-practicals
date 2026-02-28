CREATE TABLE IF NOT EXISTS accounts (
                                        id VARCHAR(50) PRIMARY KEY,
                                        balance DECIMAL(19, 2) NOT NULL,
                                        status VARCHAR(20) NOT NULL
);