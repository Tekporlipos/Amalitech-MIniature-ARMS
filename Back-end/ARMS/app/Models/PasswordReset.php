<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 * @method static where(string $string, mixed $get)
 */
class PasswordReset extends Model
{
    use HasFactory;

    protected $fillable = [
        "email",
        "token",
        'created_at'
    ];
}
