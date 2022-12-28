<?php

namespace Tests\Feature;

use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class loginTest extends TestCase
{

    use RefreshDatabase;

    /**
     * A basic feature test example.
     *
     * @return void
     */
    public function test_must_enter_email_and_password(): void
    {
        $this->json('POST', 'api/v1/login')
            ->assertStatus(422)
            ->assertJson([
                "message" => "The email field is required. (and 1 more error)",
                "errors" => [
                    'email' => ["The email field is required."],
                    'password' => ["The password field is required."],
                ]
            ]);
    }

    public function test_successful_login(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
      $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                         ->assertStatus(201);
        $response ->assertStatus(201)
            ->assertJsonStructure([
                "message",
                "user" => [
                    "user_id",
                    "name",
                    "profile",
                    "role",
                    "email",
                    "email_verified_at",
                ],
                "token"
            ]);
        $this->assertNotEmpty($response->json("token"));
        $this->assertTrue(strlen($response->json("token"))> 40);
        $this->json('GET', 'api/v1/user', [], ['Accept' => 'application/json', 'Authorization'=>'Bearer '.$response->json("token")]);
        $this->assertAuthenticated();
    }

    public function test_authenticate_to_access_logout(): void
    {
        $this->json('POST', 'api/v1/logout')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_authenticate_to_access_deep_logout(): void
    {
        $this->json('POST', 'api/v1/deeper-logout')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_logout_successful(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
                            ->assertStatus(201);
        $token = $response->json("token");

        $this->json('GET', 'api/v1/user', [], ['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token]);
        $this->assertAuthenticated();

      $response = $this->json('POST', 'api/v1/logout')
                        ->assertStatus(201)
                        ->assertJson([
                           "message" => "logout successful",
                       ]);

    }

    public function test_deep_logout_successful(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $this->json('GET', 'api/v1/user', [], ['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token]);
        $this->assertAuthenticated();

        $response = $this->json('POST', 'api/v1/deeper-logout')
                        ->assertStatus(201)
                        ->assertJson([
                            "message" => "logout successful, All sessions cleared",
                        ]);

    }

}
