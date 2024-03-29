-- CREATE DATABASE KunMall;
USE
    KunMall;
#
drop table Users;
CREATE TABLE Users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30),
    isAdmin  BOOLEAN DEFAULT FALSE,
    passwd   VARCHAR(80) NOT NULL
);

INSERT INTO Users(id, username, isadmin, passwd)
VALUES (1, 'admin', true, '$2a$10$eEr40FHB9zXb4OtH9kzZnu1yRCC6Dg0axUin.eNGeIV0KFN5zYwKu');

CREATE TABLE Orders
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    userID     INT NOT NULL REFERENCES Users (id),
    CPUName    VARCHAR(20),
    GPUName    VARCHAR(20),
    DriveName  VARCHAR(20),
    MemoryName VARCHAR(20),
    address    VARCHAR(40),
    money      DECIMAL(10, 2),
    orderTime  DATETIME,
    status     VARCHAR(10),
    comment    VARCHAR(70)
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

-- DROP TABLE Service;

CREATE TABLE Service
(
    userID   INT PRIMARY KEY,
    #REFERENCES Users (id),
    userName VARCHAR(30),
    #REFERENCES Users (userName),
    content  TEXT,
    status   INT2,
    lastChat TIMESTAMP
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
# DROP TABLE Comment
CREATE TABLE Comment
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    user_id   INT         NOT NULL,
    user_name VARCHAR(30) NOT NULL,
    moment_id INT         NOT NULL,
    content   TEXT
);
# drop table Photo
CREATE TABLE Photo
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    moment_id INT,
    photo     MEDIUMBLOB
);

# drop table Moment;
CREATE TABLE Moment
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    user_id     INT NOT NULL,
    user_name   VARCHAR(30),
    like_num    INT DEFAULT 0,
    comment_num INT DEFAULT 0,
    content     TEXT,
    time_posted BIGINT
);

CREATE TABLE MomentLike
(
    user_id   INT NOT NULL,
    moment_id INT
)