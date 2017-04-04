BEGIN TRANSACTION;
CREATE TABLE "customer" (
  "id"           SERIAL NOT NULL,
  "first_name"   TEXT   NOT NULL,
  "last_name"    TEXT,
  "birth_date"   DATE,
  "email"        TEXT   NOT NULL,
  "phone_number" TEXT,
  "password"     TEXT   NOT NULL,
  "role_id"      BIGINT NOT NULL,
  "basket_id"    BIGINT,
  CONSTRAINT customer_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "address" (
  "id"          SERIAL NOT NULL,
  "customer_id" BIGINT NOT NULL,
  "country"     TEXT   NOT NULL,
  "city"        TEXT   NOT NULL,
  "street"      TEXT   NOT NULL,
  "building"    TEXT   NOT NULL,
  "apartment"   TEXT   NOT NULL,
  "zip_code"    BIGINT,
  CONSTRAINT address_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "order" (
  "id"                  SERIAL NOT NULL,
  "payment_status_id"   BIGINT NOT NULL,
  "delivery_address_id" BIGINT NOT NULL,
  "order_status_id"     BIGINT NOT NULL,
  "delivery_type_id"    BIGINT NOT NULL,
  "payment_type_id"     BIGINT NOT NULL,
  "customer_id"         BIGINT NOT NULL,
  "order_date"          DATE   NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "product" (
  "id"          SERIAL           NOT NULL,
  "brand_id"    BIGINT           NOT NULL,
  "model"       TEXT             NOT NULL,
  "color"       TEXT             NOT NULL,
  "name"        TEXT             NOT NULL,
  "description" TEXT,
  "price"       DOUBLE PRECISION NOT NULL,
  "quantity"    BIGINT           NOT NULL,
  "category_id" BIGINT           NOT NULL,
  "change_date" DATE             NOT NULL,
  CONSTRAINT product_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "ordered_product" (
  "id"         SERIAL NOT NULL,
  "order_id"   BIGINT NOT NULL,
  "product_id" BIGINT NOT NULL,
  "quantity"   BIGINT NOT NULL,
  CONSTRAINT ordered_product_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "category" (
  "id"             SERIAL NOT NULL,
  "name"           TEXT   NOT NULL,
  "category_image" TEXT,
  CONSTRAINT category_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "parameters" (
  "id"         SERIAL NOT NULL,
  "product_id" BIGINT NOT NULL,
  "size"       TEXT,
  "weight"     BIGINT,
  CONSTRAINT parameters_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "order_status" (
  "id"          SERIAL NOT NULL,
  "status_code" TEXT   NOT NULL,
  "description" TEXT,
  CONSTRAINT order_status_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "delivery_type" (
  "id"          SERIAL NOT NULL,
  "type_code"   TEXT   NOT NULL,
  "description" TEXT,
  CONSTRAINT delivery_type_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "payment_type" (
  "id"          SERIAL NOT NULL,
  "type_code"   TEXT   NOT NULL,
  "description" TEXT,
  CONSTRAINT payment_type_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "payment_status" (
  "id"          SERIAL NOT NULL,
  "status_code" TEXT   NOT NULL,
  "description" TEXT,
  CONSTRAINT payment_status_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "basket_product" (
  "id"         SERIAL NOT NULL,
  "product_id" BIGINT NOT NULL,
  "quantity"   BIGINT NOT NULL,
  CONSTRAINT basket_product_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "product_image" (
  "id"         SERIAL NOT NULL,
  "name"       TEXT   NOT NULL,
  "image"      TEXT,
  "product_id" BIGINT,
  CONSTRAINT product_image_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "role" (
  "id"   BIGINT NOT NULL,
  "name" TEXT   NOT NULL,
  CONSTRAINT role_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);
--
--
-- CREATE TABLE "product_category" (
--   "product_id"  BIGINT NOT NULL,
--   "category_id" BIGINT NOT NULL
-- ) WITH (
-- OIDS = FALSE
-- );


CREATE TABLE "brand" (
  "id"          SERIAL NOT NULL,
  "name"        TEXT   NOT NULL,
  "brand_image" TEXT,
  CONSTRAINT brand_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


ALTER TABLE "customer"
  ADD CONSTRAINT "customer_fk0" FOREIGN KEY ("role_id") REFERENCES "role" ("id");
ALTER TABLE "customer"
  ADD CONSTRAINT "customer_fk1" FOREIGN KEY ("basket_id") REFERENCES "basket_product" ("id");

ALTER TABLE "address"
  ADD CONSTRAINT "address_fk0" FOREIGN KEY ("customer_id") REFERENCES "customer" ("id");

ALTER TABLE "order"
  ADD CONSTRAINT "order_fk0" FOREIGN KEY ("delivery_address_id") REFERENCES "address" ("id");
ALTER TABLE "order"
  ADD CONSTRAINT "order_fk1" FOREIGN KEY ("order_status_id") REFERENCES "order_status" ("id");
ALTER TABLE "order"
  ADD CONSTRAINT "order_fk2" FOREIGN KEY ("delivery_type_id") REFERENCES "delivery_type" ("id");
ALTER TABLE "order"
  ADD CONSTRAINT "order_fk3" FOREIGN KEY ("payment_type_id") REFERENCES "payment_type" ("id");
ALTER TABLE "order"
  ADD CONSTRAINT "order_fk4" FOREIGN KEY ("customer_id") REFERENCES "customer" ("id");
ALTER TABLE "order"
  ADD CONSTRAINT "order_fk5" FOREIGN KEY ("payment_status_id") REFERENCES "payment_status" ("id");

ALTER TABLE "product"
  ADD CONSTRAINT "product_fk0" FOREIGN KEY (brand_id) REFERENCES "brand" ("id");
ALTER TABLE "product"
  ADD CONSTRAINT "product_fk1" FOREIGN KEY (category_id) REFERENCES "category" ("id");

ALTER TABLE "ordered_product"
  ADD CONSTRAINT "ordered_product_fk0" FOREIGN KEY ("order_id") REFERENCES "order" ("id");
ALTER TABLE "ordered_product"
  ADD CONSTRAINT "ordered_product_fk1" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "parameters"
  ADD CONSTRAINT "parameters_fk0" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "basket_product"
  ADD CONSTRAINT "basket_product_fk0" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

-- ALTER TABLE "product_category"
--   ADD CONSTRAINT "product_category_fk0" FOREIGN KEY ("product_id") REFERENCES "product" ("id");
-- ALTER TABLE "product_category"
--   ADD CONSTRAINT "product_category_fk1" FOREIGN KEY ("category_id") REFERENCES "category" ("id");

END TRANSACTION;
