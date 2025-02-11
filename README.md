# CRUD-APIs
CRUD-APIs is a RESTful API built with Spring Boot that provides CRUD operations for managing users. The project adheres to REST principles and showcases how to implement a clean and resource-oriented API.

## Features

•	Create, Read, Update, and Delete (CRUD) operations for users.  
•	Fetch users by unique identifiers like id or afm.  
•	Retrieve partial resource representations (e.g., name-only details).  


## Technologies Used

•	Java 17  
•	Spring Boot 3  
•	Spring Data JPA  
•	ModelMapper for DTO mapping  
•	H2 Database (or configure any other database)  
•	Maven for dependency management  
•	Jakarta Validation  
•	Swagger (SpringDoc OpenAPI)

## Endpoints

### 1. Get All  
Endpoint: GET /users  
Retrieves a list of all users.

### 2. Get by ID  
• Endpoint: GET /users/{id}  
• Retrieves a specific user using their unique ID.

### 3. Get by AFM  
• Endpoint: GET /users/afm/{afm}  
• Retrieves a user using their unique AFM.  

### 4. Get Short by ID
• Endpoint: GET /users/{id}/short  
• Retrieves a simplified representation of a user using their ID.  

### 5. Create New  
• Endpoint: POST /users  
• Creates a new user.  

### 6. Update
• Endpoint: PUT /users  
• Updates an existing user.  

### 7. Delete
• Endpoint: DELETE /users/{id}  
• Deletes a user using their ID.  

## Future Improvements

• Add authentication and authorization.  
• Implement pagination for large datasets.  
• Add validation error handling.
