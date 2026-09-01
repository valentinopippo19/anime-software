<<<<<<< HEAD
# Sistema de Gestión de FRANXX

Proyecto Java 17 con Swing, organizado por paquetes y basado en:
- POO: encapsulamiento, abstracción, herencia y polimorfismo.
- Factory: creación de FRANXX.
- Strategy: estrategias de combate.
- State: estados operativos.
- Observer: notificaciones al Centro de Comando, Mantenimiento y Registro de Misiones.

## Ejecutar

Con Maven:
```bash
mvn clean compile
mvn exec:java
```

También puede ejecutarse `com.darling.franxx.Main` desde IntelliJ IDEA, Eclipse o NetBeans.

## Interfaz

La aplicación permite:
- Ver FRANXX y sus datos.
- Crear FRANXX mediante Factory.
- Asignar pilotos.
- Cambiar estrategia.
- Iniciar misión.
- Atacar un Klaxosaurio.
- Simular daño y reparación.
- Ver el registro de eventos.
=======
# 🌙 Anime Software — Sailor Moon

Aplicación de escritorio desarrollada en **Java** con **Java Swing**, inspirada en el universo de *Sailor Moon*.

## 📌 Descripción

Este proyecto consiste en un software desarrollado como trabajo académico, utilizando programación orientada a objetos y patrones de diseño.

La aplicación permite gestionar diferentes elementos relacionados con el universo de Sailor Moon, como:

* 🌙 Sailor Scouts
* ⚔️ Ataques
* 👾 Enemigos
* 🌍 Planetas
* 🎯 Misiones
* 🏆 Rangos
* 👥 Equipos
* 📜 Historiales

## 🛠️ Tecnologías utilizadas

* **Java 21**
* **Java Swing** — Interfaz gráfica
* **Visual Studio Code**
* **Git**
* **GitHub**
* Programación Orientada a Objetos (POO)
* Patrones de diseño

## 📂 Estructura del proyecto

```text
SailorMoon/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── sailormoon/
│                   ├── Main.java
│                   ├── modelo/
│                   │   ├── Ataque.java
│                   │   ├── Enemigo.java
│                   │   ├── Equipo.java
│                   │   ├── EstadoMision.java
│                   │   ├── HistorialEquipo.java
│                   │   ├── HistorialRango.java
│                   │   ├── Mision.java
│                   │   ├── Planeta.java
│                   │   ├── Rango.java
│                   │   ├── SailorScout.java
│                   │   └── UsoAtaque.java
│                   │
│                   └── vista/
│                       ├── FondoPanel.java
│                       └── VentanaPrincipal.java
│
└── README.md
```

## 🚀 Ejecución

### Requisitos

Para ejecutar el proyecto se necesita:

* Java JDK 21 o superior.
* Visual Studio Code o cualquier IDE compatible con Java.

### Ejecutar desde la terminal

Desde la carpeta del proyecto:

```bash
javac -d bin src/main/java/com/sailormoon/**/*.java
```

Luego:

```bash
java -cp bin com.sailormoon.Main
```

También puede ejecutarse directamente desde Visual Studio Code utilizando la extensión de Java.

## 🎨 Interfaz

La aplicación cuenta con una interfaz gráfica desarrollada utilizando **Java Swing**, incluyendo recursos visuales relacionados con Sailor Moon.

## 📚 Documentación

El repositorio incluye documentación relacionada con el desarrollo del proyecto, incluyendo:

* Diagrama de clases.
* Documentación de patrones de diseño.
* Capturas de la interfaz.
* Material complementario del proyecto.

## 👨‍💻 Autor

**Valentino Pippo**

Proyecto académico — Anime Software / Sailor Moon.

## 📄 Licencia

Este proyecto fue desarrollado con fines educativos.
>>>>>>> d284e94f6daecec55ae8b5f477256c915860a47b
