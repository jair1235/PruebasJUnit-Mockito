# PruebasJUnit-Mockito
Proyecto: Pruebas Unitarias con JUnit y Mockito
Descripción del proyecto
El proyecto está compuesto por dos clases principales:
 Cliente
Representa un cliente del banco y contiene:
Atributos: nombre y saldo
Métodos:
consultarSaldo()
consignarDinero(double monto)
retirarDinero(double monto)
Uso de getters y setters
 Banco
Gestiona los clientes y las operaciones del sistema:
Crear clientes
Consultar la caja total (suma de los saldos de todos los clientes)
Registrar operaciones de consignación y retiro
🧪 Pruebas Unitarias
Las pruebas se encuentran en src/test/java y se realizaron usando:
JUnit 5: para validar la lógica de negocio de las clases.
Mockito: para simular objetos Cliente al probar la clase Banco, permitiendo el aislamiento de dependencias.
Se probaron:
Casos válidos e inválidos
Comportamiento esperado ante errores
Estado final de los objetos
