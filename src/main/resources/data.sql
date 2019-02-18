CREATE TABLE IF NOT EXISTS transaction (
    id INT AUTO_INCREMENT,
    payerid INT,
    payeeid INT,
    amount FLOAT,
    date date NOT NULL,
    PRIMARY KEY (id)
);