<?php

namespace Tests\Feature;

use App\Models\User;
use Database\Factories\UserFactory;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;
class loginTest extends TestCase
{

//    use RefreshDatabase;

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
      $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json']);
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
    }
}
