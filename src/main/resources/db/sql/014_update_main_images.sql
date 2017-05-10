BEGIN TRANSACTION;

UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401206/dutchi_lafnss.jpg', product_id = 2 WHERE id = 2;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401208/pronto_gte6sf.jpg', product_id = 1 WHERE id = 1;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401206/gaston_ufppb6.jpg', product_id = 4 WHERE id = 4;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401207/libertine_j8zpau.jpg', product_id = 5 WHERE id = 5;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401205/avanti_apcwzp.jpg', product_id = 3 WHERE id = 3;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401206/brooks_flyer_kbihus.jpg', product_id = 12 WHERE id = 12;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401208/roadster_e36mmp.jpg', product_id = 6 WHERE id = 6;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401206/brooks_b67_jihmiy.jpg', product_id = 11 WHERE id = 11;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401207/nutcase_dots_hsqxm8.jpg', product_id = 10 WHERE id = 10;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401211/thousand_t8ulyv.jpg', product_id = 9 WHERE id = 9;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401207/mixte_b7rhtt.jpg', product_id = 7 WHERE id = 7;
UPDATE public.product_image SET name = 'main', image = 'http://res.cloudinary.com/alexpench/image/upload/v1494401209/scout_iga5wq.jpg', product_id = 8 WHERE id = 8;
commit;
END TRANSACTION;
