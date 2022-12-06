# RESTAPIContactsApplication

Small Spring Boot application to revise the concepts of REST API
- Defined a REST controller which act as a mediator between the resources and the consumer
- Created a service implementation that implements a service interface to help achieve loose coupling
- GET, POST, PUT, DELETE operations
- Wrote integrations tests with MockMVC which traverse all of the application's layers from the controller to the service to the repository and it makes sure that all of these layers are communicating effectively, by receiving the requests, processing the operations and returning the appropriate responses
- Making use of Postman to make requests ( did not develop a frontend in order to test the API )
