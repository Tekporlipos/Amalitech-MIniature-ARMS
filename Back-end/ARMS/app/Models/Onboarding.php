<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 * @method static where(string $string, int $id)
 */
class Onboarding extends Model
{
    use HasFactory;

    protected $fillable = [
        "user_id",
        "location",
        "start_date",
        "start_time"
    ];

    protected $hidden = [
        "id"
    ];
}
