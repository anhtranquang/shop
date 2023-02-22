CREATE TABLE "QueueItem" (
                             id SERIAL PRIMARY KEY,
                             queue_id INTEGER REFERENCES "Queue"(id) NOT NULL,
                             customer_name VARCHAR(255) NOT NULL,
                             customer_score INTEGER NOT NULL,
                             queue_position INTEGER NOT NULL
);


INSERT INTO "QueueItem" (queue_id, customer_name, customer_score, queue_position) VALUES (1, 'Alice', 5, 1), (1, 'Bob', 3, 2),
                                                                                         (1, 'Charlie', 1, 3),(2, 'Dave', 4, 1), (2, 'Eve', 2, 2);