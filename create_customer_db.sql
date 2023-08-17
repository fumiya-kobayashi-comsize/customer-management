/*A5:SQLで上から一個ずつ実行してください*/

/*DB作成*/
DROP DATABASE IF EXISTS customer_db;
CREATE DATABASE customer_db;


/*テーブル作成*/
CREATE TABLE customer_db.m_customer(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(50) NOT NULL,
    customer_name_kana VARCHAR(100),
    postal_code CHAR(8),
    address VARCHAR(150),
    area_code CHAR(4) NOT NULL DEFAULT 'A000',
    contact_person_name VARCHAR (30),
    contact_person_name_kana VARCHAR(50),
    contact_person_tel VARCHAR(20),
    user_id VARCHAR(24) NOT NULL,
    update_datetime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

CREATE TABLE customer_db.m_area(
    area_code CHAR(4) PRIMARY KEY,
    area_name VARCHAR(10) UNIQUE NOT NULL,
    update_datetime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

CREATE TABLE customer_db.m_user(
    user_id VARCHAR(24) PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    user_name VARCHAR(20) UNIQUE NOT NULL,
    update_datetime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

/*外部キー制約付与*/
ALTER TABLE customer_db.m_customer ADD FOREIGN KEY (area_code)
    REFERENCES customer_db.m_area (area_code);

ALTER TABLE customer_db.m_customer ADD FOREIGN KEY (user_id)
    REFERENCES customer_db.m_user (user_id);

/*初期データをINSERT（地区マスタ）*/
INSERT INTO customer_db.m_area (area_code,area_name)
    VALUES ('A000','地区未設定');

INSERT INTO customer_db.m_area (area_code,area_name)
    VALUES ('A100','北関東');

INSERT INTO customer_db.m_area (area_code,area_name)
    VALUES ('A200','東東京');

INSERT INTO customer_db.m_area (area_code,area_name)
    VALUES ('A300','西東京');

INSERT INTO customer_db.m_area (area_code,area_name)
    VALUES ('A400','南関東');

/*初期データをINSERT（ユーザマスタ）*/
INSERT INTO customer_db.m_user (user_id,password,user_name)
    VALUES ('1234','pass1','山田');

INSERT INTO customer_db.m_user (user_id,password,user_name)
    VALUES ('5678','pass2','田中');

INSERT INTO customer_db.m_user (user_id,password,user_name)
    VALUES ('91011','pass3','鈴木');

INSERT INTO customer_db.m_user (user_id,password,user_name)
    VALUES ('121314','pass4','伊藤');

/*初期データをINSERT（顧客マスタ）*/
INSERT INTO customer_db.m_customer (customer_name,customer_name_kana,postal_code,address
    ,area_code,contact_person_name,contact_person_name_kana,contact_person_tel,user_id)
    VALUES ('会社A','かいしやえー','1750082','東京都板橋区','A300','担当者A','たんんとうしやえー','08012345678','91011');

INSERT INTO customer_db.m_customer (customer_name,customer_name_kana,postal_code,address
    ,area_code,contact_person_name,contact_person_name_kana,contact_person_tel,user_id)
    VALUES ('会社B','かいしやびー','1540012','東京都世田谷区','A200','担当者B','たんとうしやびー','08056781234','5678');


/*追加システム*/
/*テーブル作成*/
CREATE TABLE customer_db.m_status(
    status_code CHAR(2) PRIMARY KEY,
    status_name VARCHAR(20) NOT NULL
);

CREATE TABLE customer_db.t_inquiry(
    inquiry_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    inquiry_datetime TIMESTAMP NOT NULL DEFAULT current_timestamp,
    inquiry_contents VARCHAR(200),
    reply_contents VARCHAR(400),
    status_code CHAR(2) NOT NULL DEFAULT '00',
    update_datetime TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);


/*外部キー制約付与*/
ALTER TABLE customer_db.t_inquiry ADD FOREIGN KEY (customer_id)
    REFERENCES customer_db.m_customer (customer_id);

ALTER TABLE customer_db.t_inquiry ADD FOREIGN KEY (status_code)
    REFERENCES customer_db.m_status (status_code);

/*初期データをINSERT（ステータスマスタ）*/
INSERT INTO customer_db.m_status (status_code,status_name)
    VALUES ('00','未対応');

INSERT INTO customer_db.m_status (status_code,status_name)
    VALUES ('50','確認依頼中');

INSERT INTO customer_db.m_status (status_code,status_name)
    VALUES ('99','対応完了');

/*初期データをINSERT（問合せテーブル）*/
INSERT INTO customer_db.t_inquiry (customer_id,inquiry_contents,reply_contents,status_code)
    VALUES ('1','   テスト１','テスト１','00');

INSERT INTO customer_db.t_inquiry (customer_id,inquiry_contents,reply_contents,status_code)
    VALUES ('2','   テスト２','テスト２','50');

