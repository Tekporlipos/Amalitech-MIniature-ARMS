<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

/**
 * @method static create(array $array)
 * @method static where(string $string, $user_id)
 * @method static find(int $int)
 */
class Employee extends Model
{
    use HasFactory,SoftDeletes;

    public mixed $email;
    protected $fillable = [
        "user_id",
        "first_name",
        "last_name",
        "other_names",
        "gender",
        "salary",
        "hire_date",
        "department"
    ];

    protected $hidden = [
        "deleted_at",
        "id"
    ];
}
