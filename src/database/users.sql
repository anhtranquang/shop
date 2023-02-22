CREATE TABLE "User" (
                        id SERIAL PRIMARY KEY,
                        username VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(255) NOT NULL
);
INSERT INTO "User" (username, password, role) VALUES ('admin', 'hashed_password', 'admin'),
                                                     ('operator1', 'hashed_password', 'operator'),
                                                     ('operator2', 'hashed_password', 'operator');
