CREATE SEQUENCE game_sequence START 1;
CREATE SEQUENCE language_sequence START 1;
CREATE SEQUENCE player_sequence START 1;
CREATE SEQUENCE prompt_sequence START 1;
CREATE SEQUENCE round_sequence START 1;
CREATE SEQUENCE user_sequence START 1;

CREATE TABLE games (
    id BIGINT PRIMARY KEY DEFAULT nextval('game_sequence'),
    "date" DATE NOT NULL
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_sequence'),
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE languages (
    id BIGINT PRIMARY KEY DEFAULT nextval('language_sequence'),
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE prompts (
    id BIGINT PRIMARY KEY DEFAULT nextval('prompt_sequence'),
    name VARCHAR(255) NOT NULL,
    id_language BIGINT NOT NULL,
    CONSTRAINT fk_prompt_language FOREIGN KEY (id_language) REFERENCES languages(id),
    CONSTRAINT uk_prompt_name_language UNIQUE (name, id_language)
);

CREATE TABLE rounds (
    id BIGINT PRIMARY KEY DEFAULT nextval('round_sequence'),
    "order" INT NOT NULL,
    image OID NOT NULL,
    id_game BIGINT NOT NULL,
    id_prompt BIGINT NOT NULL,
    CONSTRAINT fk_round_game FOREIGN KEY (id_game) REFERENCES games(id),
    CONSTRAINT fk_round_prompt FOREIGN KEY (id_prompt) REFERENCES prompts(id)
);

CREATE TABLE players (
    id BIGINT PRIMARY KEY DEFAULT nextval('player_sequence'),
    place INT NULL,
    is_drawing BOOL NOT NULL,
    id_user BIGINT NOT NULL,
    id_round BIGINT NOT NULL,
    CONSTRAINT fk_player_user FOREIGN KEY (id_user) REFERENCES users(id),
    CONSTRAINT fk_round_prompt FOREIGN KEY (id_round) REFERENCES rounds(id)
);