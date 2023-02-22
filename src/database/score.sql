CREATE TABLE "Score" (
                         id SERIAL PRIMARY KEY,
                         customer_id INTEGER REFERENCES "Customer"(id) NOT NULL,
                         score_value INTEGER NOT NULL
);

INSERT INTO "Score" (customer_id, score_value) VALUES (1, 3), (2, 2), (3, 1), (4, 5), (5, 4);