<?php

namespace App\Http\Controllers;

use App\Models\Onboarding;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class OnboardingController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
     return   Onboarding::all();
    }



    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $request->validate([
            'user_id'=>'uuid|required|unique:Onboardings,user_id',
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
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        return  Onboarding::where("user_id",$id)->get()[0];
    }


    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        Onboarding::where("user_id",$id)->delete();
        return new Response([
            "message"=>"Onboarding assistant deleted successfully"
        ],202);
    }
}
