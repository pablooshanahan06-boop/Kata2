# Kata 2: Entrada, salida y carga de datos

## Objetivo
El objetivo de esta práctica es demostrar la separación de responsabilidades en la lectura, transformación y escritura de datos, implementando una arquitectura de puertos y adaptadores. Se procesa un conjunto de datos (dataset tabular de empleados) utilizando flujos genéricos (`InputStream` y `OutputStream`) aislados completamente de la lógica de negocio.

## Compilación y Ejecución
- **Dependencias:** Java 17 o superior. No se requieren librerías externas.
- **Ejecución:** Ejecutar la clase `Main.java` ubicada en `software.ulpgc.Main`.

## Estructura de Clases Principales
El proyecto está dividido en los siguientes paquetes para garantizar el *Clean Code*:
- `software.ulpgc.domain`: Contiene las entidades inmutables `Employee` (Record) y `Gender` (Enum).
- `software.ulpgc.io`: Define los contratos (interfaces) `EmployeeLoader`, `EmployeeDeserializer` y `StatisticsWriter`, así como sus implementaciones concretas para TSV (`StreamEmployeeLoader`, `TsvEmployeeDeserializer`, `TsvStatisticsWriter`).
- `software.ulpgc.statistic`: Contiene la lógica de negocio pura (`GenderFrequencyCalculator`) que procesa la colección de entidades.

## Proceso de Repetición Deliberada
La kata se ha repetido tres veces (visible en el historial de commits) introduciendo pequeñas variaciones para demostrar la flexibilidad de la arquitectura:
1. **Iteración 1:** Lectura desde un fichero local (`FileInputStream`) y escritura en consola (`System.out`).
2. **Iteración 2:** Lectura desde una URL de internet (`url.openStream()`) y escritura en un nuevo fichero físico local (`FileOutputStream`).
3. **Iteración 3:** Lectura desde fichero local y escritura directa en memoria RAM (`ByteArrayOutputStream`).

## Evidencias de Verificación
- [x] Prueba con fichero correcto local.
- [x] Prueba con URL remota como origen.
- [x] Prueba de escritura tanto en consola como en fichero y memoria.
- [x] Tratamiento de errores controlado: El sistema detecta filas mal formadas (ej. género inválido en la fila de "George") mostrando un aviso por consola (`Optional.empty()`) sin detener la ejecución.

## Vídeo Explicativo
[Enlace al vídeo en YouTube/Drive]