<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\=Onboarding>
 */
class OnboardingFactory extends Factory
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
            'location' => "Takoradi",
            'start_date' => now(),
            'start_time' => "07:30 AM"
        ];
    }
}
