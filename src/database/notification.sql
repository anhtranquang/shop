CREATE TABLE "Notification" (
                                id SERIAL PRIMARY KEY,
                                recipient VARCHAR(255) NOT NULL,
                                message VARCHAR(255) NOT NULL,
                                timestamp TIMESTAMP NOT NULL
);

INSERT INTO "Notification" (recipient, message, timestamp) VALUES  ('555-1111', 'Your order is ready for pickup!', '2023-02-20 10:00:00'),
                                                                   ('555-4444', 'Your order has been cancelled.', '2023-02-20 10:05:00');