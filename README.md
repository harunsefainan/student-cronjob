<div align="center">
<h1>Student Cronjob</h1>


![GitHub Issues](https://img.shields.io/github/issues/harunsefainan/student-server)
![GitHub License](https://img.shields.io/github/license/harunsefainan/student-server)
![GitHub Pull Requests](https://img.shields.io/github/issues-pr/harunsefainan/student-server)
![GitHub Forks](https://img.shields.io/github/forks/harunsefainan/student-server)
![GitHub Stars](https://img.shields.io/github/stars/harunsefainan/student-server)

| [English](README.md) | [Turkish](./docs/README_TR.md) |

<a href="https://github.com/harunsefainan/student-server/tree/master/docs"><strong>Explore the more
documentation »</strong></a>
</div>

## Project Overview

This project retrieves student information from the [Student-Server](https://github.com/harunsefainan/student-server)
project, calculates the remaining course duration daily for each student, and stores this information in the database.
This enables the system to keep records up to date and manage course progress effectively. The primary goal of the
project is to ensure accurate and up-to-date information is automatically updated and stored in the database.

## Getting Started

### Install Java 17

- This application requires Java 17.
- Please click the link below to download and install
  Java-17: [Java-17](https://www.oracle.com/java/technologies/downloads/#java17)

### Install Gradle 8.7

- This application requires Gradle-8.7.
- Please click the link below to download and install Gradle-8.7: [Gradle-8.7](https://gradle.org/releases/)

### Install & Setup Database

- This application requires MySQL 8.
- Please click the link below to download and install MySQL-8: [MySQL-8](https://dev.mysql.com/downloads/installer/)
- You can use the following file to create a database: [db_setup.sql](./docs/database/db_setup.sql)

### Install Student-Server Project

- To download student information from the Student-Server project, you can access the project at the following
  address: [Student-Server](https://github.com/harunsefainan/student-server)

### Running the application

- Clone the repo
   ```sh
   git clone https://github.com/harunsefainan/student-cronjob
   ```
- Open the project in IntelliJ IDEA or any suitable IDE of your choice.
- Run the project.
- You can track updates through log records.

## Project Details

![System Context](docs/images/readme/student-ing.png)

### Database

- Entity Models

![Entity Modesl](docs/images/readme/student-entity.png)

## Built With

 <p align="center">
      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png" width="155" height="50" alt="Spring Boot" title="Spring Boot 17" class="img-small">
      <img src="https://raw.githubusercontent.com/docker-library/docs/c3d3ca6beed000f9ba6eabc98f3399158f520256/gradle/logo.png" width="155" height="50" alt="Gradle" title="Gradle" class="img-small">
      <img src="https://cogitech.pl/wp-content/uploads/2023/02/Swagger-logo.png" height="50" alt="Swagger" title="OpenAPI 2.0.4" class="img-small">
      <img src="https://cdn-icons-png.flaticon.com/512/5968/5968282.png" width="50" height="50" alt="Java" title="Java 17" class="img-small">
      <img src="https://cdn-icons-png.flaticon.com/512/5968/5968313.png" width="50" height="50" alt="" title="MySQL Workbench 8.0" class="img-small">
   </p>

  <hr>
<div align="center">
   <a href="mailto: harunsefa.inan@gmail.com" target="blank"><img align="center" src="https://cdn-icons-png.flaticon.com/512/9840/9840614.png" height="40" width="40" /></a>
   <a href="https://www.linkedin.com/in/harun-sefa-inan-761a2324b/" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg"  height="30" width="40" /></a>
</div>
<hr> 




<p align="right">(<a href="#top">back to top</a>)</p>