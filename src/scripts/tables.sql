-- Activer l’extension pour générer des UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================
-- Table: users
-- =========================
CREATE TABLE users
(
    id         VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(50)  NOT NULL,
    password   VARCHAR(100) NOT NULL
);


-- =========================
-- Table: quote
-- =========================
CREATE TABLE quote
(
    id     VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    text   VARCHAR(500) NOT NULL,
    author VARCHAR(50)  NOT NULL
);

-- =========================
-- Table: quote_view
-- =========================
CREATE TABLE quote_view
(
    id          VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4()::text,
    date_viewed DATE        NOT NULL,
    quote_id    VARCHAR(36) NOT NULL REFERENCES quote (id),
    user_id     VARCHAR(36) NOT NULL REFERENCES users (id)
);

-- Indexes utiles pour les FK (perf)
CREATE INDEX IF NOT EXISTS idx_quote_view_quote_id ON quote_view (quote_id);
CREATE INDEX IF NOT EXISTS idx_quote_view_user_id  ON quote_view (user_id);
