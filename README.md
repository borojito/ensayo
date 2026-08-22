# Consulta Impuestos de un Carro

Aplicación de escritorio en Java (Swing) que calcula el impuesto de vehículos automotores en Colombia, según la Ley 488 de 1998, a partir del valor comercial del carro.

**Autora:** Stefania Borja

## Descripción

El impuesto se calcula aplicando una tarifa progresiva sobre el valor comercial del vehículo:

| Valor comercial (COP)                  | Tarifa |
|-----------------------------------------|--------|
| Hasta $54.057.000                       | 1.5%   |
| Entre $54.057.001 y $121.635.000        | 2.5%   |
| Mayor a $121.635.000                    | 3.5%   |

Los vehículos de **uso público** reciben un descuento del **20%** sobre el impuesto calculado.

## Estructura del proyecto (MVC)

```
src/
├── Main.java                      # Punto de entrada de la aplicación
├── model/
│   ├── Carro.java                 # Datos del vehículo (marca, modelo, año, valor comercial, cilindraje, uso público)
│   └── CalculadoraImpuesto.java   # Lógica de negocio: tarifas y cálculo del impuesto
├── controller/
│   └── CarroController.java       # Coordina la vista con el modelo
└── view/
    └── CalculadoraView.java       # Interfaz gráfica (Swing)
```

- **Model**: representa los datos del carro y las reglas del impuesto.
- **View**: formulario Swing donde se ingresan los datos y se muestra el resultado.
- **Controller**: recibe los datos desde la vista, delega el cálculo al modelo y devuelve el resultado.

## Requisitos

- JDK 17 o superior.

## Uso

1. Completar los campos: marca, modelo, año, valor comercial y cilindraje.
2. Marcar la casilla **Uso público** si aplica.
3. Hacer clic en **Calcular Impuesto**.
4. La aplicación muestra el valor del impuesto y la tarifa aplicada.
