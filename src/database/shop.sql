CREATE TABLE "Shop" (   id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        location VARCHAR(255) NOT NULL,
                        contact_details VARCHAR(255) NOT NULL,
                        opening_time TIME NOT NULL,
                        closing_time TIME NOT NULL
);

INSERT INTO "Shop" (name, location, contact_details, opening_time, closing_time) VALUES ('Coffee Shop A', '123 Main St, Anytown USA', '555-1234', '08:00:00', '18:00:00'),
                                                                                        ('Coffee Shop B', '456 Oak St, Anytown USA', '555-5678', '07:30:00', '17:30:00');
