
ECF 2 JAVA /

---------------------Endpoints-----------------------------

Les EndPoints sont précisé en commentaires sur chaque route dans les controlleurs

il suffit de copier/coller dans Postman


---------------------Prérequis----------------------------


L'application est utilisé avec le JDK 17


---------------------Requêtes Sql------------------------

Quelques valeurs possibles à utiliser dans la BDD


INSERT INTO specie (common_name, scientific_name, category)
VALUES 
('Rouge-gorge', 'Erithacus rubecula', 'BIRD'),
('Hérisson', 'Erinaceus europaeus', 'MAMMAL'),
('Coccinelle', 'Coccinella septempunctata', 'INSECT'),
('Chêne', 'Quercus robur', 'PLANT');

INSERT INTO observation (observer_name, location, latitude, longitude, observation_date, specie_id, comment)
VALUES
('Alice', 'Paris', 48.8566, 2.3522, '2025-08-01', 1, 'Vu un rouge-gorge dans le parc'),
('Bob', 'Lyon', 45.7640, 4.8357, '2025-08-05', 2, 'Un hérisson trouvé dans le jardin'),
('Clara', 'Marseille', 43.2965, 5.3698, '2025-08-10', 3, 'Coccinelles sur les plantes');

INSERT INTO travellog (observation_id, distance_km, mode, estimated_co2_kg)
VALUES
(2, 20.0, 'TRAIN', 0.6),
(3, 5.0, 'BIKE', 0.0),
(4, 300.0, 'PLANE', 77.7);   