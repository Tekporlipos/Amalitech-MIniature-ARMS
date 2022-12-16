<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 * @method static where(string $string, \MongoDB\BSON\Timestamp $date)
 */
class traffic extends Model
{
    use HasFactory;

    public function Employee(): \Illuminate\Database\Eloquent\Relations\HasOne
    {
        return $this->hasOne(Employee::class,'user_id',"'user_id'");
    }
    protected $fillable = [
        'ip',
        'user_agent',
        'page'
    ];
}
