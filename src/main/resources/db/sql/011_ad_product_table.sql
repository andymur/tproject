BEGIN TRANSACTION;

CREATE TABLE "ad_products" (
  "id"          SERIAL           NOT NULL,
  "product_id"  BIGINT  NOT NULL,
  CONSTRAINT ad_product_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);

END TRANSACTION;
