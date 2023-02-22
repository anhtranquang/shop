CREATE TABLE "Order" (
                         id SERIAL PRIMARY KEY,
                         customer_id INTEGER REFERENCES "Customer"(id) NOT NULL,
                         shop_id INTEGER REFERENCES "Shop"(id) NOT NULL,
                         menu_item_id INTEGER REFERENCES "Menu"(id) NOT NULL,
                         order_status VARCHAR(255) NOT NULL
);

INSERT INTO "Order" (customer_id, shop_id, menu_item_id, order_status) VALUES
                                                                           (1, 1, 1, 'pending'),
                                                                           (2, 1, 2, 'pending'),
                                                                           (3, 1, 1, 'cancelled'),
                                                                           (4, 2, 3, 'completed'),
                                                                           (5, 2, 4, 'pending');