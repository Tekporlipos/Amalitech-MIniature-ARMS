<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\=BankDetails>
 */
class BankDetailsFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition()
    {
        return [
            'user_id' => Str::uuid()->toString(),
            'bank_name' => fake()->lastName(),
            'account_name' => fake()->name(),
            'bank_branch' => fake()->lastName(),
            'account_number' => "1000000000121304"
        ];
    }
}
