# MINIATURE ARMS 
AmaliTech wants a system which will help the company to digitalise its processes end to  end. You have been contracted to build an Enterprise Resource Planning (ERP)  software for the company. 
The ERP system consists of three parts 

1. ARMS (Uses MVC for its operations but exposes an API for consumption by  payroll) 
2. Payroll back-end (payroll API) 
3. Payroll front-end (consumes the payroll API) 
ARMS 

### The administrator of the system should be able to:  
1. create a user with the fields listed below 
a. first name 
b. last name 
c. other names (optional) 
d. gender 
e. email 
f. hire date 
g. department 
other user information includes monthly salary, phone number and bank  account number. Assign the user a default password to start with. 
2. update the details of an existing employee 
3. delete an employee (soft deletes) 
4. generate payroll for the month (the payroll API should handle generation) 
Payroll back-end 

At the end of every month, when the admin clicks the generate payroll button. The  payroll API should save user information such as name, email, basic salary, employee  SSF (5% of basic salary), the sum of all bonuses, and department (all for the current  month) for each user on the ARMS system (payroll fetches the employee data from  ARMS). 

### Additionally, the payroll backend should be able to  
1. create an allowance type 
2. create a bonus type 
3. create a bonus for an employee for the current month (bonus type and amount)
Payroll front-end 
The payroll front-end consumes the ARMS API, which in turn consumes the Payroll API.  Steps involved 
1. The payroll front-end makes a request to the ARMS API 
2. The ARMS API makes a request to the payroll API 
3. The payroll API returns the requested data to the ARMS API 
4. The ARMS API returns the requested data to the payroll front-end 5. The payroll front-end renders the data 

There should be a bonus section to add a bonus for an employee. (This data is stored  on the payroll database). This section should also contain a list of employees with a  monthly bonus (information comes from payroll). 
There should be a payroll section which displays all the payroll data for the month.  Admin should be able to select a past month and see generated data. It should show  the current month by default (this information comes from payroll). 

### TECH STACK 
> ARMS  
• PHP Laravel (back-end) 

• Vuejs (front-end) 

• MySQL (database) 

> PAYROLL BACK-END
>  
• Java Spring boot 

• Postgres (database) 

> PAYROLL FRONT-END 
• Vuejs 


### SOME CONSIDERATIONS 
Document the payroll API with swagger 
Write unit tests for the ARMS backend and the payroll API 
Use the Sonarlint extension 
Use version control (Git and GitHub) 
NOTE: 
During the review, I’ll primarily consider your back-end code, especially the payroll API. Don’t  worry too much about having a beautiful front-end. For this project, functionality matters more.



## Documentation
> PAYROLL API : http://localhost:8080/swagger-ui.html

> ARMS API: https://documenter.getpostman.com/view/24837966/2s8Z712D1U
