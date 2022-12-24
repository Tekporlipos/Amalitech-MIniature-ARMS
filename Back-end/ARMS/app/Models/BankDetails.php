<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

/**
 * @method static where(string $string, int $id)
 * @method static create(array $array)
 */
class BankDetails extends Model
{
    use HasFactory;
    protected $fillable = [
        "account_name",
        "bank_name",
        "account_number",
        "bank_branch",
        "tell",
        "user_id"
    ];
    protected $hidden = [
        "id",
    ];
}
