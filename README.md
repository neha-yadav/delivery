# Delivery system project

Backend project (API) for a order delivery application.
Prerequisites - to be run in combination with restaurant service 

## Model entities


`Item` - the actual items that can be ordered by customers

`Order` - set of items ordered by a customer from a restaurant

`DeliveryPerson` - person delivering the order

## Setup & Run

- `clone`
- `mvn spring-boot:run`
- go to `http://localhost:8082/swagger-ui.html#/` to see the available endpoints

## API Docs

Available at: `http://localhost:8082/swagger-ui.html#/`

## Test endpoints with Postman

Test this application endpoints with Postman:

- Start it and import `delivery.postman_collection.json` which is a collection of example requests.

## Persistence layer

For this project I used embedded [H2 Database]. Since I am also using an ORM solution (Hibernate) it could be switched to another database solution with no major issues.
