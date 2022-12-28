<?php

namespace Tests\Feature;

use App\Models\Employee;
use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class registerTest extends TestCase
{
    use RefreshDatabase;

    /**
     * A basic feature test must be authenticated.
     *
     * @return void
     */
    public function test_must_be_authenticated_to_register_employee(): void
    {
        $this->json('POST', 'api/v1/register')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_must_enter_firstName_lastName_email_gender_salary_role_position_department_and_hireDate_to_register_employee(): void
    {
        //preparation
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                           ->assertStatus(201);
        $token = $response->json("token");

        $registerData = [];

        $this->json('POST', 'api/v1/register',$registerData,['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(422)
            ->assertJson([
                "message" => "The first name field is required. (and 8 more errors)",
            ]);
    }


    public function test_register_employee_successful(): void
    {
        //preparation
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                           ->assertStatus(201);
        $token = $response->json("token");

        //testing
        $registerData = [
        "first_name"=>"John",
    "last_name"=>"Dzikunu",
    "email"=>"johndzikunu17@gmail.com",
    "gender"=>"male",
    "salary"=>"2500.00",
    "role"=>"admin",
    "tell"=>"0543715182",
    "position"=>"Junior Associate",
    "department"=>"service center",
    "hire_date"=>"2022-12-20T16:01:17"
];
        $this->json('POST', 'api/v1/register',$registerData,['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(201)
            ->assertJsonStructure([
                "message",
                "email",
                "password",
                "employee"=> [
                    "user_id",
                    "first_name",
                    "last_name",
                    "other_names",
                    "gender",
                    "hire_date",
                    "position",
                    "tell",
                    "salary",
                    "department",
                    "updated_at",
                    "created_at",
                    "id"
                ]
            ])
            ->assertJson([
                "message" => "New User added successfully",
            ]);
    }

    public function test_must_be_admin_to_delete_employee(): void
    {


        $user = User::factory()->create(["role"=>"employee"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                           ->assertStatus(201);
        $token = $response->json("token");

        $user = User::factory()->create(["role"=>"employee"]);
        Employee::factory()->create(["user_id"=>$user->user_id]);


        $this->json('DELETE', 'api/v1/employees/'.$user->user_id,[],['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(401)
            ->assertJson([
                "message" => "unauthorized request",
            ]);
    }


    public function test_admin_delete_employee_successful(): void
    {
        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                         ->assertStatus(201);
        $token = $response->json("token");

        $user = User::factory()->create(["role" => "employee"]);
        Employee::factory()->create(["user_id" => $user->user_id]);


        $this->json('DELETE', 'api/v1/employees/' . $user->user_id, [], ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(201)
            ->assertJson([
                "message" => "Employee deleted successfully",
            ]);
    }
    }
