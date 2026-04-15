create database sistemaventas_in5cm;
use sistemaventas_in5cm;
-- tabla usuarios
create table usuarios (
    codigo_usuario int primary key auto_increment,
    username varchar(45) not null,
    password varchar(45) not null,
    email varchar(60),
    rol varchar(45),
    estado int
);

-- tabla clientes
create table clientes (
    dpi_cliente int primary key,
    nombre_cliente varchar(50),
    apellido_cliente varchar(50),
    direccion varchar(100),
    estado int
);

-- tabla productos
create table productos (
    codigo_producto int primary key auto_increment,
    nombre_producto varchar(60),
    precio decimal(10,2),
    stock int,
    estado int
);

-- tabla ventas
create table ventas (
    codigo_venta int primary key auto_increment,
    fecha_venta date,
    total decimal(10,2),
    estado int,
    clientes_dpi_cliente int,
    usuarios_codigo_usuario int,

    constraint fk_ventas_clientes
        foreign key (clientes_dpi_cliente)
        references clientes(dpi_cliente)
        on delete cascade,

    constraint fk_ventas_usuarios
        foreign key (usuarios_codigo_usuario)
        references usuarios(codigo_usuario)
        on delete cascade
);

-- tabla detalleventa
create table detalleventa (
    codigo_detalle_venta int primary key auto_increment,
    cantidad int,
    precio_unitario decimal(10,2),
    subtotal decimal(10,2),
    productos_codigo_producto int,
    ventas_codigo_venta int,

    constraint fk_detalle_productos
        foreign key (productos_codigo_producto)
        references productos(codigo_producto)
        on delete cascade,

    constraint fk_detalle_ventas
        foreign key (ventas_codigo_venta)
        references ventas(codigo_venta)
        on delete cascade
);

-- procedimientos almacenados
delimiter //

create procedure sp_agregar_usuario(
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    insert into usuarios(username, password, email, rol, estado)
    values(p_username, p_password, p_email, p_rol, p_estado);
end //

create procedure sp_agregar_clientes(
    in p_dpi int,
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    insert into clientes(dpi_cliente, nombre_cliente, apellido_cliente, direccion, estado)
    values(p_dpi, p_nombre, p_apellido, p_direccion, p_estado);
end //

create procedure sp_agregar_productos(
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    insert into productos(nombre_producto, precio, stock, estado)
    values(p_nombre, p_precio, p_stock, p_estado);
end //

create procedure sp_agregar_venta(
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_dpi_cliente int,
    in p_codigo_usuario int
)
begin
    insert into ventas(fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario)
    values(p_fecha, p_total, p_estado, p_dpi_cliente, p_codigo_usuario);
end //

create procedure sp_agregar_detallev(
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    insert into detalleventa(cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
    values(p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end //

delimiter ;

-- usuarios
call sp_agregar_usuario('Andres', '123', 'ecallejas@gmail.com', 'administrador', 1);
call sp_agregar_usuario('jlopez', 'pass123', 'jlopez@mail.com', 'cliente', 1);
call sp_agregar_usuario('mperez', 'perez456', 'mperez@mail.com', 'cliente', 1);
call sp_agregar_usuario('cgarcia', 'garcia789', 'cgarcia@mail.com', 'cliente', 1);
call sp_agregar_usuario('test', 'test123', 'test@mail.com', 'cliente', 0);

-- clientes
call sp_agregar_clientes(12345678, 'Juan', 'Lopez', 'Zona 1', 1);
call sp_agregar_clientes(22345678, 'Maria', 'Perez', 'Zona 5', 1);
call sp_agregar_clientes(32345678, 'Carlos', 'Garcia', 'Zona 7', 1);
call sp_agregar_clientes(42345678, 'Ana', 'Sanchez', 'Zona 10', 1);
call sp_agregar_clientes(52345678, 'Pedro', 'Ramirez', 'Zona 3', 0);

-- productos
call sp_agregar_productos('Laptop Lenovo', 5500.00, 10, 1);
call sp_agregar_productos('Mouse Logitech', 120.00, 50, 1);
call sp_agregar_productos('Teclado Gaming', 250.00, 30, 1);
call sp_agregar_productos('Monitor HP', 1400.00, 15, 1);
call sp_agregar_productos('USB Kingston 32GB', 45.00, 100, 1);

-- ventas
call sp_agregar_venta('2024-01-10', 5620.00, 1, 12345678, 1);
call sp_agregar_venta('2024-01-12', 120.00, 1, 22345678, 2);
call sp_agregar_venta('2024-01-15', 250.00, 1, 32345678, 3);
call sp_agregar_venta('2024-01-20', 1400.00, 1, 42345678, 4);
call sp_agregar_venta('2024-01-22', 90.00, 1, 52345678, 2);

-- detalleventa
call sp_agregar_detallev(1, 5500.00, 5500.00, 1, 1);
call sp_agregar_detallev(1, 120.00, 120.00, 2, 2);
call sp_agregar_detallev(1, 250.00, 250.00, 3, 3);
call sp_agregar_detallev(1, 1400.00, 1400.00, 4, 4);
call sp_agregar_detallev(2, 45.00, 90.00, 5, 5);