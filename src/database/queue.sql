CREATE TABLE "Queue" (
                         id SERIAL PRIMARY KEY,
                         shop_id INTEGER REFERENCES "Shop"(id) NOT NULL,
                         queue_number INTEGER NOT NULL,
                         max_queue_size INTEGER NOT NULL
);

INSERT INTO "Queue" (shop_id, queue_number, max_queue_size) VALUES (1, 1, 10), (2, 1, 8);