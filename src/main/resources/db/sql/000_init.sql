-- brands
INSERT INTO BRAND (name, brand_image)
VALUES ('LINUS','linus_brand.jpg');

INSERT INTO BRAND (name, brand_image)
VALUES ('HELMETS&CO','helmets_brand.jpg');

INSERT INTO BRAND (name, brand_image)
VALUES ('BROOKS','brooks_brand.jpg');

-- categories
INSERT INTO CATEGORY (name, category_image)
VALUES ('BICYCLE','bicycle_category.jpg');

INSERT INTO CATEGORY (name, category_image)
VALUES ('HELMETS','helmets_category.jpg');

INSERT INTO CATEGORY (name, category_image)
VALUES ('SADDLES','saddles_category.jpg');
-- products, params and main image
INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'PR01BL',
  'BLUE',
  'PRONTO CLASSIC',
  'OUR MOST PERfromANCE DRIVEN BIKE YET
  Well-suited for quick errands and longer commutes. Vittoria Randonneur tires complement the light-weight alloy frame while matte shades of indigo and black establish an air of understated class.',
  699,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','pronto.jpg',(select p.id from PRODUCT p where p.model = 'PR01BL'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'PR01BL'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'PR01BL'),'SMALL',13,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'PR01BL'),'LARGE',18,20);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'DUCH001Y',
  'YELLOW',
  'DUTCHI 3',
  'ELEGANT, FEMININE & INDEPENDENT
  The upright riding position makes it very comfortable for everyday use, and the low step-through frame allows for easy on and off. If there ever was a frame designed for trips to the flower market or picking up fresh baked bread, this is it.',
  599,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','dutchi.jpg',(select p.id from PRODUCT p where p.model = 'DUCH001Y'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'DUCH001Y'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'DUCH001Y'),'SMALL',13,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'DUCH001Y'),'LARGE',18,20);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'AVA002G',
  'GREEN',
  'AVANTI 2',
  'SPECIAL EDITION TWO-SPEED ROADSTER
  If you’ve dreamed of a multi-speed bike without the clutter of cables and shifters, this is your bike.',
  549,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','avanti.jpg',(select p.id from PRODUCT p where p.model = 'AVA002G'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'AVA002G'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'AVA002G'),'SMALL',13,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'AVA002G'),'LARGE',18,20);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'GAST003BL',
  'BLACK',
  'GASTON 3',
  'THE CAFÉ RACER
  Made from 4130 Chromoly for a stiffer, lighter frame and fork. The wrapped leather bar tape will age and patina beautifully with time, and the downtube shifter reduces handlebar clutter. Classy and sporty all in one bike.',
  549,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','gaston.jpg',(select p.id from PRODUCT p where p.model = 'GAST003BL'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'GAST003BL'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'GAST003BL'),'SMALL',13,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'GAST003BL'),'LARGE',18,20);


INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'LIB002MBL',
  'MIDNIGHT BLUE',
  'LIBERTINE 2',
  'THE CROSSTOWN COMMUTER
  The lighter double-butted Chromoly tubing adds stiffness and strength. We’ve tightened up the frame geometry for a more lively, responsive ride. A straighter handlebar and trigger shifters are ideal for negotiating traffic and climbing hills.',
  899,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','libertine.jpg',(select p.id from PRODUCT p where p.model = 'LIB002MBL'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'LIB002MBL'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'LIB002MBL'),'SMALL',13,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'LIB002MBL'),'LARGE',18,20);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'ROADSOL',
  'OLIVE',
  'ROADSTER SPORT',
  'THE ULTIMATE GENTLEMANS RIDE
  The Roadster was designed to be your go-to everyday bike. Internal gears make it extremely reliable and trouble-free. It’s your choice for quick rides to the market or work, and leisurely trips along the avenue.',
  599,
  80,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','roadster.jpg',(select p.id from PRODUCT p where p.model = 'ROADSOL'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'ROADSOL'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'ROADSOL'),'SMALL',13,40);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'MIX008S',
  'SAGE',
  'MIXTE 8',
  'A 60S FRENCH CLASSIC
  This sporty ride is a timeless classic with its signature diagonal line. The Mixte frame first appeared at the dawn of women’s lib, when stylish French women were racing alongside the men and arguing ideas with the same conviction.',
  829,
  80,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','mixte.jpg',(select p.id from PRODUCT p where p.model = 'MIX008S'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'MIX008S'),'MEDIUM',16,40);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'MIX008S'),'SMALL',13,40);


INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'LINUS'),
  'SC007MU',
  'MUSTARD',
  'SCOUT 7',
  'A BIKE FOR THE PEOPLE
  With an easy step-through frame and 7 speeds, the Scout Is the perfect bike to explore your world. It’s also a good bike for either a man or woman, which works great if you are sharing a bike for one household or you need an extra bike for guests.',
  489,
  100,
  (select c.id from CATEGORY c where c.name='BICYCLE'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','scout.jpg',(select p.id from PRODUCT p where p.model = 'SC007MU'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'SC007MU'),'MEDIUM',16,50);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'SC007MU'),'SMALL',13,50);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'HELMETS&CO'),
  'THUH001B',
  'BLACK',
  'Thousand Helmet',
  'VINTAGE MOTO MEETS MODERN MINIMAL
  Lightweight helmet with faux leather straps. For your 7am commutes, Sunday rides on the beach, and all the adventures in-between.',
  34,
  100,
  (select c.id from CATEGORY c where c.name='HELMETS'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','thousand.jpg',(select p.id from PRODUCT p where p.model = 'THUH001B'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'THUH001B'),'LARGE',1,50);

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'THUH001B'),'SMALL',1,50);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'HELMETS&CO'),
  'NUTLN01DT',
  'DOTS',
  'Nutcase - Little Nutty',
  'COMFORT AND SAFETY FOR YOUR LITTLE ONE
  Fits children ages 2 to 6, with heads 48cm - 52cm or 18.8" - 20.5" in diameter. Features Spin Dial Fit System to ensure a snug, comfortable fit, a soft, fabric chin strap, and the revolutionary Nutcase Fidlock Magnetic Buckle. 0.9 lbs.',
  60,
  100,
  (select c.id from CATEGORY c where c.name='HELMETS'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','nutcase_dots.jpg',(select p.id from PRODUCT p where p.model = 'NUTLN01DT'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'NUTLN01DT'),'ONE SIZE',1,100);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'BROOKS'),
  'B67',
  'ANTIQUE BROWN',
  'BROOKS B67',
  'CLASSICALLY SPRUNG FOR SUPREME COMFORT
  Mens specific leather saddle with steel frame. Ideal for daily city or touring use in a rather upright posture. Comfortable from day 1 thanks to softer leather. Made in England.',
  150,
  100,
  (select c.id from CATEGORY c where c.name='SADDLES'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','brooks_b67.jpg',(select p.id from PRODUCT p where p.model = 'B67'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'B67'),'ONE SIZE',1,100);

INSERT INTO PRODUCT (brand_id, model, color, name, description, price, quantity, category_id, change_date)
VALUES (
  (select b.id from BRAND b where b.name = 'BROOKS'),
  'BROOKSFL',
  'ANTIQUE BROWN',
  'BROOKS FLYER',
  'CLASSICALLY SPRUNG FOR SUPREME COMFORT
  Leather saddle with steel frame. Smooth leather top plus extra suspension granted by two rear springs. Made in England.',
  150,
  100,
  (select c.id from CATEGORY c where c.name='SADDLES'),
  current_timestamp
);

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('main','brooks_flyer.jpg',(select p.id from PRODUCT p where p.model = 'BROOKSFL'));

INSERT INTO PARAMETERS (product_id,size,weight,quantity)
VALUES(
  (select p.id from PRODUCT p where p.model = 'BROOKSFL'),'ONE SIZE',1,100);

-- front and back images
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','pronto_front.jpg',(select p.id from PRODUCT p where p.model = 'PR01BL'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','pronto_back.jpg',(select p.id from PRODUCT p where p.model = 'PR01BL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','dutchi_front.jpg',(select p.id from PRODUCT p where p.model = 'DUCH001Y'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','dutchi_back.jpg',(select p.id from PRODUCT p where p.model = 'DUCH001Y'));


INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','avanti_front.jpg',(select p.id from PRODUCT p where p.model = 'AVA002G'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','avanti_back.jpg',(select p.id from PRODUCT p where p.model = 'AVA002G'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','gaston_front.jpg',(select p.id from PRODUCT p where p.model = 'GAST003BL'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','gaston_back.jpg',(select p.id from PRODUCT p where p.model = 'GAST003BL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','libertine_front.jpg',(select p.id from PRODUCT p where p.model = 'LIB002MBL'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','libertine_back.jpg',(select p.id from PRODUCT p where p.model = 'LIB002MBL'));


INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','roadster_front.jpg',(select p.id from PRODUCT p where p.model = 'ROADSOL'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','roadster_back.jpg',(select p.id from PRODUCT p where p.model = 'ROADSOL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','mixte_front.jpg',(select p.id from PRODUCT p where p.model = 'MIX008S'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','mixte_back.jpg',(select p.id from PRODUCT p where p.model = 'MIX008S'));


INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','scout_front.jpg',(select p.id from PRODUCT p where p.model = 'SC007MU'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','scout_back.jpg',(select p.id from PRODUCT p where p.model = 'SC007MU'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','thousand_front.jpg',(select p.id from PRODUCT p where p.model = 'THUH001B'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','thousand_back.jpg',(select p.id from PRODUCT p where p.model = 'THUH001B'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','nutcase_dots_front.jpg',(select p.id from PRODUCT p where p.model = 'NUTLN01DT'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','nutcase_dots_back.jpg',(select p.id from PRODUCT p where p.model = 'NUTLN01DT'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','brooks_b67_front.jpg',(select p.id from PRODUCT p where p.model = 'B67'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','brooks_b67_back.jpg',(select p.id from PRODUCT p where p.model = 'B67'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('front','brooks_flyer_front.jpg',(select p.id from PRODUCT p where p.model = 'BROOKSFL'));
INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('back','brooks_flyer_back.jpg',(select p.id from PRODUCT p where p.model = 'BROOKSFL'));

-- icons

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','pronto_icon.jpg',(select p.id from PRODUCT p where p.model = 'PR01BL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','dutchi_icon.jpg',(select p.id from PRODUCT p where p.model = 'DUCH001Y'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','avanti_icon.jpg',(select p.id from PRODUCT p where p.model = 'AVA002G'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','gaston_icon.jpg',(select p.id from PRODUCT p where p.model = 'GAST003BL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','libertine_icon.jpg',(select p.id from PRODUCT p where p.model = 'LIB002MBL'));


INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','roadster_icon.jpg',(select p.id from PRODUCT p where p.model = 'ROADSOL'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','mixte_icon.jpg',(select p.id from PRODUCT p where p.model = 'MIX008S'));


INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','scout_icon.jpg',(select p.id from PRODUCT p where p.model = 'SC007MU'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','thousand_icon.jpg',(select p.id from PRODUCT p where p.model = 'THUH001B'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','nutcase_dots_icon.jpg',(select p.id from PRODUCT p where p.model = 'NUTLN01DT'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','brooks_b67_icon.jpg',(select p.id from PRODUCT p where p.model = 'B67'));

INSERT INTO PRODUCT_IMAGE (name, image, product_id)
VALUES('longpic','brooks_flyer_icon.jpg',(select p.id from PRODUCT p where p.model = 'BROOKSFL'));

commit;