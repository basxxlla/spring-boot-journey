--Player Table
CREATE TABLE Player (
    id NUMBER NOT NULL,
    name VARCHAR2(100) NOT NULL, -- Added NOT NULL as names typically shouldn't be empty
    age NUMBER,
    CONSTRAINT pkt_player_id PRIMARY KEY (id),
    CONSTRAINT unq_player_name UNIQUE (name)
);

--Manager Table (Composite Unique)
CREATE TABLE Manager (
    id NUMBER NOT NULL,
    name VARCHAR2(100),
    salary NUMBER(10, 2),
    -- This enforces that the combination of id + name is unique
    CONSTRAINT unq_mgr_id_name UNIQUE (id, name)
);

--Manager Table (with Primary Key)
CREATE TABLE Manager_PK (
    id NUMBER,
    name VARCHAR2(100),
    age NUMBER,
    -- Primary Key automatically makes 'id' NOT NULL and UNIQUE
    CONSTRAINT pkt_manager_pk_id PRIMARY KEY (id)
);