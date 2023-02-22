CREATE TABLE "Menu" (
                        id SERIAL PRIMARY KEY,
                        shop_id INTEGER REFERENCES "Shop"(id) NOT NULL,
                        item_name VARCHAR(255) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL
);

INSERT INTO "Menu" (shop_id, item_name, price) VALUES (1, 'Espresso', 2.50),
                                                      (1, 'Latte', 3.50),
                                                      (2, 'Cappuccino', 3.00),
                                                      (2, 'Mocha', 4.00);