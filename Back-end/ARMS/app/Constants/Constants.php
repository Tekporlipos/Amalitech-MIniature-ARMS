<?php
namespace App\Constants;

class Constants
{
   const REQUIRE = 'string|required';

   public static function employeeUser(int $page, int $limit) : string
   {
       return "SELECT employees.user_id, email,role, employees.first_name,
       employees.last_name, employees.other_names,users.profile, employees.gender,
       employees.department,employees.position, employees.tell,employees.salary,employees.hire_date
FROM `users`, `employees`
WHERE users.deleted_at IS NULL AND users.user_id = employees.user_id
ORDER by users.id DESC limit $limit offset $page;";
}

const  EMPLOYEE_PAYROLL = "SELECT employees.user_id, email,role,
       employees.first_name, employees.last_name, employees.other_names,users.profile,
       employees.gender ,employees.position,employees.tell, employees.department,
       employees.salary,employees.hire_date
FROM `users`, `employees`
WHERE users.user_id = employees.user_id ORDER by users.id DESC";

   public static function employeeById(string $userId): string
    {
     return "SELECT employees.user_id, email,role, employees.first_name,
       employees.last_name, employees.other_names,users.profile, employees.gender,
       employees.department,employees.position,employees.tell,employees.salary,employees.hire_date
FROM `users`, `employees`
WHERE users.user_id = employees.user_id AND users.user_id = '$userId'";
 }


    public static function search(String $search, int $page, int $limit): string
    {
        return "SELECT employees.user_id, email,role, employees.first_name,
       employees.last_name, employees.other_names,users.profile, employees.gender,
       employees.department,employees.position,employees.tell,employees.salary,
       employees.hire_date FROM `users`, `employees`
       WHERE (employees.first_name LIKE '$search' OR employees.last_name LIKE '$search'
                  OR employees.other_names LIKE '$search' OR users.email LIKE '$search')
         AND users.user_id = employees.user_id ORDER by users.id DESC limit $limit offset $page";
    }

   const CAN_ADD = "SELECT users.user_id, users.name, users.email,users.profile,users.email_verified_at, users.role
FROM  `users` WHERE users.deleted_at IS NULL AND users.user_id NOT IN(SELECT onboardings.user_id FROM onboardings);";

   const  AVAILABLE = "SELECT users.user_id, users.name, users.email,users.profile,users.email_verified_at ,users.role
FROM  `users` WHERE users.deleted_at IS NULL AND users.user_id IN(SELECT onboardings.user_id FROM onboardings)
                AND users.user_id  NOT IN(SELECT assigns.assistant_id FROM assigns);";

   //
    const  DEFAULT_ASSISTANT = "John Dzikunu";

    const URL = "http://localhost:8000";

    const DATEFORMAT = 'Y-m-d H-i-s';

    const CREATED = "created_at";


}
