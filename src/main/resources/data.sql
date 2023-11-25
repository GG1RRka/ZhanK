insert into teams values (1, 'Barcelona', 'Spain');
insert into teams values (2, 'Liverpool', 'England');
insert into teams values (3, 'Al Nassr', 'Saudi Arabia');
insert into teams values (4, 'Spartak', 'Russia');
insert into teams values (5, 'Kairat', 'Kazakhstan');
insert into players values(1, 'Lionel', 'Messi', 'Argentina');
insert into players values(2, 'Mohamed', 'Salah', 'Egypt');
insert into players values(3, 'Cristiano', 'Ronaldo', 'Portugal');
insert into players values(4, 'Denis', 'Glushakov', 'Russia');
insert into players values(5, 'Danil', 'Ustimenko', 'Kazakhstan');
insert into stadiums values(1, 'Almaty Central Stadium', 'Almaty', 'Kazakhstan');
insert into stadiums values(2, 'Beijing National Stadium', 'Beijing', 'China');
insert into stadiums values(3, 'Lusail Stadium', 'Lusail', 'Qatar');
insert into stadiums values(4, 'Luzhniki Stadium', 'Moscow', 'Russia');
insert into stadiums values(5, 'Stadio Olimpico', 'Rome', 'Italy');
insert into timeslots values(1, '13:00');
insert into timeslots values(2, '13:30');
insert into timeslots values(3, '16:00');
insert into timeslots values(4, '18:00');
insert into timeslots values(5, '19:45');
insert into matches values (1, 1, 2, 5, 1, '2023-01-15');
insert into matches values (2, 3, 4, 4, 3, '2023-01-18');
insert into matches values (3, 5, 1, 1, 2, '2023-01-20');
insert into matches values (4, 2, 3, 3, 4, '2023-01-22');
insert into matches values (5, 4, 5, 2, 5, '2023-01-25');
insert into results values (1, 3, 1, 1);
insert into results values (2, 2, 0, 3);
insert into results values (3, 1, 2, 5);
insert into results values (4, 0, 1, 3);
insert into results values (5, 2, 2, NULL);
insert into coaches values (1, 'Ronald', 'Koeman', 1, 'Netherlands');
insert into coaches values (2, 'Jurgen', 'Klopp', 2, 'Germany');
insert into coaches values (3, 'Rui', 'Vitoria', 3, 'Portugal');
insert into coaches values (4, 'Domenico', 'Tedesco', 4, 'Germany');
insert into coaches values (5, 'Aleksei', 'Shpilevski', 5, 'Kazakhstan');