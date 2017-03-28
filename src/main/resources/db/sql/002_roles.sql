BEGIN TRANSACTION;
INSERT INTO role VALUES
  (1, 'user'),
  (2, 'admin');
commit;
END TRANSACTION;
