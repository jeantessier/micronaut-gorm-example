# GORM Test

A trivial Micronaut app that uses GORM to talk to a MySQL database.

There is a single domain class `User` that uses UUIDs for its IDs.

## Create the Schema

    create database if not exists gormtest character set utf8;

## To Run

    $ ./gradlew run

## Sample Queries

Get a list of all users in the system:

    $ http :8080/users | jq '.'

Create a new user:

    $ http :8080/users fullname='Jean Tessier' emailAddress=jean@jeantessier.com password=abbcd1234

View a single user:

    $ http :8080/users/562b6532-c67d-4f84-b5e0-f76ba1c19714 | jq '.'

Edit a user:

    $ http PATCH :8080/users/562b6532-c67d-4f84-b5e0-f76ba1c19714 emailAddress=dependencyfinder@gmail.com | jq '.'

Delete a user:

    $ http DELETE :8080/users/562b6532-c67d-4f84-b5e0-f76ba1c19714

Delete all users:

    $ http DELETE :8080/users
