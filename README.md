# Agenda de Contactos - Proyecto Spring Boot + MariaDB

Este es un proyecto de agenda web desarrollado con Spring Boot, que incluye funcionalidades CRUD y despliegue en una máquina virtual Debian usando `systemd`, conexión a base de datos MariaDB, y ejecución desde el host a través de red NAT con reenvío de puertos.

---

##Tecnologías utilizadas

- Java 17
- Spring Boot (con Thymeleaf)
- Gradle
- MariaDB
- Git + GitHub
- VirtualBox + Debian sin GUI
- systemd (para ejecución como servicio)
- Reenvío de puertos NAT

---

## Funcionalidades del proyecto

- Registro, actualización, listado y eliminación de contactos.
- Interfaz web con Thymeleaf.
- Base de datos persistente MariaDB,también instalada en la MV.
- Empaquetado en `.jar` con Gradle.
- Despliegue en Debian como servicio con `systemd`.
- Acceso desde el host por navegador o Postman.
- Red NAT y reenvío de puertos configurado manualmente.

---

## Estructura de despliegue

```plaintext
[Host Windows 11]
    |
    | (scp + ssh)
    v
[VM Debian]
 ├─ Spring Boot app (servicio systemd)
 └─ MariaDB (instalada en la MV)
