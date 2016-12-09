
Create Database SistemaFarmacia
Go

Use SistemaFarmacia
Go


/*   ***TABLAS***    */

-----------------
-----------------


---8---
Create Table Empleado(
ID_Empleado int identity(1,1) primary key,
Area nvarchar (50) not null,
Nombres_Empleado nvarchar (50) not null,
Apellidos_Empleado nvarchar (50) not null,
Telefono_Empleado nvarchar (9) not null,
Cedula_Empleado nvarchar (16) not null,
Correo_Empleado nvarchar (100) Default 'No Ingresado' not null,
Direccion_Empleado nvarchar (100) not null,
Fotografia_Empleado nvarchar(max),
Estado_Empleado nvarchar (10) Default 'Activo' not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado_I int foreign key references Empleado (ID_Empleado),
Salario_Basico money not null,
Porcentaje_Comision decimal(5,2) not null,
Check(Estado_Empleado in ('Activo','Inactivo')) -- Area, Cargo, Comision
)
Go

Create Table Usuario
(
ID_Usuario int identity(1,1) primary key,
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Privilegio nvarchar (20)  not null,
Contrasena nvarchar (100) not null,
Estado_Usuario nvarchar (10) Default 'Activo' not null,
Nombre_Usuario nvarchar (50) not null, 
ID_Empleado_I int foreign key references Empleado (ID_Empleado),
Fecha_Ingreso datetime Default getdate() not null,
Check(Estado_Usuario in ('Activo','Inactivo')), 

)
Go

Create Table Categoria
(
ID_Categoria int identity(1,1) primary key,
Nombre_Categoria nvarchar (50) not null, 
Descripcion_Categoria nvarchar (150) not null,
Estado_Categoria nvarchar (10) Default 'Activo' not null,
ID_Empleado int foreign key references Empleado (ID_Empleado),
Fecha_Ingreso datetime Default getdate() not null,
Check(Estado_Categoria in ('Activo','Inactivo')), 
)
Go

---1---
Create Table Proveedor(
ID_Proveedor int identity(1,1) primary key,
Tipo_Proveedor nvarchar(20) not null,
Nombre_Proveedor nvarchar (50) not null,
No_RUC nvarchar(15) not null, 
Telefono_Proveedor nvarchar (9) not null,
Direccion_Proveedor nvarchar (150) Default 'No Ingresada' not null,
Correo_Proveedor nvarchar (50) Default 'No Ingresado' not null,
Estado_Proveedor nvarchar (10) Default 'Activo' not null,
Fotografia_Proveedor nvarchar(max) not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
Check(Estado_Proveedor in ('Activo','Inactivo')),
Check(Tipo_Proveedor in ('Laboratorio','Distribuidora'))
)
Go
-----------------
-----------------

---2---
Create Table Ejecutivo(
ID_Ejecutivo int identity(1,1) primary key,
Nombres_Ejecutivo nvarchar (50) not null,
Apellidos_Ejecutivo nvarchar (50) not null,
Telefono_Ejecutivo nvarchar (9) Default 'No Ingresado' not null,
Cedula_Ejecutivo nvarchar (16) not null,
Sexo_Ejecutivo nvarchar (10) not null,
ID_Proveedor int foreign key references Proveedor(ID_Proveedor) not null,
Correo_Ejecutivo nvarchar (50) Default 'No Ingresado' not null,
Direccion_Ejecutivo nvarchar (150) Default 'No Ingresada' not null,
Estado_Ejecutivo nvarchar (10) Default 'Activo' not null,
Desactivado_Directament nvarchar (5) Default 'No' not null,
Fotografia_Ejecutivo nvarchar(max)  not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
Check(Desactivado_Directament in ('Si','No')),
Check(Estado_Ejecutivo in ('Activo','Inactivo'))
)
Go
-----------------
-----------------

---3---
Create Table Producto (
ID_Producto int identity(1,1) primary key,
Nombre_Producto nvarchar (50) not null,
Codigo_Producto nvarchar(50) not null,
ID_Categoria int foreign key references Categoria(ID_Categoria) not null,
Contenido nvarchar (150) not null,
Controlado nvarchar (5) Default 'No' not null,
Unidades_Disponibles int not null,
Precio_Venta money not null,
Exclud_IVA nvarchar (2) not null,
Stock_Min int not null,
Tipo_Medicamento nvarchar (50) not null,
Presentacion nvarchar (50) not null,
UnidsXCaja int default 0 not null,
ID_Proveedor int foreign key references Proveedor(ID_Proveedor) not null,
ID_Laboratorio int foreign key references Proveedor(ID_Proveedor) not null,
Fotografia_Producto nvarchar(MAX),
Margen_Ganancia money not null,
Estado_Producto nvarchar (10) Default 'Activo' not null,
Desactivado_Directament nvarchar (5) Default 'No' not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
Fecha_Ingreso datetime Default getdate() not null,
Check(Desactivado_Directament in ('Si','No')),
Check(Exclud_IVA in ('Si','No')),
Check(Estado_Producto in ('Activo','Inactivo')),
Check(Controlado in ('Si','No')),
Check(Unidades_Disponibles >= 0),
Check(UnidsXCaja >= 0),
Check(Precio_venta >= 0),
Check(Stock_Min > 0),
Check(Margen_Ganancia > 0)
)
Go

-----------------
-----------------

Create Table ClienteJuridico(
ID_ClienteJuridico int identity(1,1) primary key,
Nombre_ClienteJuridico nvarchar (50) not null,
No_RUC nvarchar(15) not null, 
Descuento_ClienteJuridico decimal(5,2),
Telefono_ClienteJuridico nvarchar (9) not null,
Direccion_ClienteJuridico nvarchar (150) Default 'No Ingresada' not null,
Correo_ClienteJuridico nvarchar (50) Default 'No Ingresado' not null,
Estado_ClienteJuridico nvarchar (10) Default 'Activo' not null,
Fotografia_ClienteJuridico nvarchar(max) not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
Check(Estado_ClienteJuridico in ('Activo','Inactivo'))
)
Go

-----------------
-----------------

---7---
Create Table Cliente(
ID_Cliente int identity(1,1) primary key,
ID_ClienteJuridico int foreign key references ClienteJuridico (ID_ClienteJuridico),
Representante nvarchar(2) not null,
Nombres_Cliente nvarchar (50) not null,
Apellidos_Cliente nvarchar (50) not null,
Telefono_Cliente nvarchar (9) Default 'No Ingresado' not null,
Cedula_Cliente nvarchar (16) not null,
Sexo_Cliente nvarchar (10) not null,
Descuento_Cliente decimal(5,2),
Correo_Cliente nvarchar (50) Default 'No Ingresado' not null,
Direccion_Cliente nvarchar (150) Default 'No Ingresada' not null,
Estado_Cliente nvarchar (10) Default 'Activo' not null,
Fotografia_Cliente nvarchar(max)  not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
Desactivado_Directament nvarchar (5) Default 'No' not null,
Check(Desactivado_Directament in ('Si','No')),
Check(Estado_Cliente in ('Activo','Inactivo'))
)
Go



---10---
Create Table Tipo_Cambio(
ID_Tipo_Cambio int identity(1,1) primary key,
Tipo_Cambio money not null,
Cambio_BCN nvarchar (2) default 'No' not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_Empleado int foreign key references Empleado (ID_Empleado) not null,
)
Go
-----------------
-----------------

Create Table IP_Puerto(
ID_IP_Puerto int identity(1,1) primary key,
IP nvarchar(50) not null,
Puerto int not null,
Fecha_Ingreso datetime Default getdate() not null
)
Go

---4---
Create Table Compra(
ID_Compra int identity(1,1) primary key,
No_Factura nvarchar(50) not null,
ID_Proveedor int foreign key references Proveedor(ID_Proveedor) not null,
ID_Ejecutivo int foreign key references Ejecutivo(ID_Ejecutivo) not null, --DUDA DEBERÍA IR O NO? XQ EJECUTIVO YA TIENE LA RELACIÓN CON EL PROVEE
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Fecha_Compra date not null, --DUDA USAR DATE O DATETIME, U OTRO DATO FECHA??? FORMATO DATE= YYYY-MM-DD
Fecha_Pago date not null,
--UnidsTotales_Compradas int not null,
--TotalComprado money not null,
--Moneda nvarchar (10) Default 'Córdobas' not null,
--ID_TipoCambio int foreign key references TipoCambio(ID_TipoCambio) not null,
ModoCompra nvarchar (10) Default 'Efectivo' not null, -- o Crédito
Tiempo_Pago int not null,
Fecha_Ingreso datetime Default getdate() not null,
Compra_Cancelada nvarchar(10) default 'Cancelada' not null,
Estado_Compra nvarchar(10) default 'Activo' not null,
Check(Estado_Compra in ('Activo','Anulada')),
Check(Compra_Cancelada in ('Cancelada','Pendiente'))
--Check(Moneda in ('Córdobas','Dólares'))
)
Go
-----------------
-----------------

---5---
Create Table DetalleCompra(
ID_DetalleCompra int identity(1,1) primary key,
ID_Compra int foreign key references Compra(ID_Compra) not null,
ID_Producto int foreign key references Producto(ID_Producto) not null,
Fecha_Vencimiento date not null,
Unidades_Compradas int not null,
Costo_Compra money not null,
Descuento decimal (5,2) Default 0 not null,
DescuentoMonetario money not null,
ModoAdquisicion nvarchar (20) Default 'Normal' not null, -- Bonificacion
Incluye_IVA nvarchar(2) not null,
Permite_Devolucion nvarchar(2) not null,
Porcentaje_Devolucion int not null,
Incluye_Vineta nvarchar(2) not null,
Cantidad_Vineta money not null,
UnidsEnInventario int not null,
Estado_DetCompra nvarchar(10) default 'Activo' not null,
Check(Estado_DetCompra in ('Activo','Inactivo')),
check(Incluye_IVA in ('Si','No')),
check(Incluye_Vineta in ('Si','No')),
check(Permite_Devolucion in ('Si','No')),
Check(Cantidad_Vineta >= 0),
Check(UnidsEnInventario >= 0),
Check(Unidades_Compradas > 0),
-- Check(Costo_Compra > 0),
Check(Descuento >= 0)
)
Go
-----------------
-----------------

---6---
Create Table DevolucionCompra(
ID_DevolucionCompra int identity(1,1) primary key,
ID_DetalleCompra int foreign key references DetalleCompra(ID_DetalleCompra) not null,
Fecha_Devolucion date not null,
ID_Producto int foreign key references Producto(ID_Producto) not null,
Unidades_Devueltas int not null,
Costo_Devolucion money not null, --DUDA DEBERÍA HABER UN CAMPO CON COSTO DE DEVOLUCIÓN? XQ PODRÍA DEVOLVERSE CON UN VALOR MENOR AL COMPRADO 
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Fecha_Ingreso datetime Default getdate() not null,
Estado_DevCompra nvarchar(10) default 'Activo' not null,
Check(Estado_DevCompra in ('Activo','Inactivo')),
Check(Unidades_Devueltas > 0),
Check(Costo_Devolucion > 0)
)
Go

-----------------
-----------------



---11---
Create Table Venta(
ID_Venta int identity(1,1) primary key,
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Nombre_Cliente nvarchar (50) not null, -- DUDA VALOR PODRÍA SER NULO? LUGARES NO PIDEN NOMBRE DE CLIENTE
ID_Cliente int foreign key references Cliente(ID_Cliente) not null, -- ES NECEARIO TENER UNA TABLA CLIENTE???
Fecha_Venta date default getdate() not null,
Descuento decimal (5,2) Default 0 not null, --DESCUENTO ES POR VENTA TOTAL NO POR PRODUCTO, DESCUENTO NO MAYOR DE 99.99% X ESO ES SOLO (2,2)
ID_Tipo_Cambio int foreign key references Tipo_Cambio(ID_Tipo_Cambio) not null,
Tipo_Factura nvarchar (10) default 'Contado' not null,
ADomiciolio nvarchar(2) Default 'No' not null,
ID_Repartidor int foreign key references Empleado(ID_Empleado),
Fecha_Ingreso datetime Default getdate() not null,
ID_EmpleadoI int foreign key references Empleado(ID_Empleado) not null,
Cancelada nvarchar(10) default 'Cancelada' not null,
Estado_Venta nvarchar(10) default 'Activo' not null,
Check(Descuento >= 0),
Check(Cancelada in ('Cancelada','Pendiente'))
)
Go
-----------------
-----------------



---12---
Create Table DetalleVenta(
ID_DetalleVenta int identity(1,1) primary key,
ID_Venta int foreign key references Venta(ID_Venta) not null,
ID_Producto int foreign key references Producto(ID_Producto) not null,
Unidades_Vendidas int not null,
Presentacion nvarchar(50) not null,
Precio_Venta money not null, 
Check(Unidades_Vendidas > 0),
Check(Precio_Venta > 0)
)
Go
-----------------
-----------------



---11---
Create Table Proforma(
ID_Proforma int identity(1,1) primary key,
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Nombre_Cliente nvarchar (50) not null, -- DUDA VALOR PODRÍA SER NULO? LUGARES NO PIDEN NOMBRE DE CLIENTE
ID_Cliente int foreign key references Cliente(ID_Cliente) not null, -- ES NECEARIO TENER UNA TABLA CLIENTE???
Fecha_Proforma date default getdate() not null,
Descuento decimal (5,2) Default 0 not null, --DESCUENTO ES POR VENTA TOTAL NO POR PRODUCTO, DESCUENTO NO MAYOR DE 99.99% X ESO ES SOLO (2,2)
ID_Tipo_Cambio int foreign key references Tipo_Cambio(ID_Tipo_Cambio) not null,
Tipo_Factura nvarchar (10) default 'Contado' not null,
ADomiciolio nvarchar(2) Default 'No' not null,
ID_Repartidor int foreign key references Empleado(ID_Empleado),
Fecha_Ingreso datetime Default getdate() not null,
ID_EmpleadoI int foreign key references Empleado(ID_Empleado) not null,
Estado_Profrma nvarchar(10) default 'Activo' not null
)
Go
-----------------
-----------------


---12---
Create Table DetalleProforma(
ID_DetalleProforma int identity(1,1) primary key,
ID_Proforma int foreign key references Proforma(ID_Proforma) not null,
ID_Producto int foreign key references Producto(ID_Producto) not null,
Unidades_Vendidas int not null,
Presentacion nvarchar(50) not null,
Precio_Venta money not null, 

)
Go

---11---
Create Table Facturacion(
ID_Facturacion int identity(1,1) primary key,
ID_Cajero int foreign key references Empleado(ID_Empleado) not null,
ID_Venta int foreign key references Venta(ID_Venta) not null,
Moneda nvarchar (10)  not null,
ModoVenta nvarchar (10) Default 'Efectivo' not null,
Recibido money not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_EmpleadoI int foreign key references Empleado(ID_Empleado) not null,
Estado_Facturacion nvarchar(10) default 'Activo' not null
)
Go

Create Table Pago_TarjetaCredito(
ID_TarjetaCredito int identity(1,1) primary key,
ID_Facturacion int foreign key references Facturacion(ID_Facturacion) not null,
NombreCliente nvarchar(50) not null,
No_Cedula nvarchar(16) not null,
Monto money not null,
Tipo_Tarjeta nvarchar(50) not null,
Numero_Tarjeta nvarchar(50) not null,
Fecha_Expiracion date not null,
Fecha_Ingreso datetime Default getdate() not null,
ID_EmpleadoI int foreign key references Empleado(ID_Empleado) not null,
Estado_Pago nvarchar(10) default 'Activo' not null
)
Go

Create Table CuentaCobrar(
ID_CuentaCobrar int identity(1,1) primary key,
ID_Cliente int foreign key references Cliente (ID_Cliente) not null,
ID_Venta int foreign key references Venta (ID_Venta) not null, 
Mora money not null,
Saldo money not null,
Fecha_Cancelación date not null,
Fecha_Limite date not null,
Estado_CuentaCobrar nvarchar (10) default 'Activo' not null,
Check(Estado_CuentaCobrar in ('Activo','Inactivo'))
)
Go

Create Table Abono_CuentaCobrar(
ID_Abono_CuentaCobrar int identity(1,1) primary key,
ID_CuentaCobrar int foreign key references CuentaCobrar (ID_CuentaCobrar) not null,
Fecha_Abono datetime default getdate() not null,
Abono money not null,
Saldo money not null,
Estado_AbonoCuentaCobrar nvarchar (10) default 'Activo' not null,
Check(Estado_AbonoCuentaCobrar in ('Activo','Inactivo'))
)
Go

---13---
Create Table InventarioInactivo(
ID_InventarioInactivo int identity(1,1) primary key,
ID_DetalleCompra int foreign key references DetalleCompra(ID_DetalleCompra) not null,
Justificacion nvarchar(150) not null,
Fecha_Inactiva Date default getdate() not null,
Unidades_Inactivas int not null,
Costo_Unit money not null, 
ID_Empleado int foreign key references Empleado(ID_Empleado) not null,
Fecha_Ingreso datetime Default getdate() not null,
Check(Unidades_Inactivas > 0),
Check(Costo_Unit > 0)
)
Go


-----------------
-----------------
Create Table OrdenFacturar(
ID_OrdenFacturar int identity(1,1) primary key,
ID_Venta int foreign key references Venta(ID_Venta) not null,
SubTotal money not null,
IVA money not null,
Descuento nvarchar(10) not null,
Total money not null
)
Go

Create Table DetallesOrden(
ID_DetalleOrden int identity(1,1) primary key,
ID_Venta int foreign key references Venta(ID_Venta) not null,
Unids int not null,
Producto nvarchar(100) not null,
PrecioV money not null,
Total money not null,
Individual nvarchar(20) not null
)
Go
-----------------
-----------------

---FUNCION ESCALAR ----
CREATE  FUNCTION convertir_uai(@entrada NVARCHAR(max)) RETURNS NVARCHAR(max) 
BEGIN 
    DECLARE @salida NVARCHAR(max); 
        SET @salida = REPLACE(@entrada , 'Ã¡', 'á'); 
        SET @salida = REPLACE(@salida , 'Ã©', 'é'); 
        SET @salida = REPLACE(@salida , 'Ã*', 'í'); 
        SET @salida = REPLACE(@salida , 'Ã³', 'ó'); 
        SET @salida = REPLACE(@salida , 'Ãº', 'ú'); 
        SET @salida = REPLACE(@salida , 'Ã ', 'à'); 
        SET @salida = REPLACE(@salida , 'Ã¨', 'è'); 
        SET @salida = REPLACE(@salida , 'Ã¬', 'ì'); 
        SET @salida = REPLACE(@salida , 'Ã²', 'ò'); 
        SET @salida = REPLACE(@salida , 'Ã¹', 'ù'); 
        SET @salida = REPLACE(@salida , 'Ã¤', 'ä'); 
        SET @salida = REPLACE(@salida , 'Ã«', 'ë'); 
        SET @salida = REPLACE(@salida , 'Ã¯', 'ï'); 
        SET @salida = REPLACE(@salida , 'Ã¶', 'ö'); 
        SET @salida = REPLACE(@salida , 'Ã¼', 'ü'); 
        SET @salida = REPLACE(@salida , 'Ã', 'Á'); 
        SET @salida = REPLACE(@salida , 'Ã‰', 'É'); 
        SET @salida = REPLACE(@salida , 'Ã', 'Í'); 
        SET @salida = REPLACE(@salida , 'Ã“', 'Ó'); 
        SET @salida = REPLACE(@salida , 'Ãš', 'Ú'); 
        SET @salida = REPLACE(@salida , 'Ã‘', 'Ñ'); 
        SET @salida = REPLACE(@salida , 'Ã€', 'À'); 
        SET @salida = REPLACE(@salida , 'Ãˆ', 'È'); 
        SET @salida = REPLACE(@salida , 'ÃŒ', 'Ì'); 
        SET @salida = REPLACE(@salida , 'Ã’', 'Ò'); 
        SET @salida = REPLACE(@salida , 'Ã™', 'Ù'); 
        SET @salida = REPLACE(@salida , 'Ã‘', 'Ñ'); 
        SET @salida = REPLACE(@salida , 'Ã„', 'Ä'); 
        SET @salida = REPLACE(@salida , 'Ã‹', 'Ë'); 
        SET @salida = REPLACE(@salida , 'Ã', 'Ï'); 
        SET @salida = REPLACE(@salida, 'Ã–', 'Ö'); 
        SET @salida = REPLACE(@salida , 'Ãœ', 'Ü'); 
    RETURN @salida; 
END

GO 

/*   ***PROCEDIMIENTOS ALMACENADOS***   */


---13---
Create Procedure Agregar_Empleado(
@Nombres_Empleado nvarchar (50),
@Apellidos_Empleado nvarchar (50),
@Telefono_Empleado nvarchar (9),
@Cedula_Empleado nvarchar (16),
@Correo_Empleado nvarchar (100),
@Direccion_Empleado nvarchar (100),
@Foto nvarchar(max),
@ID_Empleado int,
@Salario_Basico money,
@Comision decimal(5,2),
@Area nvarchar(50)
)

As
Begin

Begin try

If not exists (Select [Cedula_Empleado] from [dbo].[Empleado] where [Cedula_Empleado] = @Cedula_Empleado) 

Begin

Insert Into [dbo].[Empleado]
           ([Nombres_Empleado],
		   [Apellidos_Empleado],
		   [Telefono_Empleado],
		   [Cedula_Empleado],
		   [Correo_Empleado],
		   [Direccion_Empleado],
		   [Fotografia_Empleado],
		   [ID_Empleado_I],
		   [Salario_Basico],
		   [Porcentaje_Comision],
		   [Area]
           )

     Values
           (@Nombres_Empleado, @Apellidos_Empleado, @Telefono_Empleado, @Cedula_Empleado, @Correo_Empleado, @Direccion_Empleado,
		   @Foto, @ID_Empleado, @Salario_Basico, @Comision, @Area)


End

End try

Begin catch
Raiserror('ERROR AL INSERTAR EMPLEADO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

---14---
Create Procedure Activar_Empleado(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Empleado] Where ([Estado_Empleado] = 'Inactivo' And [ID_Empleado] = @ID))
Begin

Update [dbo].[Empleado]
Set [Estado_Empleado] = 'Activo'
Where [ID_Empleado] = @ID

End

End try

Begin catch
Raiserror('ERROR AL ACTIVAR EMPLEADO',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---15---
Create Procedure Desactivar_Empleado(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Empleado] Where ([Estado_Empleado] = 'Activo' And [ID_Empleado] = @ID))
Begin

Update [dbo].[Empleado]
Set [Estado_Empleado] = 'Inactivo'
Where [ID_Empleado] = @ID

End

End try

Begin catch
Raiserror('ERROR AL DESACTIVAR EMPLEADO',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---16---
Create Procedure Actualizar_Empleado(
@ID int,
@Nombres_Empleado nvarchar (50),
@Apellidos_Empleado nvarchar (50),
@Telefono_Empleado nvarchar (9),
@Cedula_Empleado nvarchar (16),
@Correo_Empleado nvarchar (100),
@Direccion_Empleado nvarchar (100),
@Foto nvarchar(max),
@ID_Empleado int,
@Salario_Basico money,
@Comision decimal(5,2),
@Area nvarchar(50)
)

As
Begin

Begin try

If not exists (Select [Cedula_Empleado] from [dbo].[Empleado] 
where [Cedula_Empleado] = @Cedula_Empleado and [ID_Empleado] != @ID) 

Begin

Update [dbo].[Empleado]
   Set [Nombres_Empleado] = @Nombres_Empleado,
	   [Apellidos_Empleado] = @Apellidos_Empleado,
	   [Telefono_Empleado] = @Telefono_Empleado,
	   [Cedula_Empleado] = @Cedula_Empleado,
	   [Correo_Empleado] = @Correo_Empleado,
	   [Direccion_Empleado] = @Direccion_Empleado,
	   [Fotografia_Empleado] = @Foto,
	   [ID_Empleado_I] = @ID_Empleado,
	   [Salario_Basico] = @Salario_Basico,
	   [Porcentaje_Comision] = @Comision,
	   [Area] = @Area

 Where([ID_Empleado] = @ID)


End

End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR EMPLEADO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------

---17---







---1---
Create Procedure Agregar_Proveedor(

@Nombre_Proveedor nvarchar (50),
@No_RUC nvarchar(15),
@Telefono_Proveedor nvarchar (9), 
@Tipo_Proveedor nvarchar(20),
@Correo_Proveedor nvarchar (50),
@Direccion_Proveedor nvarchar (150),
@Foto_Proveedor nvarchar (max),
@ID_Empleado int
)

As
Begin

Begin try

if not exists (Select [Nombre_Proveedor] from [dbo].[Proveedor] where [Nombre_Proveedor] = @Nombre_Proveedor)
if not exists (Select [No_RUC] from [dbo].[Proveedor] where [No_RUC] = @No_RUC)

Begin
Begin


Insert Into [dbo].[Proveedor]
           (
           [Tipo_Proveedor],
		   [Nombre_Proveedor],
		   [No_RUC],
		   [Telefono_Proveedor],
		   [Direccion_Proveedor],
		   [Correo_Proveedor],
		   [Fotografia_Proveedor],
		   [ID_Empleado]
		   )

     Values
           (@Tipo_Proveedor, @Nombre_Proveedor, @No_RUC, @Telefono_Proveedor, @Direccion_Proveedor, @Correo_Proveedor,
		   @Foto_Proveedor, @ID_Empleado)

End
End


End try

Begin catch
Raiserror('ERROR AL INSERTAR PROVEEDOR',10,1)
Rollback Tran

End catch


End

Go
--------------
--------------

---2---
Create Procedure Activar_Proveedor(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Proveedor] Where ([Estado_Proveedor] = 'Inactivo' And [ID_Proveedor] = @ID))
Begin

Update [dbo].[Proveedor]
Set [Estado_Proveedor] = 'Activo'
Where [ID_Proveedor] = @ID

End

End try

Begin catch
Raiserror('ERROR AL ACTIVAR PROVEEDOR',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---3---
Create Procedure Desactivar_Proveedor(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Proveedor] Where ([Estado_Proveedor] = 'Activo' And [ID_Proveedor] = @ID))
Begin 

Update [dbo].[Proveedor]
Set [Estado_Proveedor] = 'Inactivo'
Where [ID_Proveedor] = @ID

End


End try

Begin catch
Raiserror('ERROR AL DESACTIVAR PROVEEDOR',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---4---
Create Procedure Actualizar_Proveedor(
@ID int,
@Nombre_Proveedor nvarchar (50),
@No_RUC nvarchar(15),
@Telefono_Proveedor nvarchar (9), 
@Tipo_Proveedor nvarchar(20),
@Correo_Proveedor nvarchar (50),
@Direccion_Proveedor nvarchar (150),
@Foto_Proveedor nvarchar (max),
@ID_Empleado int
)

As
Begin

Begin try

if not exists (Select [Nombre_Proveedor] from [dbo].[Proveedor]
where [Nombre_Proveedor] = @Nombre_Proveedor and [ID_Proveedor] != @ID)
if not exists (Select [No_RUC] from [dbo].[Proveedor] 
where [No_RUC] = @No_RUC and [ID_Proveedor] != @ID)

Begin
Begin
Update [dbo].[Proveedor]
   Set [Tipo_Proveedor]=@Tipo_Proveedor,
	   [Nombre_Proveedor]=@Nombre_Proveedor,
	   [No_RUC]=@No_RUC,
	   [Telefono_Proveedor]=@Telefono_Proveedor,
	   [Direccion_Proveedor]=@Direccion_Proveedor,
	   [Correo_Proveedor]=@Correo_Proveedor,
	   [Fotografia_Proveedor] = @Foto_Proveedor,
	   [ID_Empleado] = @ID_Empleado
 Where ([ID_Proveedor] = @ID)

End
End


End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR PROVEEDOR',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------



Create Procedure Agregar_Categoria(
@Nombre_Categoria nvarchar (50),
@Descripcion_Categoria nvarchar (150),
@ID_Empleado int
)

As
Begin

Begin try

if not exists (Select [Nombre_Categoria] from [dbo].[Categoria] where [Nombre_Categoria] = @Nombre_Categoria)

Begin


Insert Into [dbo].[Categoria]
           (
		   [Nombre_Categoria],
		   [Descripcion_Categoria],
		   [ID_Empleado]
		   )

     Values
           (@Nombre_Categoria, @Descripcion_Categoria, @ID_Empleado)

End



End try

Begin catch
Raiserror('ERROR AL INSERTAR CATEGORIA',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

---2---
Create Procedure Activar_Categoria(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Categoria] Where ([Estado_Categoria] = 'Inactivo' And [ID_Categoria] = @ID))
Begin

Update [dbo].[Categoria]
Set [Estado_Categoria] = 'Activo'
Where [ID_Categoria] = @ID

End

End try

Begin catch
Raiserror('ERROR AL ACTIVAR CATEGORIA',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---3---
Create Procedure Desactivar_Categoria(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Categoria] Where ([Estado_Categoria] = 'Activo' And [ID_Categoria] = @ID))
Begin 

Update [dbo].[Categoria]
Set [Estado_Categoria] = 'Inactivo'
Where [ID_Categoria] = @ID

End


End try

Begin catch
Raiserror('ERROR AL DESACTIVAR CATEGORIA',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---4---
Create Procedure Actualizar_Categoria(
@ID int,
@Nombre_Categoria nvarchar (50),
@Descripcion_Categoria nvarchar (150),
@ID_Empleado int
)

As
Begin

Begin try

if not exists (Select [Nombre_Categoria] from [dbo].[Categoria]
where [Nombre_Categoria] = @Nombre_Categoria and [ID_Categoria] != @ID)

Begin
Update [dbo].[Categoria]
   Set [Nombre_Categoria]=@Nombre_Categoria,
	   [Descripcion_Categoria]=@Descripcion_Categoria,
	   [ID_Empleado] = @ID_Empleado
 Where ([ID_Categoria] = @ID)

End



End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR CATEGORIA',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------


---5---
Create Procedure Agregar_Ejecutivo(
@Nombres_Ejecutivo nvarchar (50),
@Apellidos_Ejecutivo nvarchar (50),
@Telefono_Ejecutivo nvarchar (9),
@Cedula_Ejecutivo nvarchar (16),
@ID_Proveedor int,
@Correo_Ejecutivo nvarchar (50),
@Direccion_Ejecutivo nvarchar (150),
@Sexo_Ejecutivo nvarchar (10), 
@Foto nvarchar (max),
@ID_Empleado int
)

As
Begin

Begin try

If not exists (Select [Cedula_Ejecutivo] from [dbo].[Ejecutivo] where [Cedula_Ejecutivo] = @Cedula_Ejecutivo)

Begin



Insert Into [dbo].[Ejecutivo]
           ([Nombres_Ejecutivo],
		   [Apellidos_Ejecutivo],
		   [Telefono_Ejecutivo],
		   [Cedula_Ejecutivo],
		   [ID_Proveedor],
		   [Correo_Ejecutivo],
		   [Sexo_Ejecutivo],
		   [Direccion_Ejecutivo],
		   [Fotografia_Ejecutivo],
		   [ID_Empleado]
           )

     Values
           (@Nombres_Ejecutivo, @Apellidos_Ejecutivo, @Telefono_Ejecutivo, @Cedula_Ejecutivo, @ID_Proveedor, @Correo_Ejecutivo,
		   @Sexo_Ejecutivo, @Direccion_Ejecutivo, @Foto, @ID_Empleado)

End

End try

Begin catch
Raiserror('ERROR AL INSERTAR EJECUTIVO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

---6---
Create Procedure Activar_Ejecutivo(@ID int)

As
Begin

Begin try

Declare @Desac_Direct Nvarchar(2)
Set @Desac_Direct = (Select Desactivado_Directament from Ejecutivo where ID_Ejecutivo = @ID)

if(@Desac_Direct = 'Si')
Begin

If exists (Select * From [dbo].[Ejecutivo] Where ([Estado_Ejecutivo] = 'Inactivo' And [ID_Ejecutivo] = @ID))
Begin

Update [dbo].[Ejecutivo]
Set [Estado_Ejecutivo] = 'Activo',
    [Desactivado_Directament] = 'No'
Where [ID_Ejecutivo] = @ID

End
End
End try

Begin catch
Raiserror('ERROR AL ACTIVAR EJECUTIVO',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---7---
Create Procedure Desactivar_Ejecutivo(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Ejecutivo] Where ([Estado_Ejecutivo] = 'Activo' And [ID_Ejecutivo] = @ID))
Begin 

Update [dbo].[Ejecutivo]
Set [Estado_Ejecutivo] = 'Inactivo',
    [Desactivado_Directament] = 'Si'
Where [ID_Ejecutivo] = @ID

End


End try

Begin catch
Raiserror('ERROR AL DESACTIVAR EJECUTIVO',10,1)
Rollback Tran
End catch

End

Go





-----------------
----------------

---8---
Create Procedure Actualizar_Ejecutivo(
@ID int,
@Nombres_Ejecutivo nvarchar (50),
@Apellidos_Ejecutivo nvarchar (50),
@Telefono_Ejecutivo nvarchar (9),
@Cedula_Ejecutivo nvarchar (16),
@ID_Proveedor int,
@Correo_Ejecutivo nvarchar (50),
@Direccion_Ejecutivo nvarchar (150),
@Sexo_Ejecutivo nvarchar (10),
@Foto nvarchar(max),
@ID_Empleado int
)

As
Begin

Begin try

If not exists (Select [Cedula_Ejecutivo] from [dbo].[Ejecutivo] 
where [Cedula_Ejecutivo] = @Cedula_Ejecutivo and [ID_Ejecutivo] != @ID)

Begin

 

Update [dbo].[Ejecutivo]
   Set [Nombres_Ejecutivo] = @Nombres_Ejecutivo,
	   [Apellidos_Ejecutivo] = @Apellidos_Ejecutivo,
	   [Telefono_Ejecutivo] = @Telefono_Ejecutivo,
	   [Cedula_Ejecutivo] = @Cedula_Ejecutivo,
   	   [ID_Proveedor] = @ID_Proveedor,
	   [Correo_Ejecutivo] = @Correo_Ejecutivo,
	   [Sexo_Ejecutivo] = @Sexo_Ejecutivo,
	   [Direccion_Ejecutivo] = @Direccion_Ejecutivo,
	   [Fotografia_Ejecutivo] = @Foto,
       [ID_Empleado] = @ID_Empleado
 Where([ID_Ejecutivo]= @ID)

End


End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR EJECUTIVO',10,1)
Rollback Tran
End catch

End

Go

-----------------

--1---

Create Procedure Agregar_ClienteJuridico(
@Nombre_ClienteJuridico nvarchar (50),
@No_RUC nvarchar(15),
@Telefono_ClienteJuridico nvarchar (9), 
@Descuento decimal(5,2),
@Correo_ClienteJuridico nvarchar (50),
@Direccion_ClienteJuridico nvarchar (150),
@Foto_ClienteJuridico nvarchar (max),
@ID_Empleado int,
@ID_Prov int output
)

As
Begin

Begin try

if not exists (Select [Nombre_ClienteJuridico] from [dbo].[ClienteJuridico] where [Nombre_ClienteJuridico] = @Nombre_ClienteJuridico)
if not exists (Select [No_RUC] from [dbo].[ClienteJuridico] where [No_RUC] = @No_RUC)

Begin
Begin

Set @ID_Prov = (Select Max(ID_ClienteJuridico) from ClienteJuridico)

Insert Into [dbo].[ClienteJuridico]
           (
           [Descuento_ClienteJuridico],
		   [Nombre_ClienteJuridico],
		   [No_RUC],
		   [Telefono_ClienteJuridico],
		   [Direccion_ClienteJuridico],
		   [Correo_ClienteJuridico],
		   [Fotografia_ClienteJuridico],
		   [ID_Empleado]
		   )

     Values
           (@Descuento, @Nombre_ClienteJuridico, @No_RUC, @Telefono_ClienteJuridico, @Direccion_ClienteJuridico, @Correo_ClienteJuridico,
		   @Foto_ClienteJuridico, @ID_Empleado)

End
End


End try

Begin catch
Raiserror('ERROR AL INSERTAR CLIENTE JURIDICO',10,1)
Rollback Tran

End catch


End

Go
--------------
--------------

---2---
Create Procedure Activar_ClienteJuridico(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[ClienteJuridico] Where ([Estado_ClienteJuridico] = 'Inactivo' And [ID_ClienteJuridico] = @ID))
Begin

Update [dbo].[ClienteJuridico]
Set [Estado_ClienteJuridico] = 'Activo'
Where [ID_ClienteJuridico] = @ID

End

End try

Begin catch
Raiserror('ERROR AL ACTIVAR CLIENTE ',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---3---
Create Procedure Desactivar_ClienteJuridico(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[ClienteJuridico] Where ([Estado_ClienteJuridico] = 'Activo' And [ID_ClienteJuridico] = @ID))
Begin 

Update [dbo].[ClienteJuridico]
Set [Estado_ClienteJuridico] = 'Inactivo'
Where [ID_ClienteJuridico] = @ID

End


End try

Begin catch
Raiserror('ERROR AL DESACTIVAR CLIENTE JURIDICO',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---4---
Create Procedure Actualizar_ClienteJuridico(
@ID int,
@Nombre_ClienteJuridico nvarchar (50),
@No_RUC nvarchar(15),
@Telefono_ClienteJuridico nvarchar (9), 
@Descuento decimal(5,2),
@Correo_ClienteJuridico nvarchar (50),
@Direccion_ClienteJuridico nvarchar (150),
@Foto_ClienteJuridico nvarchar (max),
@ID_Empleado int
)

As
Begin

Begin try

if not exists (Select [Nombre_ClienteJuridico] from [dbo].[ClienteJuridico]
where [Nombre_ClienteJuridico] = @Nombre_ClienteJuridico and [ID_ClienteJuridico] != @ID)
if not exists (Select [No_RUC] from [dbo].[ClienteJuridico] 
where [No_RUC] = @No_RUC and [ID_ClienteJuridico] != @ID)

Begin
Begin
Update [dbo].[ClienteJuridico]
   Set [Descuento_ClienteJuridico]=@Descuento,
	   [Nombre_ClienteJuridico]=@Nombre_ClienteJuridico,
	   [No_RUC]=@No_RUC,
	   [Telefono_ClienteJuridico]=@Telefono_ClienteJuridico,
	   [Direccion_ClienteJuridico]=@Direccion_ClienteJuridico,
	   [Correo_ClienteJuridico]=@Correo_ClienteJuridico,
	   [Fotografia_ClienteJuridico] = @Foto_ClienteJuridico,
	   [ID_Empleado] = @ID_Empleado
 Where ([ID_ClienteJuridico] = @ID)

End
End


End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR CLIENTE JURIDICO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------



---5---
Create Procedure Agregar_Cliente(
@Nombres_Cliente nvarchar (50),
@Apellidos_Cliente nvarchar (50),
@Telefono_Cliente nvarchar (9),
@Cedula_Cliente nvarchar (16),
@Descuento decimal (4,2),
@Correo_Cliente nvarchar (50),
@Direccion_Cliente nvarchar (150),
@Sexo_Cliente nvarchar (10), 
@Foto nvarchar (max),
@ID_Empleado int,
@ID_ClienteJuridico int,
@Representante nvarchar(2)
)

As
Begin

Begin try

If not exists (Select [Cedula_Cliente] from [dbo].[Cliente] where [Cedula_Cliente] = @Cedula_Cliente and
[ID_ClienteJuridico] = @ID_ClienteJuridico)

Begin



if (@ID_ClienteJuridico = 0)
Begin

Set @ID_ClienteJuridico = null

End


Insert Into [dbo].[Cliente]
           ([Nombres_Cliente],
		   [Apellidos_Cliente],
		   [Telefono_Cliente],
		   [Cedula_Cliente],
		   [Descuento_Cliente],
		   [Correo_Cliente],
		   [Sexo_Cliente],
		   [Direccion_Cliente],
		   [Fotografia_Cliente],
		   [ID_Empleado],
		   [ID_ClienteJuridico],
		   [Representante]   
           )

     Values
           (@Nombres_Cliente, @Apellidos_Cliente, @Telefono_Cliente, @Cedula_Cliente, @Descuento, @Correo_Cliente,
		   @Sexo_Cliente, @Direccion_Cliente, @Foto, @ID_Empleado, @ID_ClienteJuridico, @Representante)

End

End try

Begin catch
Raiserror('ERROR AL INSERTAR CLIENTE',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

---6---
Create Procedure Activar_Cliente(@ID int)

As
Begin

Begin try


Declare @Desac_Direct Nvarchar(2)
Set @Desac_Direct = (Select Desactivado_Directament from Cliente where ID_Cliente = @ID)

if(@Desac_Direct = 'Si')
Begin

If exists (Select * From [dbo].[Cliente] Where ([Estado_Cliente] = 'Inactivo' And [ID_Cliente] = @ID))
Begin

Update [dbo].[Cliente]
Set [Estado_Cliente] = 'Activo',
	[Desactivado_Directament] = 'No'
Where [ID_Cliente] = @ID

End
End
End try

Begin catch
Raiserror('ERROR AL ACTIVAR CLIENTE',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---7---
Create Procedure Desactivar_Cliente(@ID int)

As
Begin

Begin try


If exists (Select * From [dbo].[Cliente] Where ([Estado_Cliente] = 'Activo' And [ID_Cliente] = @ID))
Begin 

Update [dbo].[Cliente]
Set [Estado_Cliente] = 'Inactivo',
	[Desactivado_Directament] = 'Si'
Where [ID_Cliente] = @ID

End


End try

Begin catch
Raiserror('ERROR AL DESACTIVAR CLIENTE',10,1)
Rollback Tran
End catch

End

Go

-----------------
----------------

---8---
Create Procedure Actualizar_Cliente(
@ID int,
@Nombres_Cliente nvarchar (50),
@Apellidos_Cliente nvarchar (50),
@Telefono_Cliente nvarchar (9),
@Cedula_Cliente nvarchar (16),
@Descuento decimal (4,2),
@Correo_Cliente nvarchar (50),
@Direccion_Cliente nvarchar (150),
@Sexo_Cliente nvarchar (10),
@Foto nvarchar(max),
@ID_Empleado int,
@ID_ClienteJuridico int
--@Representante nvarchar(2)
)

As
Begin

Begin try

if (@ID_ClienteJuridico = 0)
Begin

Set @ID_ClienteJuridico = null

End

If not exists (Select [Cedula_Cliente] from [dbo].[Cliente] 
where [Cedula_Cliente] = @Cedula_Cliente and [ID_ClienteJuridico] = @ID_ClienteJuridico and [ID_Cliente] != @ID)

Begin

 

Update [dbo].[Cliente]
   Set [Nombres_Cliente] = @Nombres_Cliente,
	   [Apellidos_Cliente] = @Apellidos_Cliente,
	   [Telefono_Cliente] = @Telefono_Cliente,
	   [Cedula_Cliente] = @Cedula_Cliente,
   	   [Descuento_Cliente] = @Descuento,
	   [Correo_Cliente] = @Correo_Cliente,
	   [Sexo_Cliente] = @Sexo_Cliente,
	   [Direccion_Cliente] = @Direccion_Cliente,
	   [Fotografia_Cliente] = @Foto,
       [ID_Empleado] = @ID_Empleado,
	   [ID_ClienteJuridico] = @ID_ClienteJuridico
	-- [Representante] = @Representante
 Where([ID_Cliente]= @ID)

End


End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR CLIENTE',10,1)
Rollback Tran
End catch

End

Go

-----------------

---9---
Create Procedure Agregar_Producto(
@Nombre_Producto nvarchar (50),
@Codigo_Producto nvarchar (50),
@ID_Categoria int,
@ID_Proveedor int,
@ID_Laboratorio int,
@Contenido nvarchar (150),
@Controlado nvarchar (5),
@Unidades_Disponibles int,
@Precio_Venta money,
@Stock_Min int,
@Tipo_Medicamento nvarchar(50),
@Margen_Ganancia money,
@Presentacion nvarchar(50),
@UnidsXCaja int,
@Fotografia_Producto nvarchar(max),
@ID_Empleado int, 
@Exclud_IVA nvarchar (2)
)

As
Begin

Begin try


If not exists (Select [Nombre_Producto] from [dbo].[Producto] where [Nombre_Producto] = @Nombre_Producto and
[ID_Proveedor] = @ID_Proveedor)
If not exists (Select [Codigo_Producto] from [dbo].[Producto] where [Codigo_Producto] = @Codigo_Producto)
Begin
Begin


Insert Into [dbo].[Producto]
           ([Nombre_Producto],
		   [Codigo_Producto],
		   [ID_Categoria],
		   [Contenido],
		   [Controlado],
		   [Unidades_Disponibles],
		   [Precio_Venta],
		   [Stock_Min],
		   [ID_Proveedor],
		   [ID_Laboratorio],
		   [Margen_Ganancia],
		   [Tipo_Medicamento],
		   [Presentacion],
		   [UnidsXCaja],
		   [Fotografia_Producto],
		   [ID_Empleado],
		   [Exclud_IVA]
           )
     Values
           (@Nombre_Producto, @Codigo_Producto, @ID_Categoria,  @Contenido, @Controlado, @Unidades_Disponibles, @Precio_Venta, 
		   @Stock_Min, @ID_Proveedor, @ID_Laboratorio, @Margen_Ganancia, @Tipo_Medicamento, @Presentacion, @UnidsXCaja, @Fotografia_Producto,
		   @ID_Empleado, @Exclud_IVA)

		

End
End

End try

Begin catch
Raiserror('ERROR AL INSERTAR PRODUCTO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

 --SET @sql = 'SET Photograph = SELECT * FROM OPENROWSET(BULK ' + QUOTENAME(@PathToPhoto) + ', SINGLE_BLOB) AS photo'--

--exec(@sql)
---10---
Create Procedure Activar_Producto(@ID int)

As
Begin

Begin try

Declare @Desac_Direct Nvarchar(2)
Set @Desac_Direct = (Select Desactivado_Directament from Producto where ID_Producto = @ID)

if(@Desac_Direct = 'Si')
Begin

If exists (Select * From [dbo].[Producto] Where ([Estado_Producto] = 'Inactivo' And [ID_Producto] = @ID))
Begin

Update [dbo].[Producto]
Set [Estado_Producto] = 'Activo',
    [Desactivado_Directament] = 'No'
Where [ID_Producto] = @ID

End
End
End try

Begin catch
Raiserror('ERROR AL ACTIVAR PRODUCTO',10,1)
Rollback Tran
End catch

End


Go
-----------------
----------------

---11---
Create Procedure Desactivar_Producto(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Producto] Where ([Estado_Producto] = 'Activo' And [ID_Producto] = @ID))
Begin

Update [dbo].[Producto]
Set [Estado_Producto] = 'Inactivo',
    [Desactivado_Directament] = 'Si'
Where [ID_Producto] = @ID

End

End try

Begin catch
Raiserror('ERROR AL DESACTIVAR PRODUCTO',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

---12---
Create Procedure Actualizar_Producto(
@ID int,
@Nombre_Producto nvarchar (50),
@Codigo_Producto nvarchar (50),
@ID_Categoria int,
@ID_Proveedor int,
@ID_Laboratorio int,
@Contenido nvarchar (150),
@Controlado nvarchar (5),
@Stock_Min int,
@Tipo_Medicamento nvarchar(10),
@Margen_Ganancia money,
@Presentacion nvarchar(50),
@UnidsXCaja int,
@Fotografia_Producto nvarchar(max),
@ID_Empleado int, 
@Exclud_IVA nvarchar(2)
)

As
Begin

Begin try

If not exists (Select [Nombre_Producto] from [dbo].[Producto] 
where [Nombre_Producto] = @Nombre_Producto and [ID_Producto] != @ID and [ID_Proveedor]=@ID_Proveedor)
If not exists (Select [Codigo_Producto] from [dbo].[Producto] 
where [Codigo_Producto] = @Codigo_Producto and [ID_Producto] != @ID)
Begin
Begin



Update [dbo].[Producto]
   Set [Nombre_Producto] = @Nombre_Producto,
	   [Codigo_Producto] = @Codigo_Producto,
	   [Contenido] = @Contenido,
	   [Controlado] = @Controlado,
	   [Stock_Min] = @Stock_Min,
	   [ID_Proveedor] = @ID_Proveedor,
	   [ID_Laboratorio] = @ID_Laboratorio,
	   [Margen_Ganancia] = @Margen_Ganancia,
	   [ID_Categoria] = @ID_Categoria,
	   [Tipo_Medicamento] = @Tipo_Medicamento,
	   [Presentacion] = @Presentacion,
	   [UnidsXCaja] = @UnidsXCaja,
	   [Fotografia_Producto] = @Fotografia_Producto,
	   [ID_Empleado] = @ID_Empleado,
	   [Exclud_IVA] = @Exclud_IVA
 Where([ID_Producto] = @ID)

End
End

End try

Begin catch
Raiserror('ERROR AL ACTUALIZAR PRODUCTO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------


---21---




Create Procedure Agregar_Compra(
@ID_Proveedor int,
@ID_Ejecutivo int,
@ID_Empleado int,
@Fecha_Compra date,
@Modo_Compra nvarchar(12),
@Tiempo_Pago int,
@No_Factura nvarchar(50),
@Cancelada nvarchar(10),
@ID_Compra int output
)
As

Begin

Begin try

Declare @ID_CompraAct int
Set @ID_Compra = (Select Max(ID_Compra) from Compra)


 
 Insert Into [dbo].[Compra]
			(
			[ID_Proveedor],
			[ID_Ejecutivo],
			[ID_Empleado],
			[Fecha_Compra],
			[Fecha_Pago],
			[ModoCompra],
			[Tiempo_Pago],
			[No_Factura],
			[Compra_Cancelada])
             
     VALUES
           (@ID_Proveedor, @ID_Ejecutivo, @ID_Empleado, @Fecha_Compra, @Fecha_Compra,
		   @Modo_Compra, @Tiempo_Pago, @No_Factura, @Cancelada)



End try

Begin catch
Raiserror('ERROR AL GUARDAR COMPRA',10,1)
Rollback Tran
End  Catch

End
Go

---3---
Create Procedure Anular_Compra(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Compra] Where ([Estado_Compra] = 'Activo' And [ID_Compra] = @ID))
Begin 

Update [dbo].[Compra]
Set [Estado_Compra] = 'Anulada'
Where [ID_Compra] = @ID

End


End try

Begin catch
Raiserror('ERROR AL ANULAR COMPRA',10,1)
Rollback Tran
End catch

End

Go
-----------------
----------------

create Procedure Modificar_DetalleCompra(
@ID_DetalleCompra int,
@Fecha_Vencimiento date,
@Unids_Compradas int,
@Costo_Compra money,
@Descuento decimal (5,2),
@Modo_Adquisicion nvarchar(20),
@Incluye_IVA nvarchar(2),
@Permite_Devolucion nvarchar(2),
@Porcentaje_Devolucion int,
@Incluye_Vineta nvarchar(2),
@Cantidad_Vineta money,
@DescuentoMonet money
)
As
 
 Begin
 Begin try

Update [dbo].[DetalleCompra]
Set        [Fecha_Vencimiento] = @Fecha_Vencimiento,
		   [Unidades_Compradas] = @Unids_Compradas,
		   [Costo_Compra] = @Costo_Compra,
		   [Descuento] = @Descuento,
		   [ModoAdquisicion] = @Modo_Adquisicion,
		   [Incluye_IVA] = @Incluye_IVA,
	       [Permite_Devolucion] = @Permite_Devolucion,
		   [Porcentaje_Devolucion] = @Porcentaje_Devolucion,
	       [Incluye_Vineta] = @Incluye_Vineta,
           [Cantidad_Vineta] = @Cantidad_Vineta,
		   [UnidsEnInventario] = @Unids_Compradas,
		   [DescuentoMonetario] = @DescuentoMonet
		 
		 Where ID_DetalleCompra = @ID_DetalleCompra

 
End try

Begin catch
Raiserror('ERROR AL MODIFICAR DETALLE COMPRA',10,1)
Rollback Tran
End  Catch
End
Go

--------------
--------------


create Procedure Agregar_DetalleCompra(
@ID_Compra int,
@ID_Producto int,
@Fecha_Vencimiento date,
@Unids_Compradas int,
@Costo_Compra money,
@Descuento decimal (5,2),
@Modo_Adquisicion nvarchar(20),
@Incluye_IVA nvarchar(2),
@Permite_Devolucion nvarchar(2),
@Porcentaje_Devolucion int,
@Incluye_Vineta nvarchar(2),
@Cantidad_Vineta money,
@DescuentoMonet money
)
As
 
 Begin
 Begin try

  Insert Into [dbo].[DetalleCompra]
           ([ID_Compra],
		   [ID_Producto],
		   [Fecha_Vencimiento],
		   [Unidades_Compradas],
		   [Costo_Compra],
		   [Descuento],
		   [ModoAdquisicion],
		   [Incluye_IVA],
	       [Permite_Devolucion],
		   [Porcentaje_Devolucion],
	       [Incluye_Vineta],
           [Cantidad_Vineta],
		   [UnidsEnInventario],
		   [DescuentoMonetario]
		   )
     VALUES
           (@ID_Compra, @ID_Producto, @Fecha_Vencimiento, @Unids_Compradas, @Costo_Compra, @Descuento,
		   @Modo_Adquisicion, @Incluye_IVA, @Permite_Devolucion, @Porcentaje_Devolucion, @Incluye_Vineta,
		   @Cantidad_Vineta, 0, @DescuentoMonet)

 
End try

Begin catch
Raiserror('ERROR AL GUARDAR DETALLE COMPRA',10,1)
Rollback Tran
End  Catch
End
Go

--------------
--------------

Create Procedure Modificar_NoFactura(@ID int, @Num nvarchar(50))
As
Begin

Begin try

Update Compra
Set No_Factura = @Num
Where ID_Compra = @ID


End try

Begin catch
Raiserror('ERROR AL MODIFICAR NO FACTURA',10,1)
Rollback Tran

End catch

End

Go


Create Procedure Agregar_Tipo_Cambio(
@Tipo_Cambio money,
@Cambio_BCN nvarchar(2),
@ID_Empleado int
)

As
Begin

Begin try

Insert Into [dbo].[Tipo_Cambio]
           (
		   [Tipo_Cambio],
		   [Cambio_BCN],
		   [ID_Empleado]
           )

     Values
           (@Tipo_Cambio, @Cambio_BCN, @ID_Empleado)

		   

End try

Begin catch
Raiserror('ERROR AL INSERTAR TIPO DE CAMBIO',10,1)
Rollback Tran

End catch

End

Go

Create Procedure Agregar_CuentaxCobrar(
@ID_Cliente int,
@ID_Venta int,
@Saldo money,
@Fecha date,
@Fecha_Limit date
)

As
Begin

Begin try

Insert Into [dbo].[CuentaCobrar]
           (
		   [ID_Cliente],
		   [ID_Venta],
		   [Mora],
		   [Saldo],
		   [Fecha_Cancelación],
		   [Fecha_Limite]
           )

     Values
           (@ID_Cliente, @ID_Venta, 0, @Saldo, @Fecha, @Fecha_Limit)

		   

End try

Begin catch
Raiserror('ERROR AL INSERTAR CUENTA POR COBRAR',10,1)
Rollback Tran

End catch

End

Go


Create Procedure Agregar_IP_Puerto(
@IP nvarchar(50),
@Puerto int
)

As
Begin

Begin try

Insert Into [dbo].[IP_Puerto]
           ([IP],
		   [Puerto]
           )

     Values
           (@IP, @Puerto)

		   

End try

Begin catch
Raiserror('ERROR AL INSERTAR IP Y PUERTO',10,1)
Rollback Tran

End catch

End

Go


create Procedure Agregar_Orden(
@ID_Empleado int,
@NombreCliente nvarchar(50),
@ID_Cliente int, 
@Fecha_Venta Date,
@Descuento decimal(5,2),
@ID_Tipo_Cambio int,
@Tipo_Factura nvarchar(10),
@ID_EmpleadoI int,
@Cancelada nvarchar(10),
@ID_Venta int output
)
As

Begin

Begin try


Set @ID_Venta = (Select MAX(ID_Venta) from Venta)

 
 Insert Into [dbo].[Venta]
			([ID_Empleado],
			[Nombre_Cliente],
			[ID_Cliente],
			[Fecha_Venta],
			[Descuento],
			[ID_Tipo_Cambio],
			[Tipo_Factura],
			[ADomiciolio],
			[ID_Repartidor],
			[Cancelada],
			[ID_EmpleadoI]
			)
             
     VALUES
           (@ID_Empleado, @NombreCliente, @ID_Cliente, @Fecha_Venta, @Descuento, @ID_Tipo_Cambio, 
		   @Tipo_Factura, 'No', null, @Cancelada, @ID_EmpleadoI)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR ORDEN',10,1)
Rollback Tran
End  Catch

End
Go
-------------------------------------
-------------------------------------

create Procedure Agregar_OrdenFacturar(
@ID_Venta int,
@SubTotal money,
@IVA money,
@Descuento nvarchar(10),
@Total money
)
As

Begin

Begin try



 
 Insert Into [dbo].[OrdenFacturar]
			([ID_Venta],
			[SubTotal],
			[IVA],
			[Descuento],
			[Total]
			)
             
     VALUES
           (@ID_Venta, @SubTotal, @IVA, @Descuento,@Total)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR ORDEN FACTURA',10,1)
Rollback Tran
End  Catch

End
Go
-------------------------------------
-------------------------------------



create Procedure Agregar_DetalleOrden(
@ID_Venta int,
@ID_Producto int,
@Unidades_Vend int,
@Presentacion nvarchar(50),
@PrecioVenta money
)
As

Begin

Begin try

 
 Insert Into [dbo].[DetalleVenta]
			([ID_Venta],
			[ID_Producto],
			[Unidades_Vendidas],
			[Presentacion],
			[Precio_Venta])
             
     VALUES
           (@ID_Venta, @ID_Producto, @Unidades_Vend, @Presentacion, @PrecioVenta)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR DETALLE ORDEN',10,1)
Rollback Tran
End  Catch

End
Go



create Procedure Agregar_OrdenFact(
@ID_Venta int,
@Unids int,
@Producto nvarchar(100),
@PrecioVenta money,
@Total money,
@Individual nvarchar(50)
)
As

Begin

Begin try

 
 Insert Into [dbo].[DetallesOrden]
			([ID_Venta],
			[Unids],
			[Producto],
			[PrecioV],
			[Total],
			[Individual])
             
     VALUES
           (@ID_Venta, @Unids,@Producto, @PrecioVenta,@Total, @Individual)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR DETALLE FACTURA',10,1)
Rollback Tran
End  Catch

End
Go


create Procedure Pagar_Factura(
@ID_Venta int,
@ID_Cajero int,
@Moneda nvarchar(10),
@ModoVenta nvarchar(10),
@Recibido money,
@ID_Empleado int
)
As

Begin

Begin try

Insert into [dbo].[Facturacion]
([ID_Cajero],
[ID_Venta],
[Moneda],
[ModoVenta],
[Recibido],
[ID_EmpleadoI]
)
Values (@ID_Cajero, @ID_Venta,@Moneda,@ModoVenta,@Recibido,@ID_Empleado)
 
 Update [dbo].[Venta]
	set [Cancelada] = 'Cancelada'
	Where ID_Venta = @ID_Venta
             
     


  
End try

Begin catch
Raiserror('ERROR AL PAGAR ORDEN',10,1)
Rollback Tran
End  Catch

End
Go

 

Create Procedure Agregar_Proforma(
@ID_Empleado int,
@NombreCliente nvarchar(50),
@ID_Cliente int, 
@Fecha_Proforma Date,
@Descuento decimal(5,2),
@ID_Tipo_Cambio int,
@Tipo_Factura nvarchar(10),
@ID_EmpleadoI int,
@ID_Proforma int output
)
As

Begin

Begin try


Set @ID_Proforma = (Select MAX(ID_Proforma) from Proforma)

 Insert Into [dbo].[Proforma]
			([ID_Empleado],
			[Nombre_Cliente],
			[ID_Cliente],
			[Fecha_Proforma],
			[Descuento],
			[ID_Tipo_Cambio],
			[Tipo_Factura],
			[ADomiciolio],
			[ID_Repartidor],
			[ID_EmpleadoI])
             
     VALUES
           (@ID_Empleado, @NombreCliente, @ID_Cliente, @Fecha_Proforma, @Descuento, @ID_Tipo_Cambio, @Tipo_Factura, 'No', null, @ID_EmpleadoI)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR ORDEN',10,1)
Rollback Tran
End  Catch

End
Go
-------------------------------------
-------------------------------------


create Procedure Agregar_DetalleProforma(
@ID_Proforma int,
@ID_Producto int,
@Unidades_Vend int,
@Presentacion nvarchar(50),
@PrecioVenta money
)
As

Begin

Begin try

 
 Insert Into [dbo].[DetalleProforma]
			([ID_Proforma],
			[ID_Producto],
			[Unidades_Vendidas],
			[Presentacion],
			[Precio_Venta])
             
     VALUES
           (@ID_Proforma, @ID_Producto, @Unidades_Vend, @Presentacion, @PrecioVenta)

  
End try

Begin catch
Raiserror('ERROR AL GUARDAR DETALLE PROFORMA',10,1)
Rollback Tran
End  Catch

End
Go


---22---
Create Procedure DisminuirInventario(
@ID_Producto int,
@Unidades_Vendidas int
)
As

Begin

Begin try

While (@Unidades_Vendidas != 0)
Begin

 Declare @UnidadesDisponibles int, @ID_DetalleCompra int
 Set @UnidadesDisponibles = (Select Top 1 [UnidsEnInventario] from  [dbo].[DetalleCompra] 
 where ([ID_Producto] = @ID_Producto and [UnidsEnInventario] > 0) Order By [Fecha_Vencimiento] Asc) 
 Set @ID_DetalleCompra = (Select Top 1 [ID_DetalleCompra] from  [dbo].[DetalleCompra] 
 where ([ID_Producto] = @ID_Producto and [UnidsEnInventario] > 0) Order By [Fecha_Vencimiento] Asc) 

 If (@UnidadesDisponibles >= @Unidades_Vendidas)
 Begin
 Update [dbo].[DetalleCompra] 
	Set [UnidsEnInventario] = @UnidadesDisponibles - @Unidades_Vendidas
	Where [ID_DetalleCompra] = @ID_DetalleCompra
	Set @Unidades_Vendidas = 0
 Break
 End

 If(@UnidadesDisponibles < @Unidades_Vendidas)
  Begin
  Set @Unidades_Vendidas = @Unidades_Vendidas - @UnidadesDisponibles
  Update [dbo].[DetalleCompra] 
	Set [UnidsEnInventario] = 0
	Where [ID_DetalleCompra] = @ID_DetalleCompra
 Continue
 End

 End

End try

Begin catch
Raiserror('ERROR AL DISMINUIR INVENTARIO',10,1)
Rollback Tran
End  Catch

End
Go
-------------------------------------
-------------------------------------


Create Procedure Agregar_Usuario(
@IDEmpleado int,
@Privilegio nvarchar(20),
@Contrasena nvarchar (100),
@Nombre_Usuario nvarchar (50),
@ID_Empleado int
)

As
Begin

Begin try


Insert Into [dbo].[Usuario]
           ([ID_Empleado],
		   [Privilegio],
		   [Contrasena],
		   [Nombre_Usuario],
		   [ID_Empleado_I]
           )

     Values
           (@IDEmpleado, @Privilegio, @Contrasena, @Nombre_Usuario, @ID_Empleado)

		   

End try

Begin catch
Raiserror('ERROR AL INSERTAR USUARIO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

---18---
Create Procedure Activar_Usuario(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Usuario] Where ([Estado_Usuario] = 'Inactivo' And [ID_Usuario] = @ID))
Begin

Update [dbo].[Usuario]
Set [Estado_Usuario] = 'Activo'
Where [ID_Empleado] = @ID

End

End try

Begin catch
Raiserror('ERROR AL ACTIVAR USUARIO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------

---19---
Create Procedure Desactivar_Usuario(@ID int)

As
Begin

Begin try

If exists (Select * From [dbo].[Usuario] Where ([Estado_Usuario] = 'Activo' And [ID_Usuario] = @ID))
Begin



Update [dbo].[Usuario]
Set [Estado_Usuario] = 'Inactivo'
Where [ID_Empleado] = @ID
End



End try

Begin catch
Raiserror('ERROR AL DESACTIVAR USUARIO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------

---20---
Create Procedure CambiarContrasena_Usuario(
@ID int,
@Contrasena nvarchar (100)
)

As
Begin

Begin try




Update [dbo].[Usuario]
   Set [Contrasena] = @Contrasena
 Where([ID_Usuario] = @ID)

End try

Begin catch
Raiserror('ERROR AL CAMBIAR CONTRASEÑA DE USUARIO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------
/*select top 2 [Nombre_Producto], sum([Unidades_Compradas]) as [Venta] from [dbo].[DetalleCompraV] group by [Nombre_Producto] order by sum([Unidades_Compradas]) desc

select * from DetalleCompraV
*/
---20---
Create Procedure CambiarPrivilegios(
@ID int,
@Privilegio nvarchar(20)
)

As
Begin

Begin try



Update [dbo].[Usuario]
   Set [Privilegio] = @Privilegio
 Where([ID_Empleado] = @ID)
 
End try

Begin catch
Raiserror('ERROR AL CAMBIAR PRIVILEGIO DE USUARIO',10,1)
Rollback Tran
End catch

End

Go
-----------------
-----------------

---21---


--------------
--------------


/* ***VISTAS*** */

---1---
Create View ProveedorV
As(
Select P.[ID_Proveedor], P.[Tipo_Proveedor],P.[Nombre_Proveedor], P.[No_RUC], P.[Telefono_Proveedor], P.[Direccion_Proveedor], P.[Correo_Proveedor],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Proveedor]
from Proveedor P
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
)
Go
-----------------
-----------------

Go

Create View LaboratorioV
As(
Select P.[ID_Proveedor], P.[Tipo_Proveedor],P.[Nombre_Proveedor], P.[No_RUC], P.[Telefono_Proveedor], P.[Direccion_Proveedor], P.[Correo_Proveedor],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Proveedor]
from Proveedor P
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
Where P.Tipo_Proveedor = 'Laboratorio'
)
Go
-----------------
-----------------

---1---
Create View EjecutivoV
As(
Select E.[ID_Ejecutivo], E.[Nombres_Ejecutivo], E.[Apellidos_Ejecutivo], E.[Cedula_Ejecutivo], E.[Sexo_Ejecutivo],
E.[Telefono_Ejecutivo], E.[Correo_Ejecutivo], E.[Direccion_Ejecutivo], P.[Nombre_Proveedor], E.[Fecha_Ingreso],
 EM.[Nombres_Empleado], EM.[Apellidos_Empleado], E.[Estado_Ejecutivo]
from [dbo].[Ejecutivo] E
Inner Join [dbo].[Proveedor] P
On E.[ID_Proveedor] = P.[ID_Proveedor]
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado]
)
Go
-----------------
-----------------

---7---
Create View EmpleadoV
As(
Select E.[ID_Empleado], E.[Nombres_Empleado], E.[Apellidos_Empleado], E.[Cedula_Empleado], E.[Telefono_Empleado],
E.Area, E.[Correo_Empleado], E.[Direccion_Empleado],E.Porcentaje_Comision,E.[Fecha_Ingreso], EM.[Nombres_Empleado] as [NM], 
EM.[Apellidos_Empleado] as [AE], E.[Estado_Empleado]
from [dbo].[Empleado] E
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado]
)
Go
-----------------
-----------------

---1---
Create View Buscar_EjecutivoV
As(
Select E.[ID_Ejecutivo], E.[Nombres_Ejecutivo], E.[Apellidos_Ejecutivo], E.[Cedula_Ejecutivo], E.[Sexo_Ejecutivo],
E.[Telefono_Ejecutivo], E.[Correo_Ejecutivo], E.[Direccion_Ejecutivo], P.[Nombre_Proveedor], E.[Fecha_Ingreso],
 EM.[Nombres_Empleado], EM.[Apellidos_Empleado], E.[Estado_Ejecutivo], E.[ID_Proveedor]
from [dbo].[Ejecutivo] E
Inner Join [dbo].[Proveedor] P
On E.[ID_Proveedor] = P.[ID_Proveedor]
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado]
)
Go
-----------------
-----------------

Create View CategoriaV
As(
Select P.[ID_Categoria], P.[Nombre_Categoria], P.[Descripcion_Categoria],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Categoria]
from Categoria P
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
)
Go
-----------------
-----------------

---2---
Create View ProductoV
As(
Select P.[ID_Producto], P.[Nombre_Producto], P.[Codigo_Producto], C.[Nombre_Categoria], P.[Contenido], P.[Controlado],  
P.[Tipo_Medicamento], P.[Presentacion],P.[UnidsXCaja],  P.[Margen_Ganancia], P.[Unidades_Disponibles],
(P.[Precio_Venta]+(P.[Precio_Venta]*(P.[Margen_Ganancia]/100))) as [Precio_Venta], 
P.[Exclud_IVA], P.[Stock_Min], PR.[Nombre_Proveedor], LA.[Nombre_Proveedor] as [Laboratorio],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Producto]
from [dbo].[Producto] P
Inner Join [dbo].[Proveedor] PR
On P.[ID_Proveedor] = PR.[ID_Proveedor]
Inner Join [dbo].[Categoria] C
On P.[ID_Categoria] = C.[ID_Categoria]
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
Inner Join [dbo].[Proveedor] LA
On P.[ID_Laboratorio] = LA.[ID_Proveedor]
)
Go
-----------------
-----------------

--2---
Create View Buscar_ProductoV
As(
Select P.[ID_Producto], P.[Nombre_Producto], P.[Codigo_Producto], C.[Nombre_Categoria], P.[Contenido], P.[Controlado],  
P.[Tipo_Medicamento], P.[Presentacion],P.[UnidsXCaja], P.[Margen_Ganancia], P.[Unidades_Disponibles], 
(P.[Precio_Venta]+(P.[Precio_Venta]*(P.[Margen_Ganancia]/100))) as [Precio_Venta], 
P.[Exclud_IVA], P.[Stock_Min],PR.[Nombre_Proveedor], LA.[Nombre_Proveedor] as [Laboratorio],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Producto], P.[ID_Proveedor]
from [dbo].[Producto] P
Inner Join [dbo].[Proveedor] PR
On P.[ID_Proveedor] = PR.[ID_Proveedor]
Inner Join [dbo].[Categoria] C
On P.[ID_Categoria] = C.[ID_Categoria]
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
Inner Join [dbo].[Proveedor] LA
On P.[ID_Laboratorio] = LA.[ID_Proveedor]
)
Go
-----------------
-----------------

Create View ProductoAgotarseV
As(
Select P.[ID_Producto], P.[Nombre_Producto], P.[Codigo_Producto], C.[Nombre_Categoria], P.[Contenido], P.[Controlado],  
P.[Tipo_Medicamento], P.[Presentacion],P.[UnidsXCaja],  P.[Margen_Ganancia], P.[Unidades_Disponibles],
(P.[Precio_Venta]+(P.[Precio_Venta]*(P.[Margen_Ganancia]/100))) as [Precio_Venta], 
P.[Exclud_IVA], P.[Stock_Min], PR.[Nombre_Proveedor], LA.[Nombre_Proveedor] as [Laboratorio],
P.[Fecha_Ingreso], E.[Nombres_Empleado], E.[Apellidos_Empleado], P.[Estado_Producto]
from [dbo].[Producto] P
Inner Join [dbo].[Proveedor] PR
On P.[ID_Proveedor] = PR.[ID_Proveedor]
Inner Join [dbo].[Categoria] C
On P.[ID_Categoria] = C.[ID_Categoria]
Inner Join [dbo].[Empleado] E
On P.[ID_Empleado] = E.[ID_Empleado]
Inner Join [dbo].[Proveedor] LA
On P.[ID_Laboratorio] = LA.[ID_Proveedor]
where P.[Unidades_Disponibles] <= P.[Stock_Min]
)
Go


---1---
Create View ClienteV
As(
Select E.[ID_Cliente], E.[ID_ClienteJuridico], E.[Nombres_Cliente], E.[Apellidos_Cliente],  
E.[Cedula_Cliente], E.[Sexo_Cliente], E.[Telefono_Cliente], E.[Correo_Cliente], E.[Direccion_Cliente], E.[Descuento_Cliente], 
E.[Fecha_Ingreso], EM.[Nombres_Empleado], EM.[Apellidos_Empleado], E.[Estado_Cliente]
from [dbo].[Cliente] E
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado] 
)
Go


---1---
Create View ClienteJuridicoNaturalV
As(
Select E.[Representante], E.[ID_Cliente], E.[ID_ClienteJuridico], E.[Nombres_Cliente], E.[Apellidos_Cliente],  
E.[Cedula_Cliente], E.[Sexo_Cliente], E.[Telefono_Cliente], E.[Correo_Cliente], E.[Direccion_Cliente], E.[Descuento_Cliente], 
E.[Fecha_Ingreso], EM.[Nombres_Empleado], EM.[Apellidos_Empleado], E.[Estado_Cliente]
from [dbo].[Cliente] E
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado] 
)
Go

---1---
Create View ClienteJuridicoV
As(
Select E.[ID_ClienteJuridico], E.[Nombre_ClienteJuridico], E.[No_RUC],
E.[Telefono_ClienteJuridico], E.[Direccion_ClienteJuridico],E.[Correo_ClienteJuridico], E.[Descuento_ClienteJuridico], 
E.[Fecha_Ingreso], EM.[Nombres_Empleado], EM.[Apellidos_Empleado], E.[Estado_ClienteJuridico]
from [dbo].[ClienteJuridico] E
Inner Join [dbo].[Empleado] EM
On E.[ID_Empleado] = EM.[ID_Empleado]
--Where  E.[ID_ClienteJuridico] != null
)
Go



---3---
Create View CompraV
As(
Select C.[ID_Compra], C.[No_Factura], C.[Fecha_Compra], EP.[Nombres_Empleado],  EP.[Apellidos_Empleado], P.[Nombre_Proveedor], 
E.[Nombres_Ejecutivo] , E.[Apellidos_Ejecutivo], Sum(DC.[Unidades_Compradas]) as [Unids_Totales], 
Sum(((DC.[Unidades_Compradas])* DC.[Costo_Compra])-(DC.DescuentoMonetario)) as [Total_Comprado],
C.[ModoCompra], C.[Tiempo_Pago],  C.Compra_Cancelada, C.[Fecha_Ingreso], C.[Estado_Compra]
from [dbo].[Compra] C
Inner Join [dbo].[Proveedor] P
On C.[ID_Proveedor] = P.[ID_Proveedor]
Inner Join [dbo].[DetalleCompra] DC
On C.[ID_Compra] = DC.[ID_Compra]
Inner Join [dbo].[Producto] PR
On DC.[ID_Producto] = PR.[ID_Producto]
Inner Join [dbo].[Ejecutivo] E
On C.[ID_Ejecutivo] = E.[ID_Ejecutivo]
Inner Join [dbo].[Empleado] EP
On C.[ID_Empleado] = EP.[ID_Empleado]
Group By C.[ID_Compra], C.[No_Factura], C.[Fecha_Compra], EP.[Nombres_Empleado],  EP.[Apellidos_Empleado], P.[Nombre_Proveedor],
E.[Nombres_Ejecutivo] , E.[Apellidos_Ejecutivo], C.[ModoCompra], C.[Tiempo_Pago], C.[Fecha_Ingreso], C.Compra_Cancelada,
 C.[Estado_Compra]
)
Go

-----------------
-----------------

---4---
Create View DetalleCompraV
As(
Select D.[ID_DetalleCompra], C.[ID_Compra], PR.[Nombre_Proveedor], PR.[Laboratorio], PR.[Nombre_Producto], PR.[Presentacion],
PR.[UnidsXCaja], PR.[Tipo_Medicamento], PR.[Contenido], D.[Fecha_Vencimiento],
(D.[Unidades_Compradas]/PR.[UnidsXCaja]) as [Unidades_Compradas], D.[Costo_Compra]*PR.[UnidsXCaja] as [Costo_Compra],
D.[Descuento], D.[Incluye_IVA], ((((D.[Unidades_Compradas])*D.[Costo_Compra]))-(D.[DescuentoMonetario]))
as [Total_Compra], D.[ModoAdquisicion], D.[Incluye_Vineta], D.[Cantidad_Vineta], D.[Permite_Devolucion], D.[Porcentaje_Devolucion],
D.[Estado_DetCompra]
from [dbo].[Compra] C
Inner Join [dbo].[DetalleCompra] D
On D.[ID_Compra] = C.[ID_Compra]
Inner Join [dbo].[ProductoV] PR
On D.[ID_Producto] = PR.[ID_Producto]
)
Go

---5---
Create View InventarioV
As(
Select  D.[Fecha_Vencimiento], P.[Nombre_Producto], P.[Tipo_Medicamento], P.[Presentacion], P.[UnidsXCaja], P.[Contenido],
P.[Nombre_Proveedor], P.[Laboratorio], Sum(D.[UnidsEnInventario]/P.[UnidsXCaja]) as [Unids_Inventario], P.[Precio_Venta], 
(P.[Precio_Venta] * Sum(D.[UnidsEnInventario]/P.[UnidsXCaja])) as [Ingreso_Total],
 (D.[Costo_Compra] *Sum(D.[UnidsEnInventario]/P.[UnidsXCaja])) as [Costo_Total],
((P.[Precio_Venta] * Sum(D.[UnidsEnInventario]/P.[UnidsXCaja])) - (D.[Costo_Compra] * Sum(D.[UnidsEnInventario]/P.[UnidsXCaja])))as [Utilidad_Total],
D.[Estado_DetCompra], D.[ID_Producto]
from [dbo].[DetalleCompra] D
Inner Join [dbo].[ProductoV] P
On D.[ID_Producto] = P.[ID_Producto]
Group by  D.[Fecha_Vencimiento], P.[Nombre_Producto], P.[Tipo_Medicamento], P.[Presentacion], P.[UnidsXCaja], P.[Contenido],
 P.[Nombre_Proveedor], P.[Laboratorio], P.[Precio_Venta], D.[Costo_Compra],  D.[Estado_DetCompra], D.[ID_Producto]
)
Go
-----------------
-----------------

---5---
Create View InventarioUnidsV
As(
Select  D.[Fecha_Vencimiento], P.[Nombre_Producto], P.[Tipo_Medicamento],  P.[Contenido],
P.[Nombre_Proveedor], P.[Laboratorio], (Sum(D.[UnidsEnInventario])) as [Unids_Inventario],
((P.[Precio_Venta])/(P.[UnidsXCaja])) as [Precio_Venta],
(((P.[Precio_Venta])/(P.[UnidsXCaja])) * (Sum(D.[UnidsEnInventario]))) as [Ingreso_Total],
(((D.[Costo_Compra])/(P.[UnidsXCaja])) * (Sum(D.[UnidsEnInventario]))) as [Costo_Total], 
((((P.[Precio_Venta])/(P.[UnidsXCaja])) - ((D.[Costo_Compra])/(P.[UnidsXCaja])))* 
(Sum(D.[UnidsEnInventario]))) as [Utilidad_Total],
D.[Estado_DetCompra], D.[ID_Producto]
from [dbo].[DetalleCompra] D
Inner Join [dbo].[ProductoV] P
On D.[ID_Producto] = P.[ID_Producto]
Where P.[UnidsXCaja]!=0
Group by  D.[Fecha_Vencimiento], P.[Nombre_Producto], P.[Tipo_Medicamento],  P.[Contenido],
 P.[Nombre_Proveedor], P.[Laboratorio], D.[Costo_Compra], P.[Precio_Venta], p.[UnidsXCaja],
 D.[Estado_DetCompra], D.[ID_Producto]
)
Go
-----------------
-----------------

Create View ProformaV as(
Select P.[ID_Proforma],EM.[Nombres_Empleado], EM.[Apellidos_Empleado], P.[Nombre_Cliente], P.[Fecha_Proforma], P.[Tipo_Factura], P.[Estado_Profrma]
from Proforma P
Inner Join Empleado EM
On P.ID_Empleado = EM.ID_Empleado
)
Go

Create View OrdenFacturarV as(
Select V.ID_Venta, V.Fecha_Venta,  V.Nombre_Cliente, OD.Total, EM.Nombres_Empleado, EM.Apellidos_Empleado, V.Cancelada, V.Estado_Venta
from [dbo].[Venta] V
Inner Join [dbo].[OrdenFacturar] OD
On V.ID_Venta = OD.ID_Venta
Inner Join Empleado EM
On V.ID_Empleado = EM.ID_Empleado
)
Go


Create View FacturarV as(
Select V.ID_Venta, V.Fecha_Venta, V.Nombre_Cliente, EM.Nombres_Empleado, EM.Apellidos_Empleado,
 OD.SubTotal, OD.IVA, OD.Descuento, OD.Total, V.Cancelada
from [dbo].[Venta] V
Inner Join [dbo].[OrdenFacturar] OD
On V.ID_Venta = OD.ID_Venta
Inner Join Empleado EM
On V.ID_Empleado = EM.ID_Empleado
)
Go



Create View UsuarioV
As(
Select U.[ID_Usuario], E.[Nombres_Empleado], E.[Apellidos_Empleado] , U.[Privilegio],
U.[Nombre_Usuario] ,U.[Estado_Usuario]
from [dbo].[Usuario] U
Inner Join [dbo].[Empleado] E
On U.[ID_Empleado] = E.[ID_Empleado]
)
Go


---9---
Create View VentaV
As(
Select V.[ID_Venta], E.[Nombres_Empleado], E.[Apellidos_Empleado], 
V.[Nombre_Cliente], V.[Fecha_Venta], V.[Descuento]
from [dbo].[Venta] V
Inner Join [dbo].[Empleado] E
On V.[ID_Empleado] = E.[ID_Empleado]

)
Go
-----------------
-----------------

Create View VentaReport
As(
Select D.[ID_DetalleVenta], D.[ID_Venta], VV.Nombre_Cliente, VV.Fecha_Venta, VV.Nombres_Empleado, VV.Apellidos_Empleado, 
P.[Nombre_Producto], D.[Unidades_Vendidas], D.[Precio_Venta], VV.Descuento,(D.Precio_Venta*Unidades_Vendidas)-((VV.Descuento/100)*(D.Precio_Venta*Unidades_Vendidas)) as [Total_Venta]
from [dbo].[DetalleVenta] D
Inner Join [dbo].[Producto] P
On D.[ID_Producto] = P.[ID_Producto]
Inner Join VentaV VV
On D.ID_Venta= VV.ID_Venta
)
Go
-----------------
-----------------

/* ***TRIGGERS*** */

---1---
Create Trigger  Aumentar_ExistenciaProducto
On [dbo].[DetalleCompra]
For Insert
As

Declare @UnidxCaja int, @ID_Producto int, @UnidsT int, @UnidsVend int
Set @ID_Producto = (Select ID_Producto from Inserted)
Set @UnidxCaja = (Select UnidsXCaja from Producto where ID_Producto = @ID_Producto)
Set @UnidsVend = (Select [Unidades_Compradas] from Inserted)
Set @UnidsT = @UnidsVend/ @UnidxCaja


Begin
Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] + @UnidsT
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]

End

Go
-----------------
-----------------

---2---
Create Trigger  Disminuir_ExistenciaProducto
On [dbo].[DetalleVenta]
For Insert
As

Declare @UnidxCaja int, @ID_Producto int, @UnidsT int, @UnidsVend int
Set @ID_Producto = (Select ID_Producto from Inserted)
Set @UnidxCaja = (Select UnidsXCaja from Producto where ID_Producto = @ID_Producto)
Set @UnidsVend = (Select [Unidades_Vendidas] from Inserted)
Set @UnidsT = @UnidsVend/ @UnidxCaja

Begin
Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] - @UnidsT
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]
End

Go
-----------------
-----------------


Create Trigger  Disminuir_ExistenciaCompra
On [dbo].[DetalleCompra]
For Update
As

Declare @UnidxCaja int, @ID_Producto int, @UnidsT int, @UnidsVend int, @Estado nvarchar(10)
Set @ID_Producto = (Select ID_Producto from Inserted)
Set @UnidxCaja = (Select UnidsXCaja from Producto where ID_Producto = @ID_Producto)
Set @UnidsVend = (Select [Unidades_Compradas] from Inserted)
Set @UnidsT = @UnidsVend/ @UnidxCaja

Set @Estado = (Select Estado_DetCompra from Inserted)

if(@Estado = 'Inactivo')
Begin
Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] - @UnidsT
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]

End

Go
-----------------
-----------------


---3---
Create Trigger  Disminuir_ExistenciaProductoDevuelto
On [dbo].[DevolucionCompra]
For Insert
As

Begin

Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] - Inserted.[Unidades_Devueltas]
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]

Update [dbo].[DetalleCompra]
Set [UnidsEnInventario] = [UnidsEnInventario] - Inserted.[Unidades_Devueltas]
From  Inserted 
Where [dbo].[DetalleCompra].[ID_DetalleCompra] = Inserted.[ID_DetalleCompra]


End

Go
-----------------
-----------------

---4---
Create Trigger  Des_Act_Producto
On [dbo].[Proveedor]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_Proveedor] from Inserted)

If(@Estado='Inactivo')
Begin
Update [dbo].[Producto]

Set [Estado_Producto] = 'Inactivo'
From  Inserted 
Where [dbo].[Producto].[ID_Proveedor] = Inserted.[ID_Proveedor]

End

If(@Estado= 'Activo')
Begin
Declare @DesactDirect nvarchar (5), @ID_Proveedor int
Set @ID_Proveedor = (Select [ID_Proveedor] from Inserted)
Set @DesactDirect = (Select [Desactivado_Directament] from [dbo].[Producto] where [dbo].[Producto].[ID_Proveedor] = @ID_Proveedor)

if(@DesactDirect = 'No')
Begin
Update [dbo].[Producto]

Set [Estado_Producto] = 'Activo'
From  Inserted 
Where [dbo].[Producto].[ID_Proveedor] = Inserted.[ID_Proveedor]

End
End


End

Go
-----------------
-----------------


---4---
Create Trigger  Des_Act_Cliente
On [dbo].[ClienteJuridico]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_ClienteJuridico] from Inserted)

If(@Estado='Inactivo')
Begin
Update [dbo].[Cliente]

Set [Estado_Cliente] = 'Inactivo'
From  Inserted 
Where [dbo].[Cliente].[ID_ClienteJuridico] = Inserted.[ID_ClienteJuridico]

End

If(@Estado= 'Activo')
Begin
Declare @DesactDirect nvarchar (5), @ID_ClienteJuridico int
Set @ID_ClienteJuridico = (Select [ID_ClienteJuridico] from Inserted)
Set @DesactDirect = (Select [Desactivado_Directament] from [dbo].[Cliente] 
where [dbo].[Cliente].[ID_ClienteJuridico] = @ID_ClienteJuridico)

if(@DesactDirect = 'No')
Begin
Update [dbo].[Cliente]

Set [Estado_Cliente] = 'Activo'
From  Inserted 
Where [dbo].[Cliente].[ID_ClienteJuridico] = Inserted.[ID_ClienteJuridico]

End
End


End

Go
-----------------
-----------------
---4---
Create Trigger  Des_Act_Ejecutivo
On [dbo].[Proveedor]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_Proveedor] from Inserted)

If(@Estado='Inactivo')
Begin

Update [dbo].[Ejecutivo]

Set [Estado_Ejecutivo] = 'Inactivo'
From  Inserted 
Where [dbo].[Ejecutivo].[ID_Proveedor] = Inserted.[ID_Proveedor]

End

If(@Estado= 'Activo')
Begin

Declare @DesactDirect nvarchar (5), @ID_Proveedor int
Set @ID_Proveedor = (Select [ID_Proveedor] from Inserted)
Set @DesactDirect = (Select [Desactivado_Directament] from [dbo].[Ejecutivo] where [dbo].[Ejecutivo].[ID_Proveedor] = @ID_Proveedor)

if(@DesactDirect = 'No')
Begin

Update [dbo].[Ejecutivo]

Set [Estado_Ejecutivo] = 'Activo'
From  Inserted 
Where [dbo].[Ejecutivo].[ID_Proveedor] = Inserted.[ID_Proveedor]

End
End


End

Go
-----------------
-----------------



---5---
Create Trigger  Des_Act_Usuario
On [dbo].[Empleado]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_Empleado] from Inserted)

If(@Estado='Inactivo')
Begin
Update [dbo].[Usuario]

Set [Estado_Usuario] = 'Inactivo'
From  Inserted 
Where [dbo].[Usuario].[ID_Empleado] = Inserted.[ID_Empleado]

End

If(@Estado= 'Activo')
Begin

Update [dbo].[Usuario]

Set [Estado_Usuario] = 'Activo'
From  Inserted 
Where [dbo].[Usuario].[ID_Empleado] = Inserted.[ID_Empleado]

End

End

Go
-----------------
-----------------

---6---
Create Trigger Actualizar_PV
On [dbo].[DetalleCompra]
For Insert
As

Begin


Declare @Producto int --, @Margen money --@Modo nvarchar(20),
set @Producto = (Select ID_Producto from inserted)
--Set @Modo = (Select Modo_Margen from Producto where ID_Producto = @Producto)
--Set @Margen = (Select Margen_Ganancia from Producto where ID_Producto = @Producto)

--if(@Modo = 'Porcentaje')
--Begin

/*
Declare @Costo money, @MargenDiv money, @MargenFinal money, @PrecioV money
Set @Costo = (Select Costo_Compra from inserted)
Set @MargenDiv = @Margen/100
Set @MargenFinal = @Costo * @MargenDiv
Set @PrecioV = @Costo + @MargenFinal*/


Declare @PrecioAnterior money
Set @PrecioAnterior = (Select Precio_Venta from Producto where ID_Producto = @Producto)

Declare @PrecioV money, @UnidxCaja int, @PrecioVenta money
Set @UnidxCaja = (Select UnidsXCaja from Producto where ID_Producto = @Producto)
Set @PrecioV = (Select [Costo_Compra] from inserted)
Set @PrecioVenta = @PrecioV * @UnidxCaja

if(@PrecioVenta>@PrecioAnterior)
Begin

Update [dbo].[Producto]
Set [Precio_Venta] = @PrecioVenta --* ([Margen_Ganancia] / 100 )
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]

End
--End
/*
if(@Modo = 'Dinero')
Begin

Declare @Costo2 money, @PrecioV2 money, @Producto2 int
Set @Costo2 = (Select Costo_Compra from inserted)
Set @PrecioV2 = @Costo2 + @Margen

set @Producto2 = (Select ID_Producto from inserted)

Declare @PrecioAnterior2 money
Set @PrecioAnterior2 = (Select Precio_Venta from Producto where ID_Producto = @Producto)

if(@PrecioV2>@PrecioAnterior2)
Begin

Update [dbo].[Producto]
Set [Precio_Venta] = @PrecioV2 --* ([Margen_Ganancia] / 100 )
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]
End

End
*/



End

Go

---4---
Create Trigger  Des_Compras
On [dbo].[Compra]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_Compra] from Inserted)

If(@Estado='Anulada')
Begin
Update [dbo].[DetalleCompra]
Set [Estado_DetCompra] = 'Inactivo'
From  Inserted 
Where  [dbo].[DetalleCompra].[ID_Compra] =  Inserted.[ID_Compra]

End


End

Go
-----------------
-----------------


---4---
Create Trigger  DisminUnidsDispon_CompraAnulada
On [dbo].[DetalleCompra]
After Update
As

Begin

Declare @Estado nvarchar (10) 
Set @Estado= (Select [Estado_DetCompra] from Inserted)

If(@Estado='Inactivo')
Begin
Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] - inserted.Unidades_Compradas
From  Inserted 
Where  [dbo].[Producto].[ID_Producto] =  Inserted.[ID_Producto]

End


End

Go

-----------------
-----------------



/*   ***ROLES***   */

/*
Create Role Publico
Go


Grant select on [dbo].[InventarioV] to Publico
Grant select on [dbo].[Cliente] to Publico
Grant select on [dbo].[TipoCambio] to Publico
Grant select on [dbo].[VentaV] to Publico
Grant select on [dbo].[DetalleVentaV] to Publico
Grant select on [dbo].[ProductosV] to Publico
Grant select on [dbo].[EjecutivosV] to Publico
Grant select on [dbo].[ComprasV] to Publico
Grant select on [dbo].[DetalleCompraV] to Publico
Grant select on [dbo].[Proveedor] to Publico
Grant select on [dbo].[InventarioV] to Publico

Grant insert on [dbo].[Venta] to Publico
Grant insert on [dbo].[DetalleVenta] to Publico

Grant update on [dbo].[Producto] to Publico
Grant update on [dbo].[DetalleCompra] to Publico
Grant update on [dbo].[Cliente] to Publico
Grant update on [dbo].[Usuario] to Publico

Grant execute on [dbo].[Actualizar_Cliente] to Publico
Grant execute on [dbo].[Agregar_Venta] to Publico
Grant execute on [dbo].[CambiarContrasena_Usuario] to Publico
Grant execute on [dbo].[DisminuirInventario] to Publico

*/

Use SistemaFarmacia
Go

Create Login Administrador with password = '1234'
Go

sp_adduser Administrador , Administrador
Go

sp_addrolemember [db_owner], [Administrador]
Go

sp_addsrvrolemember [Administrador], [sysadmin]
Go

Insert into Empleado Values ('SuperAdministrador','Administrador', '*', '*', '*', '*', '*', null, 'Activo', GETDATE(), null, 0,0);

Insert Into Usuario Values (1,'Administrador', '1234', 'Activo', 'Administrador', null, GETDATE());

Insert Into Cliente Values (null, 'No', '*', '*','*','*','*',0,'*','*','Activo','*',GETDATE(),1,'No')

Insert Into Tipo_Cambio values(24.1,'No',GETDATE(),1)

------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------

---8---

-----------------
-----------------



/*

Create View DetalleCompraDevolV
As(
Select D.[ID_DetalleCompra], E.Nombres_Empleado, E.Apellidos_Empleado, EJ.Nombres_Ejecutivo, EJ.Apellidos_Ejecutivo,
 PR.[Nombre_Producto], P.[Nombre_Proveedor],  CP.[Fecha_Compra], D.[Fecha_Vencimiento],  D.[Unidades_Compradas],
  D.[Costo_Compra], D.[Descuento],D.[Total_Compra], D.[ModoAdquisicion], D.[UnidsEnInventario]

from [dbo].[Compra] C
Inner Join [dbo].[DetalleCompra] D
On D.[ID_Compra] = C.[ID_Compra]
Inner Join [dbo].[Producto] PR
On D.[ID_Producto] = PR.[ID_Producto]
Inner Join [dbo].[Compra] CP
On D.[ID_Compra] = CP.[ID_Compra]
Inner Join [dbo].[Proveedor] P
On CP.[ID_Proveedor] = P.[ID_Proveedor]
Inner Join [dbo].[Ejecutivo] EJ
On CP.[ID_Ejecutivo] = EJ.[ID_Ejecutivo]
Inner Join [dbo].[Empleado] E
On CP.[ID_Empleado] = E.[ID_Empleado]
)
Go




---6---
Create View DevolucionesComprasV
As(
Select DV.[ID_DevolucionCompra], E.[Nombres_Empleado], E.[Apellidos_Empleado], DV.[Fecha_Devolucion], D.[Fecha_Vencimiento]
,PR.[Nombre_Producto], P.[Nombre_Proveedor], D.[Unidades_Compradas],  D.[Costo_Compra], DV.[Unidades_Devueltas], DV.[Costo_Devolucion], DV.[Total_Devuelto]
from [dbo].[DevolucionCompra] DV
Inner Join [dbo].[DetalleCompra] D
On DV.[ID_DetalleCompra] = D.[ID_DetalleCompra]
Inner Join [dbo].[Producto] PR
On D.[ID_Producto] = PR.[ID_Producto]
Inner Join [dbo].[Empleado] E
On DV.[ID_Empleado] = E.[ID_Empleado]
Inner Join [dbo].[Proveedor] P
On PR.[ID_Proveedor] = P.[ID_Proveedor]
)
Go



---10---
Create View DetalleVentaV
As(
Select D.[ID_DetalleVenta], D.[ID_Venta], P.[Nombre_Producto], D.[Unidades_Vendidas], D.[Precio_Venta], D.[Total_Venta]
from [dbo].[DetalleVenta] D
Inner Join [dbo].[Producto] P
On D.[ID_Producto] = P.[ID_Producto]
)
Go



---11---
Create View InventarioInactivoV
As(
Select I.[ID_InventarioInactivo], E.[Nombres_Empleado], E.[Apellidos_Empleado], I.[FechaInactiva], P.[Nombre_Producto], 
PR.[Nombre_Proveedor],I.[Unidades_Inactivas], I.[CostoUnit], I.[Total_Perdida]
from [dbo].[InventarioInactivo] I
Inner Join [dbo].[DetalleCompra] D
On I.[ID_DetalleCompra] = D.[ID_DetalleCompra]
Inner Join [dbo].[Producto] P
On I.[ID_Producto] = P.[ID_Producto]
Inner Join  [dbo].[Empleado] E
On I.[ID_Empleado] = E.[ID_Empleado]
Inner Join [dbo].[Proveedor] PR
On P.[ID_Proveedor] = PR.[ID_Proveedor]
)
Go
-----------------
-----------------


---6---
Create Trigger  Disminuir_ExistenciaInventInact
On [dbo].[InventarioInactivo]
For Insert
As

Begin

Update [dbo].[Producto]
Set [Unidades_Disponibles] = [Unidades_Disponibles] - Inserted.[Unidades_Inactivas]
From  Inserted 
Where [dbo].[Producto].[ID_Producto] = Inserted.[ID_Producto]

Update [dbo].[DetalleCompra]
Set [UnidsEnInventario] = [UnidsEnInventario] - Inserted.[Unidades_Inactivas]
From  Inserted 
Where [dbo].[DetalleCompra].[ID_DetalleCompra] = Inserted.[ID_DetalleCompra]

End

Go
-----------------
-----------------


--13---
Create Procedure Agregar_Devolucion(
@ID_DetalleCompra int,
@Nombre_Producto nvarchar (50),
@Unidades_Devueltas int,
@Costo_Devolucion money, 
@Total_Devuelto money,
@ID_Empleado int,
@Dia int,
@Mes int,
@Ano int

)

As
Begin

Begin try

Declare @ID_Producto int, @Fecha_Devolucion date
Set @Fecha_Devolucion = DateFromParts(@Ano, @Mes, @Dia)
Set @ID_Producto = (Select [ID_Producto] from [dbo].[Producto] where [Nombre_Producto] = @Nombre_Producto)

Insert Into [dbo].[DevolucionCompra]
           ([ID_DetalleCompra],
		   [Fecha_Devolucion],
		   [ID_Producto],
		   [Unidades_Devueltas],
		   [Costo_Devolucion],
		   [Total_Devuelto],
		   [ID_Empleado]
           )

     Values
           (@ID_DetalleCompra, @Fecha_Devolucion, @ID_Producto, @Unidades_Devueltas, @Costo_Devolucion, 
		   @Total_Devuelto, @ID_Empleado)
End try

Begin catch
Raiserror('ERROR AL AGREGAR DEVOLUCIÓN COMPRA',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------

--13---
Create Procedure Desactivar_Inventario(
@ID_DetalleCompra int,
@Nombre_Producto nvarchar (50),
@Unidades_Inactivas int,
@CostoUnit money, 
@Total_Perdida money,
@ID_Empleado int,
@Dia int,
@Mes int,
@Ano int

)

As
Begin

Begin try

Declare @ID_Producto int, @FechaInactiva date
Set @FechaInactiva = DateFromParts(@Ano, @Mes, @Dia)
Set @ID_Producto = (Select [ID_Producto] from [dbo].[Producto] where [Nombre_Producto] = @Nombre_Producto)

Insert Into [dbo].[InventarioInactivo]
           ([ID_DetalleCompra],
		   [ID_Producto],
		   [FechaInactiva],
		   [Unidades_Inactivas],
		   [CostoUnit],
		   [Total_Perdida],
		   [ID_Empleado]
           )

     Values
           (@ID_DetalleCompra, @ID_Producto, @FechaInactiva, @Unidades_Inactivas, @CostoUnit, @Total_Perdida, @ID_Empleado)
End try

Begin catch
Raiserror('ERROR AL DESACTIVAR INVENTARIO',10,1)
Rollback Tran

End catch

End

Go
--------------
--------------




-------------------------------------
-------------------------------------

*/



