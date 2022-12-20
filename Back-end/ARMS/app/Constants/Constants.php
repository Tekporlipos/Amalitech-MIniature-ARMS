<?php

namespace App\Constants;

class Constants
{
   const REQUIRE = 'string|required';
   const EMPLOYEE_USER = "SELECT employees.user_id, email,role, employees.first_name, employees.last_name, employees.other_names,users.profile, employees.gender, employees.department, employees.hire_date
FROM `users`, `employees`
WHERE users.user_id = employees.user_id;";
   const CAN_ADD = "SELECT users.user_id, users.name, users.email,users.profile,users.email_verified_at, users.role FROM  `users` WHERE users.deleted_at IS NULL AND users.user_id NOT IN(SELECT onboardings.user_id FROM onboardings);";

   const  AVAILABLE = "SELECT users.user_id, users.name, users.email,users.profile,users.email_verified_at ,users.role FROM  `users` WHERE users.deleted_at IS NULL AND users.user_id IN(SELECT onboardings.user_id FROM onboardings) AND users.user_id  NOT IN(SELECT assigns.assistant_id FROM assigns);";


   //
    const  DEFAULT_ASSISTANT = "John Dzikunu";





}
