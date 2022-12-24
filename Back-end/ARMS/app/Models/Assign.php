<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 */
class Assign extends Model
{
    use HasFactory;

    protected $fillable = [
        "assistant_id",
        "user_id",
    ];

    protected $hidden = [
        "id",
    ];
}
