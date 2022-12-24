<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static create(array $array)
 * @method static where(string $string, Timestamp $date)
 */
class Traffic extends Model
{
    use HasFactory;

    protected $fillable = [
        'ip',
        'user_agent',
        'page'
    ];
}
