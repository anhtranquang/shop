CREATE TABLE "Customer" (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            mobile_number VARCHAR(255) NOT NULL,
                            address VARCHAR(255) NOT NULL
);

INSERT INTO "Customer" (name, mobile_number, address) VALUES
                                                          ('Alice', '0983123123', '85 Cau Giay Str, Hanoi Vietnam'),
                                                          ('Bob', '043213020', '456 Pine St, Hanoi Vietnam'),
                                                          ('Charlie', '0765123123', '789 ABC St, Bangkok Thailand'),
                                                          ('Dave', '0321898989', '123 John Str, London England'),
                                                          ('Eve', '0356127892', '654 Birch St, Anytown USA');