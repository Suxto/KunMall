CREATE DATABASE KunMall;
USE KunMall;
CREATE TABLE Users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30),
    isAdmin  BOOLEAN DEFAULT FALSE,
    passwd   VARCHAR(40) NOT NULL
);

CREATE TABLE Orders
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    userID    INT NOT NULL REFERENCES Users (id),
    CPUID     INT NOT NULL REFERENCES CPU (id),
    GPUID     INT NOT NULL REFERENCES GPU (id),
    DriveID   INT NOT NULL REFERENCES Drive (id),
    MemoryID  INT NOT NULL REFERENCES Memory (id),
    address   VARCHAR(40),
    money     DECIMAL(10, 2),
    orderTime DATETIME,
    status    BOOLEAN,
    comment   VARCHAR(70)
);

CREATE TABLE Recommends
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    CPUID    INT NOT NULL REFERENCES CPU (id),
    GPUID    INT NOT NULL REFERENCES GPU (id),
    DriveID  INT NOT NULL REFERENCES Drive (id),
    MemoryID INT NOT NULL REFERENCES Memory (id),
    comment  VARCHAR(70)
);

CREATE TABLE CPU
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    money  DECIMAL(10, 2) NOT NULL,
    name   VARCHAR(20),
    amount INT
);

CREATE TABLE GPU
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    money  DECIMAL(10, 2) NOT NULL,
    name   VARCHAR(20),
    amount INT
);

CREATE TABLE Drive
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    money  DECIMAL(10, 2) NOT NULL,
    name   VARCHAR(20),
    amount INT
);

CREATE TABLE Memory
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    money  DECIMAL(10, 2) NOT NULL,
    name   VARCHAR(20),
    amount INT
);

CREATE TABLE Service
(
    userID   INT PRIMARY KEY REFERENCES Users (id),
    content  TEXT,
    lastChat TIMESTAMP
);

CREATE TABLE Cart
(
    userID   INT PRIMARY KEY REFERENCES Users (id),
    id       INT AUTO_INCREMENT UNIQUE KEY,
    CPUID    INT NOT NULL REFERENCES CPU (id),
    GPUID    INT NOT NULL REFERENCES GPU (id),
    DriveID  INT NOT NULL REFERENCES Drive (id),
    MemoryID INT NOT NULL REFERENCES Memory (id)
)

