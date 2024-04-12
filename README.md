# Insurance Api

## About the Service
The api object is to save and update given insurances in database.

It is added the taxed price to database:
The taxes are calculated using the following formula:

* Preço Tarifado = Preço Base + (Preço Base x IOF) + (Preço Base x PIS) + (Preço Base x COFINS)

The taxes used are the following:

| **Categoria** | **Imposto sobre Operação Financeira (IOF)** | **Programa de Integração Social (PIS)** | **Contribuição para o Financiamento da Seguridade Social (COFINS)** |
|---------------|---------------------------------------------|-----------------------------------------|---------------------------------------------------------------------|
| VIDA          | 1%                                          | 2.2%                                    | Não há                                                              |
| AUTO          | 5.5%                                        | 4%                                      | 1%                                                                  |
| VIAGEM        | 2%                                          | 4%                                      | 1%                                                                  |
| RESIDENCIAL   | 4%                                          | Não há                                  | 3%                                                                  |
| PATRIMONIAL   | 5%                                          | 3%                                      | Não há                                                              |

## Technologies

* Kotlin
* Spring Boot
* Maven
* H2 database
  * Database with a good performance in local and smaller projects, also have an easy integration with spring boot apis


## How to Run
To run this application it is necessary:
* Run the api - easier in IDE´s like Intellij - in the start file "InsuranceApplication.kt"
  * Can be used the command: Ctrl + F5 in the file
* To establish the connection with H2 database, copy the property "url", located on the start log
  * Access the url: localhost:8080/h2-console
  * At JBDC URL paste the copied url
    ![img.png](img.png)
* Now you are ready to access the endpoints locally :).

## Endpoints

Here are the endpoints you can call:

### Create an insurance

* POST <b>/insurance</b>

Request Body:
```
{
    "nome": "Seguro de Vida Individual",
    "categoria": "VIDA",
    "preco_base": 100.00
}
```

RESPONSE: HTTP 201 (Created)
```
{
    "id": 1,
    "nome": "Seguro de Vida Individual",
    "categoria": "VIDA",
    "preco_base": 100.00,
    "preco_tarifado": 106.00
}
```

* PUT <b>/insurance/{id}</b>
  * "id" it is the property returned when you create a new insurance


Request Body:

```
{
    "nome": "Novo nome do Seguro",
    "categoria": "VIDA",
    "preco_base": 100.00
}
```

RESPONSE: HTTP 200 (OK)
```
{
    "id": 1,
    "nome": "Novo nome do Seguro",
    "categoria": "VIDA",
    "preco_base": 100.00,
    "preco_tarifado": 106.00
}
```

## Improvements - To be Done

* Add more tests
  * The code coverage was small, it is necessary to add more unit and integration tests at least - was added one example of each, but it is necessary to add more.
* Add a dynamic documentation, like Swagger to make the api easier to be reused and understandable to non-technical users
* Add authentication logic, using JWT token, for example. In real life apis it is necessary to identify the user, mainly to alter database data.
* Add logging and metrics - using Grafana for example - to improve observability and incidents/errors resolution
