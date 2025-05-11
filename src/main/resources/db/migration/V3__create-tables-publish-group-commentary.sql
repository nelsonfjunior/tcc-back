CREATE TABLE groups (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,  
    description VARCHAR(255),
    image_name VARCHAR(255),
    image BYTEA,
    adm_id VARCHAR(36) REFERENCES users(id) NOT NULL
);

CREATE TABLE user_group (
    group_id VARCHAR(36) REFERENCES groups(id),
    user_id VARCHAR(36) REFERENCES users(id)
);

CREATE TABLE publish (
    id VARCHAR(36) PRIMARY KEY,
    description TEXT,
    image BYTEA NOT NULL,
    when_sent TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author_id VARCHAR(36) REFERENCES users(id) NOT NULL,
    group_id VARCHAR(36) REFERENCES groups(id) NOT NULL
);


CREATE TABLE commentary (
    id VARCHAR(36) PRIMARY KEY,
    content TEXT NOT NULL,
    when_sent TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author_id VARCHAR(36) REFERENCES users(id) NOT NULL,
    publish_id VARCHAR(36) REFERENCES publish(id) NOT NULL
);