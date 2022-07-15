# Microservice customer

### Endpoints:


#### Save Customer

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