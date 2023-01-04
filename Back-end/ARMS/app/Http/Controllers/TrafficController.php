<?php
namespace App\Http\Controllers;

use App\Models\Traffic;
use Illuminate\Database\Eloquent\Collection;

class TrafficController extends Controller
{

    public function getAll(): Collection
    {
        return  Traffic::all();
    }

}
