# Teacher API
A REATful API made using spring boot

## Supported Endpoints

  - `GET /teacher` list all teachers
    
    Response: 
    ```json
    [
      {
        "id": 1,
        "email": "sma@vill.com",
        "firstName": "Sam",
        "lastName": "Vill"
      },
      {
        "id": 2,
        "email": "john@vma.com",
        "firstName": "john",
        "lastName": "Main"
      }
    ]
    ```
    
  - `GET /teacher/{email}` get teacher with matching email
  
      ```console
    curl localhost:8080/teacher/someEmail@test.com
    ```
  
    
  - `GET /teacher/startWith{prefix}` list teachers that has a first name or last name with this prefix (case insensitive)
  
    
    ```console
    curl localhost:8080/teacher/startWithj
    ```
    
  - `DELETE /teacher/{id}` delete teacher with matching id
  
    ```console
    curl -X DELETE localhost:8080/teacher/2
    ```
    
  - `POST /teacher/` create teacher
       
     ```console
     curl -X POST -H "Content-Type: application/json" -d '{ "firstName": "Sam", "lastName": "Vill", "email": "sma@vill.com" }'
     ```
     
   
  
  
  
