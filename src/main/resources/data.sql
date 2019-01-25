insert into item(id, name, price, quick_description, full_description, url) VALUES
  (1, 'Pizza Margherita', 22.50, 'Włoska pizza na cienkim cieście z serem i sosem pomidorowym',
  'Pizza Margherita to klasyka włoskiej kuchni. W naszym wydaniu serwujemy pizzę na cienkim cieście z ' ||
   'ręcznie przygotowanym sosem pomidorowym i oryginalnym serem mozarella', '/img/wood-fired-pizzas-2645327_1920.jpg'),
  (2, 'Pizza Capriciosa', 25.99, 'Pizza na cienkim cieście z serem, sosem pomidorowym i pieczarkami',
  'Pizza Capriciosa to po Marghericie najpopularniejsza wersja tej smacznej włoskiej potrawy. Oprócz naszego ' ||
   'domowego sosu pomidorowego i oryginalnej włoskiej mozarelli znajdziesz tutaj także pieczarki i wyśmienitą sznkę.','/img/pizza-2810589_1920.jpg'),
  (3, 'Spaghetti Bolognese', 32.99, 'Robiona na miejscu pasta z sosem pomidorowym i wołowiną',
  'Idealna propozycja dla każdego miłośnika pasty. Spaghetti bolognese w naszym wykonaniu to ręcznie przygotowany ' ||
   'makaron z sosem pomidorowym oraz wysokiej jakości wołowiną. Do przygotowania sosu wykorzystujemy pomidory z ' ||
    'lokalnych upraw oraz świeże zioła.','/img/food-1932466_1920.jpg'),
  (4, 'Panna Cotta', 18.99, 'Klasyczny włoski deser o smaku śmietankowym z polewą z truskawek',
  'Masz ochodę na coś słodkiego? Ta propozycja to nasza interpretacja jednego z najbardziej rozpoznawalnych włoskich' ||
   'deserów. Przygotowujemy go ze śmietanki BIO, świeżego mleka i prawdziwej wanilii. Na życzenie deser podajemy ' ||
    'w alternatywnej wersji z sosem czekoladowym.', '/img/panna-cotta-2416749_1920.jpg');

insert into client_order(id, address, telephone_number, order_status) VALUES
  (1, 'Zakrzewskiego 23/5, 50-225 Warszawa', '888777666', 'ORDERED'),
  (2, 'Kościuszki 13, 52-316 Warszawa', '767454989', 'ORDERED'),
  (3, 'Krakowska 88/16, 51-515 Warszawa', '666234123', 'IN_PROGRESS'),
  (4, 'Centralna 8/12, 55-100 Warszawa', '598787999', 'IN_PROGRESS'),
  (5, 'Dworcowa 33, 51-200 Warszawa', '600700900', 'READY'),
  (6, 'Krucza 66/4, 53-300 Warszawa', '696787898', 'READY');

insert into order_item (order_id, item_id) values
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 3),
  (2, 4),
  (3, 1),
  (3, 1),
  (3, 1),
  (4, 1),
  (4, 2),
  (5, 3),
  (5, 3),
  (5, 4),
  (6, 4),
  (6, 4);