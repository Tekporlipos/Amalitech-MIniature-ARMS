<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 */
class Employee extends Model
{
    use HasFactory;

    public mixed $email;
    protected $fillable = [
        "user_id",
        "first_name",
        "last_name",
        "other_names",
        "gender",
        "hire_date",
        "department"
    ];
}
