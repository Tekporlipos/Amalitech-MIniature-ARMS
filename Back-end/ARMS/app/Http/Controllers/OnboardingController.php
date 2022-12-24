<?php

namespace App\Http\Controllers;

use App\Constants\Constants;
use App\Models\Onboarding;
use Illuminate\Database\Eloquent\Collection;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\DB;

class OnboardingController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return Collection
     */
    public function index(): Collection
    {
     return   Onboarding::all();
    }



    /**
     * Store a newly created resource in storage.
     *
     * @param Request $request
     * @return Response
     */
    public function store(Request $request): Response
    {
        $request->validate([
            'user_id'=>'uuid|required|unique:Onboardings,user_id|exists:Users,user_id',
            'start_date'=>'string|required|date',
        ]);
        return Onboarding::create([
             "user_id"=>$request->get("user_id"),
             "location"=>$request->get("location"),
             "start_date"=>$request->get("start_date"),
             "start_time"=>$request->get("start_time")
         ]);

    }

    /**
     * Display the specified resource.
     *
     * @param string $id
     * @return Response
     */
    public function show(string $id): Response
    {
        return  Onboarding::where("user_id", $id)->get()[0];
    }


    /**
     * Display the specified resource.
     *
     * @return array
     */
    public function showCanOnboard(): array
    {
        return DB::select(Constants::CAN_ADD);
    }


    /**
     * Display the specified resource.
     *
     * @return array
     */
    public function showAvailable(): array
    {
        return DB::select(Constants::AVAILABLE);
    }



    /**
     * Remove the specified resource from storage.
     *
     * @param string $id
     * @return Response
     */
    public function destroy(string $id): Response
    {
        Onboarding::where("user_id", $id)->delete();
        return new Response([
            "message"=>"On-boarding assistant deleted successfully"
        ], 202);
    }
}
