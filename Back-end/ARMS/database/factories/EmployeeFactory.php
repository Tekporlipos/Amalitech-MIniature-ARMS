<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\=Employee>
 */
class EmployeeFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'user_id' => Str::uuid()->toString(),
            'first_name' => fake()->firstName("male"),
            'last_name' => fake()->lastName(),
            'tell' => fake()->phoneNumber,
            'position' => 'Junior Associate',
            'other_names' => fake()->firstName("male"),
            'gender' => "male",
            'hire_date' => now(),
            'department' => "Service Center",
            'salary' => "350.00",
        ];
    }
}
