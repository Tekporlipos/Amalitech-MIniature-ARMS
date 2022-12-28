<?php

namespace Tests\Feature;

use App\Models\BankDetails;
use App\Models\User;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class BankDetailTest extends TestCase
{
    /**
     * A basic feature test example.
     *
     * @return void
     */
    public function test_must_be_authenticated_to_access_user_BankDetail_data(): void
    {
        $this->json('GET', 'api/v1/bank-detail')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_access_user_BankDetail_data_successful(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        BankDetails::factory()->create(["user_id"=>$user->user_id]);

        $this->json('GET', 'api/v1/bank-detail',[],['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(200);
    }

    public function test_must_be_authenticated_to_create_BankDetail_data(): void
    {
        $this->json('POST', 'api/v1/bank-detail')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_create_BankDetail_data_successful(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

        $bankDetail = [
     "account_name"=>"John Dzikunu",
    "bank_name"=> "CalBank",
    "account_number"=> "00001234566",
    "bank_branch"=>"KNUST"
        ];

        $this->json('POST', 'api/v1/bank-detail',$bankDetail,['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(200);
    }


    public function test_must_be_authenticated_to_update_BankDetail_data(): void
    {
        $this->json('PATCH', 'api/v1/bank-detail')
            ->assertStatus(401)
            ->assertJson([
                "message" => "Unauthenticated.",
            ]);
    }

    public function test_update_BankDetail_data_successful(): void
    {
        $user = User::factory()->create();
        $loginData = ['email' => $user->email, 'password' => 'password'];
        $response =   $this->json('POST', 'api/v1/login', $loginData, ['Accept' => 'application/json'])
            ->assertStatus(201);
        $token = $response->json("token");

      $bankDetail =   BankDetails::factory()->create(["user_id"=>$user->user_id]);

        $bankDetailUpdateWith = [
            "account_number"=> "1000012345",
            "bank_branch"=>"Takoradi",
        ];

      $updatedBankDetail =   $this->json('PATCH', 'api/v1/bank-detail',$bankDetailUpdateWith,['Accept' => 'application/json', 'Authorization'=>'Bearer '.$token])
            ->assertStatus(202);

        $this->assertEquals($bankDetailUpdateWith["account_number"], $updatedBankDetail->json()["account_number"]);
        $this->assertEquals($bankDetailUpdateWith["bank_branch"], $updatedBankDetail->json()["bank_branch"]);
        $this->assertEquals($bankDetail ->bank_name, $updatedBankDetail->json()["bank_name"]);
        $this->assertEquals($bankDetail ->account_name, $updatedBankDetail->json()["account_name"]);
    }
}
