BEGIN TRANSACTION;
CREATE TABLE "app_user" (
  "id"           SERIAL       NOT NULL PRIMARY KEY,
  "sso_id"       VARCHAR(30)  NOT NULL UNIQUE,
  "first_name"   VARCHAR(30)  NOT NULL,
  "last_name"    VARCHAR(30)  NOT NULL,
  "birth_date"   DATE,
  "email"        VARCHAR(30)  NOT NULL,
  "phone_number" VARCHAR(30),
  "password"     VARCHAR(100) NOT NULL,
  "role_id"      BIGINT       NOT NULL,
  "basket_id"    BIGINT
) WITH (
OIDS = FALSE
);

CREATE TABLE "persistent_logins" (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) NOT NULL PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
) WITH (
OIDS = FALSE
);

CREATE TABLE "address" (
  "id"        SERIAL NOT NULL,
  "user_id"   BIGINT NOT NULL,
  "country"   VARCHAR(30)   NOT NULL,
  "city"      VARCHAR(30)   NOT NULL,
  "street"    VARCHAR(30)   NOT NULL,
  "building"  VARCHAR(30)   NOT NULL,
  "apartment" VARCHAR(30)   NOT NULL,
  "zip_code"  BIGINT,
  CONSTRAINT address_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "user_order" (
  "id"                  SERIAL    NOT NULL,
  "payment_status_id"   BIGINT    NOT NULL,
  "delivery_address_id" BIGINT    NOT NULL,
  "order_status_id"     BIGINT    NOT NULL,
  "delivery_type_id"    BIGINT    NOT NULL,
  "payment_type_id"     BIGINT    NOT NULL,
  "user_id"             BIGINT    NOT NULL,
  "order_date"          TIMESTAMP NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "product" (
  "id"          SERIAL           NOT NULL,
  "brand_id"    BIGINT           NOT NULL,
  "model"       VARCHAR(30)             NOT NULL,
  "color"       VARCHAR(30)             NOT NULL,
  "name"        VARCHAR(30)             NOT NULL,
  "description" VARCHAR(100),
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
  "name"           VARCHAR(30)   NOT NULL,
  "category_image" VARCHAR(30),
  CONSTRAINT category_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "parameters" (
  "id"         SERIAL NOT NULL,
  "product_id" BIGINT,
  "size"       VARCHAR(30),
  "weight"     BIGINT,
  CONSTRAINT parameters_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);

CREATE TABLE "basket_product" (
  "id"         SERIAL NOT NULL,
  "user_id"    BIGINT NOT NULL,
  "product_id" BIGINT,
  "quantity"   BIGINT,
  CONSTRAINT basket_product_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "product_image" (
  "id"         SERIAL NOT NULL,
  "name"       VARCHAR(30)   NOT NULL,
  "image"      VARCHAR(200),
  "product_id" BIGINT,
  CONSTRAINT product_image_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "role" (
  "id"   SERIAL NOT NULL PRIMARY KEY,
  "type" VARCHAR(30)   NOT NULL UNIQUE
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
  "name"        VARCHAR(30)   NOT NULL,
  "brand_image" VARCHAR(30),
  CONSTRAINT brand_pk PRIMARY KEY ("id")
) WITH (
OIDS = FALSE
);


ALTER TABLE "app_user"
  ADD CONSTRAINT "app_user_fk0" FOREIGN KEY ("role_id") REFERENCES "role" ("id");

ALTER TABLE "address"
  ADD CONSTRAINT "address_fk0" FOREIGN KEY ("user_id") REFERENCES "app_user" ("id");

ALTER TABLE user_order
  ADD CONSTRAINT "order_fk0" FOREIGN KEY ("delivery_address_id") REFERENCES "address" ("id");
ALTER TABLE user_order
  ADD CONSTRAINT "order_fk4" FOREIGN KEY ("user_id") REFERENCES "app_user" ("id");

ALTER TABLE "product"
  ADD CONSTRAINT "product_fk0" FOREIGN KEY (brand_id) REFERENCES "brand" ("id");
ALTER TABLE "product"
  ADD CONSTRAINT "product_fk1" FOREIGN KEY (category_id) REFERENCES "category" ("id");

ALTER TABLE "ordered_product"
  ADD CONSTRAINT "ordered_product_fk0" FOREIGN KEY ("order_id") REFERENCES user_order ("id");
ALTER TABLE "ordered_product"
  ADD CONSTRAINT "ordered_product_fk1" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "parameters"
  ADD CONSTRAINT "parameters_fk0" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "basket_product"
  ADD CONSTRAINT "basket_product_fk0" FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "basket_product"
  ADD CONSTRAINT "basket_product_fk1" FOREIGN KEY ("user_id") REFERENCES "app_user" ("id");

END TRANSACTION;
