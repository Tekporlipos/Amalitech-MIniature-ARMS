<?php

namespace App\Constants;

class Constants
{

    const REQUIRE = 'string|required';

    static function employees_user(): string
    {
        return "SELECT employees.user_id, email,role, employees.first_name, employees.last_name, employees.other_names, employees.gender, employees.department, employees.hire_date  FROM `users`, `employees` WHERE users.user_id = employees.user_id;";
    }

}
