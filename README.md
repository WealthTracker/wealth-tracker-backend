# WealthTracker

WealthTracker is a powerful wealth monitoring application that allows users to track and manage their financial assets
and investments. Gain insights into your net worth, portfolio performance, and asset allocations all in one place.
Record and analyze transactions, view historical performance, and make informed financial decisions. Whether you're a
seasoned investor or just starting on your financial journey, WealthTracker provides the tools you need to take control
of your wealth and plan for a prosperous future.

## Prerequisites

- jdk 19
- maven 3.6.1 or higher
- docker 1.6.0 or higher (<https://www.docker.com/>)

## Docker

Starting Postgres

```shell
$ docker compose up -d
```

## Build & startup

```shell
$ mvn clean install
```

```shell
$ mvn spring-boot:run
```
## Functionalities
### List of the assets
http://localhost:8080/v1/assets
