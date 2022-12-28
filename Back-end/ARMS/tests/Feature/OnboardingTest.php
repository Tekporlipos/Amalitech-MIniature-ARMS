<?php

namespace Tests\Feature;

use App\Models\Employee;
use App\Models\Onboarding;
use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class OnboardingTest extends TestCase
{
    use RefreshDatabase;
    /**
     * A basic feature test example.
     *
     * @return void
     */
    public function test_must_be_authenticated_to_access_onboard_assistant_data(): void
    {
        $this->json('GET', 'api/v1/assistant')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_access_onboard_assistant_data_successful(): void
    {
        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $this->json('GET', 'api/v1/assistant',[], ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(200);
    }



    public function test_must_be_authenticated_to_access_onboard_can_assistant_data(): void
    {
        $this->json('GET', 'api/v1/can-assistant')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_access_onboard_can_assistant_data_successful(): void
    {
        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $this->json('GET', 'api/v1/can-assistant',[], ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(200);
    }


    public function test_must_be_authenticated_to_access_onboard_available_assistant_data(): void
    {
        $this->json('GET', 'api/v1/available-assistant')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_access_onboard_available_assistant_data_successful(): void
    {

        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $this->json('GET', 'api/v1/available-assistant',[], ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(200);

    }

    public function test_must_be_authenticated_to_access_onboard_assistant_single_data(): void
    {

        $user = User::factory()->create(["role"=>"employee"]);
        Employee::factory()->create(["user_id"=>$user->user_id]);
        $onboard = Onboarding::factory()->create(["user_id"=>$user->user_id]);

        $this->json('GET', 'api/v1/assistant/'.$onboard->user_id)
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_access_onboard_assistant_single_data_successful(): void
    {

        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $user = User::factory()->create(["role"=>"employee"]);
        Employee::factory()->create(["user_id"=>$user->user_id]);
        $onboard = Onboarding::factory()->create(["user_id"=>$user->user_id]);

        $this->json('GET', 'api/v1/assistant/'.$onboard->user_id, [], ['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(200);
    }



    public function test_must_be_authenticated_to_add_to_onboard_data(): void
    {


        $onboard = [
            "user_id"=>"04cade9f-ec45-4a8f-9e3c-4c5b0cf5f921",
            "location"=>"Takoradi",
            "start_date"=>"2022-12-19T12:01:59",
            "start_time"=>"7:30 AM"
        ];

        $this->json('POST', 'api/v1/assistant',$onboard)
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }


    public function test_to_add_to_onboard_data_successful(): void
    {

        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");



        $onboard = [
            "user_id"=>$user->user_id,
            "location"=>"Takoradi",
            "start_date"=>"2022-12-19T12:01:59",
            "start_time"=>"7:30 AM"
        ];

        $this->json('POST', 'api/v1/assistant',$onboard,['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(202);
    }


    public function test_must_be_authenticated_to_delete_onboard_assistant_single_data(): void
    {

        $user = User::factory()->create(["role"=>"employee"]);
        Employee::factory()->create(["user_id"=>$user->user_id]);
        $onboard = Onboarding::factory()->create(["user_id"=>$user->user_id]);

        $this->json('DELETE', 'api/v1/assistant/'.$onboard->user_id)
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_delete_onboard_assistant_single_data_successful(): void
    {

        $user = User::factory()->create(["role" => "admin"]);
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response = $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $user = User::factory()->create(["role"=>"employee"]);
        Employee::factory()->create(["user_id"=>$user->user_id]);
        $onboard = Onboarding::factory()->create(["user_id"=>$user->user_id]);

        $this->json('DELETE', 'api/v1/assistant/'.$onboard->user_id,[],['Accept' => 'application/json', 'Authorization' => 'Bearer ' . $token])
            ->assertStatus(202);
    }

}
