# External microservice


This microservice performs basic crud operations as well as sorting, paging, and filtering for customer information.


### What technologies were used?

***********************************************************************************************

  <p align="start">
  <img src="https://bilisim.io/wp-content/uploads/2019/11/spring-boot.jpg" width="400" 	height="200">
   </p>	
<br>

- **What did I use Spring Boot ?**
<br>

 > Java Spring Boot (Spring Boot) is a tool that makes developing web application and microservices with Spring Framework faster and easier through three core capabilities: Autoconfiguration. An opinionated approach to configuration. The ability to create standalone applications.
   <br>
   
**************************************************************************************
  <p align="start">
  <img src="https://miro.medium.com/max/743/1*M7gYkSDwC5ny9SxxBwzozA.png" width="400" 	height="200">
   </p>	
  
- **What did I use Apache Maven ?** 
	> Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
  <br>
  
**************************************************************************************

<p align="start">
  <img src="https://miro.medium.com/max/1000/1*CsWbbOxOG3QrlHQoE4ApVQ.png" width="400" 	height="200">
   </p>	
  
  

- **What did I use Spring Security ?** 
 
 > Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications.

  > Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements

  **Features**
- Comprehensive and extensible support for both Authentication and Authorization

- Protection against attacks like session fixation, clickjacking, cross site request forgery, etc

- Servlet API integration

 - Optional integration with Spring Web MVC
    > Much more…
  <br>
  
************************************************************************************

 <p align="start">
  <img src="https://upload.wikimedia.org/wikipedia/commons/6/6b/SLF4J_Logo.jpg" width="400" height="200" >
   </p>
   
   - **What did I use SLF4J ?** 
   
 >  The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.
      <br>
      
**************************************************************************************
<p align="start">
  <img src="https://www.konakart.com/wp-content/uploads/2014/11/javadoc.png" width="400" height="200" >
   </p>
   
   - **What did I use JavaDoc ?** 
   
 > JavaDoc tool is a document generator tool in Java programming language for generating standard documentation in HTML format. It generates API documentation. It parses the declarations ad documentation in a set of source file describing classes, methods, constructors, and fields.
   <br>
   
************************************************************************************************
    
    
  <p align="start">
  <img src="https://i0.wp.com/ngdeveloper.com/wp-content/uploads/2018/05/modelmapper.png?fit=781%2C253&ssl=1" width="400" height="200" >
   </p>
   
   - **What did I use ModelMapper ?** 
   
   > The goal of ModelMapper is to make object mapping easy, by automatically determining how one object model maps to another, based on conventions, in the same way that a human would - while providing a simple, refactoring-safe API for handling specific use cases.    
       <br>
       
******************************************************************************************
   
   <p align="start">
  <img src="https://miro.medium.com/max/1400/1*C_u3RtbZnYzRI10IUWbPfg.png" width="400" height="200" >
   </p>
   
   - **What did I use Swagger ?**
   
  > Swagger allows you to describe the structure of your APIs so that machines can read them. The ability of APIs to describe their own structure is the root of all awesomeness in Swagger.           
  > Why is it so great? Well, by reading your API’s structure, we can automatically build beautiful and interactive API documentation.
  > We can also automatically generate client libraries for your API in many languages and explore other possibilities like automated testing. 
  > Swagger does this by asking your API to return a YAML or JSON that contains a detailed description of your entire API. 
  > This file is essentially a resource listing of your API which adheres to OpenAPI Specification. The specification asks you to include information like:
What are all the operations that your API supports?
What are your API’s parameters and what does it return?
Does your API need some authorization?
And even fun things like terms, contact information and license to use the API.     
 
 <br>
 
******************************************************************************************
           
      
   <p align="start">
  <img src="https://cdn.wmaraci.com/nedir/PostgreSQL.png" width="400" height="200" >
   </p>
   
   - **What did I use PostgreSQL ?**  
   
   

 > PostgreSQL is an advanced, enterprise-class, and open-source relational database system. PostgreSQL supports both SQL (relational) and JSON (non-relational) querying.

 > PostgreSQL is a highly stable database backed by more than 20 years of development by the open-source community.

 > PostgreSQL is used as a primary database for many web applications as well as mobile and analytics applications.      
           
*********************************************************************************************
******************************************************************************************
#Endpoints   

*******************************************************************************
*******************************************************************************    

##### 

 ## **Add Customer** ##
 
 
*******************************************************************************

- **Request**

 ` localhost:4444/api/customer/add `

POST /api/customer/add 

HTTP/1.1

Host: localhost:4444

Authorization: Basic base64(username:password)

Content-Type: application/json

Content-Length: 56

{
    "customerName":"Cem",
    "companyName":"BMW"
}

--------------------------------------------------------
   
  - **Response : SuccesDataResult Object** 



	{
    "success": true,
    
    "message": "customer.added",
    
    "data": {
    
        "id": 9,
        
        "customerName": "Cem",
        
        "companyName": "Ford",
        
        "createTime": "2022-07-21T22:14:14.4192938"
    }
   
  
************************************************************************************************  
 ## **Delete Customer** ##
 ************************************************************************************************ 
 
 
Here is a simple flow chart:



graph TD;
    A-->B;
    A-->C;
    B-->D;
    C-->D;


  




