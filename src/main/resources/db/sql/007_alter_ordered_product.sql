BEGIN TRANSACTION;

ALTER TABLE ordered_product ADD size VARCHAR(30) NOT NULL DEFAULT (1);

END TRANSACTION;
