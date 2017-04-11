BEGIN TRANSACTION;

INSERT INTO ROLE (type)
VALUES ('USER');

INSERT INTO ROLE (type)
VALUES ('ADMIN');

INSERT INTO APP_USER (sso_id, password, first_name, last_name, email, role_id)
VALUES ('apenchukov', '$2a$10$u3qyeMU5s54UWNi29JfI0.YOB5LjzALyg9.YaXmITR3jhyIXgBLrm', 'Alexey', 'Penchukov',
        'alex.pench@gmail.com',
        (SELECT r.id
         FROM ROLE r
         WHERE r.type = 'ADMIN'));
END TRANSACTION;
