<?php

namespace App\Http\Controllers;

use App\Models\traffic;
use  \Illuminate\Database\Eloquent\Collection;

class TrafficController extends Controller
{

    public function getAll(): Collection
    {
        return  traffic::all();
    }

}
