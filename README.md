# External microservice
This microservice performs basic crud operations as well as sorting, paging, and filtering for customer information.

## What technologies were used?
![Spring Boot](https://bilisim.io/wp-content/uploads/2019/11/spring-boot.jpg)
- **Spring Boot**
<br>

 > Java Spring Boot (Spring Boot) is a tool that makes developing web application and microservices with Spring Framework faster and easier through three core capabilities: Autoconfiguration. An opinionated approach to configuration. The ability to create standalone applications.
 
  ![ Apache Maven](https://miro.medium.com/max/743/1*M7gYkSDwC5ny9SxxBwzozA.png)
- **Apache Maven** 
>Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

  ![ Spring Security ](https://miro.medium.com/max/1000/1*CsWbbOxOG3QrlHQoE4ApVQ.png)

- **Spring Security** 
 > Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications.

> Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements

**Features**
- Comprehensive and extensible support for both Authentication and Authorization

- Protection against attacks like session fixation, clickjacking, cross site request forgery, etc

- Servlet API integration

 - Optional integration with Spring Web MVC
    > Much more…







  




...........................

POST /api/customer HTTP/1.1

Host: localhost:4444

Authorization: Basic base64(username:password)

Content-Type: application/json

Content-Length: 61

{
    "customerName":"cem",
    "companyName":"Oracle"

}

..........................
