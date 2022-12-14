<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

/**
 * @method static create(array $array)
 * @method static where(string $string, $user_id)
 * @method static find(int $int)
 * @method static select(string $string)
 * @method static count()
 * @method static whereDate($fieldName, string $string, $fromDate)
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
        "department",
        "tell",
        "position"
    ];

    public function user()
    {
        return $this->hasOne(Employee::class, 'user_id', "'user_id'");
    }
    protected $hidden = [
        "deleted_at"
    ];
}
