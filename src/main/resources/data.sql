INSERT INTO usuarios (username, nombre, apellido, direccion, email, password) VALUES ("miguelgalan97", "Luis", "Galán", "Villavicencio", "miguelgalan97@gmail.com", "12345")
INSERT INTO usuarios (username, nombre, apellido, direccion, email, password) VALUES ("anayiber96", "Anayiber", "Cañas", "Bogota", "anayiber@gmail.com", "12345")
INSERT INTO usuarios (username, nombre, apellido, direccion, email, password) VALUES ("coniecaro22", "Conie", "Villas", "Medellin", "coniecaro22@gmail.com", "12345")
INSERT INTO usuarios (username, nombre, apellido, direccion, email, password) VALUES ("gustavo23", "Gustavo", "Perez", "Bogota", "gustavo23@gmail.com", "12345")
INSERT INTO usuarios (username, nombre, apellido, direccion, email, password) VALUES ("cristian27", "Cristian", "Cuero", "Bogota", "cristian27@gmail.com", "12345")


INSERT INTO productos (nombre, precio) VALUES ("Laptop", 1500000)
INSERT INTO productos (nombre, precio) VALUES ("Audifonos", 50000)
INSERT INTO productos (nombre, precio) VALUES ("Tablet", 500000)
INSERT INTO productos (nombre, precio) VALUES ("PC de Mesa", 2500000)
INSERT INTO productos (nombre, precio) VALUES ("Smartphone", 750000)

INSERT INTO compras (comprador, fecha, total_compra) VALUES ("miguelgalan97", "13/03/2021", 3250000)
INSERT INTO compras (comprador, fecha, total_compra) VALUES ("anayiber96", "20/05/2021", 3200000)
INSERT INTO compras (comprador, fecha, total_compra) VALUES ("coniecaro22", "21/06/2021", 1000000)
INSERT INTO compras (comprador, fecha, total_compra) VALUES ("gustavo23", "22/07/2021", 500000)
INSERT INTO compras (comprador, fecha, total_compra) VALUES ("cristian27", "23/08/2021", 750000)

INSERT INTO detalle_compras (id_compra, producto, precio, cantidad, total) VALUES ("1", "Laptop", 1500000, 1, 1500000)
INSERT INTO detalle_compras (id_compra, producto, precio, cantidad, total) VALUES ("1", "Tablet", 500000, 2, 1000000)
INSERT INTO detalle_compras (id_compra, producto, precio, cantidad, total) VALUES ("1", "Smartphone", 750000, 1, 750000)
INSERT INTO detalle_compras (id_compra, producto, precio, cantidad, total) VALUES ("2", "Laptop", 1500000, 2, 3000000)
INSERT INTO detalle_compras (id_compra, producto, precio, cantidad, total) VALUES ("2", "Audifonos", 50000, 4, 200000)
