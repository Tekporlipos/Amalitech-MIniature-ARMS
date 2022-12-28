<?php

namespace Tests\Feature;

use App\Models\Employee;
use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class EmployeeTest extends TestCase
{
//    use RefreshDatabase;
    /**
     * A basic feature test example.
     *
     * @return void
     */
    public function test_must_be_authenticated_to_access_employee_data(): void
    {
        $this->json('GET', 'api/v1/employees')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_must_be_authenticated_to_access_employee_statistics(): void
    {
        $this->json('GET', 'api/v1/employees-statistics')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_must_be_authenticated_to_search_employee_data(): void
    {
        $this->json('GET', 'api/v1/employees?search=john')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_must_be_authenticated_to_access_employee_payroll_data(): void
    {
        $this->json('GET', 'api/v1/payroll')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_must_be_authenticated_to_update_employee(): void
    {

        $user = User::factory()->create(["role" => "employee"]);
         Employee::factory()->create(["user_id" => $user->user_id,"first_name"=>"John"]);

         $updateEmployee = ["first_name"=>"Tekpor"];

        $this->json('PATCH', 'api/v1/employees/'.$user->user_id, $updateEmployee)
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_update_employee_successful(): void
    {
        $user = User::factory()->create(["role" => "admin"]);
        Employee::factory()->create(["user_id" => $user->user_id,"first_name"=>"John"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];

        $updateEmployee = ["first_name"=>"Tekpor"];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json']);
        $token = $response->json("token");

        $response =  $this->json('PATCH', 'api/v1/employees/'.$user->user_id, $updateEmployee, ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token]);
        $response
            ->assertStatus(200)
            ->assertJson([
                "message" => "User information updated successfully",
            ]);
        $this->assertEquals("Tekpor", $response->json("data")["first_name"]);

    }


    public function test_admin_update_employee_tell_firstName_lastName_otherName_hireDate_department_gender_and_position_successful(): void
    {
        $user = User::factory()->create(["role" => "admin"]);
        Employee::factory()->create(["user_id" => $user->user_id,"first_name"=>"John"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];


        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json']);
        $token = $response->json("token");




        $employee = User::factory()->create();
        Employee::factory()->create(["user_id" => $employee->user_id,"gender"=>"female"]);

        $updateEmployee = [
            "first_name"=>"John",
            "last_name"=>"Dzikunu",
            "other_names"=>"Tekpor",
            "position"=>"Junior Associate",
            "gender"=>"Male",
            "tell"=>"0123456789",
            "hire_date"=>"2022-12-28 16:44:13",
            "department"=>"Service Center",
        ];

        $response =  $this->json('PATCH', 'api/v1/employees/'.$employee->user_id, $updateEmployee, ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token]);
        $response
            ->assertStatus(200)
            ->assertJson([
                "message" => "User information updated successfully",
            ]);
        $this->assertEquals($updateEmployee["first_name"], $response->json("data")["first_name"]);
        $this->assertEquals($updateEmployee["last_name"], $response->json("data")["last_name"]);
        $this->assertEquals($updateEmployee["other_names"], $response->json("data")["other_names"]);
        $this->assertEquals($updateEmployee["position"], $response->json("data")["position"]);
        $this->assertEquals($updateEmployee["gender"], $response->json("data")["gender"]);
        $this->assertEquals($updateEmployee["tell"], $response->json("data")["tell"]);
        $this->assertEquals($updateEmployee["hire_date"], $response->json("data")["hire_date"]);
        $this->assertEquals($updateEmployee["department"], $response->json("data")["department"]);

    }
}
