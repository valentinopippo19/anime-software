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
