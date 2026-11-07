# Pizzeria

A Java Servlet and JSP application for managing pizzeria clients, pizza makers and orders.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>

## Features

- Add, edit, list and delete clients and pizza makers.
- Manage orders linking a client, pizza, pizza maker and order dates.
- Persist records in a local, file-backed HSQLDB database.

## Stack

Java · Servlets 3 · JSP · JDBC · HSQLDB · Maven · Jetty

## Run locally

Use JDK 8 and Maven for the original servlet/Jetty toolchain. Run from the repository root
so the relative `testdb` database path resolves beside the supplied database files.

```bash
mvn package
mvn jetty:run
```

Open `http://localhost:8080/web-project/` with the default Jetty context derived
from the WAR name. Check the Jetty startup log if you override that context.

## Project layout

| Location | Contents |
| --- | --- |
| [models](src/main/java/models) | Client, pizza maker, pizza and order models |
| [servlets](src/main/java/servlets) | Create, update and delete handlers |
| [DAO.java](src/main/java/utils/DAO.java) | JDBC persistence |
| [webapp](src/main/webapp) | JSP pages, styles and servlet mappings |
| [pom.xml](pom.xml) | WAR packaging and embedded Jetty configuration |

The database is opened as `jdbc:hsqldb:file:testdb`. Keep its files together when
moving the application; the repository also includes a database archive.

## ☕ Support the project

If this project helps you learn or build, you can support its development.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>
