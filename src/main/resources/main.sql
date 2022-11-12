CREATE TABLE composers(
    id integer NOT NULL PRIMARY KEY,
    lastname VARCHAR(30)
);

CREATE TABLE operas(
    id integer NOT NULL PRIMARY KEY,
    title varchar(50),
    composer INTEGER REFERENCES composers
);



