DROP TABLE IF EXISTS track_times CASCADE ;

CREATE TABLE IF NOT EXISTS track_times
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR,
    is_async BOOLEAN,
    timestamp TIMESTAMP WITHOUT TIME ZONE,
    execution_duration BIGINT
);