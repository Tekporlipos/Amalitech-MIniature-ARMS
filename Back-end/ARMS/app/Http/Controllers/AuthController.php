<?php

namespace App\Http\Controllers;

use App\Mail\EmployeeMail;
use App\Threads\MailThread;
use Illuminate\Contracts\Foundation\Application;
use Illuminate\Contracts\Routing\ResponseFactory;
use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Mail;
use Illuminate\Support\Str;
use Thread;

class AuthController extends Controller
{
    public function create(Request $request): Response|Application|ResponseFactory
    {
        $user_id = Str::uuid()->toString();
          User::create(
            [
                "name"=>$request->get("firstName")." ".$request->get("lastName"),
                "user_id"=> $user_id,
                "email"=>$request->get("email"),
                "password"=>bcrypt("12345678"),
            ]
        );

        $employee =   EmployeeController::create($request,$user_id);

        $employee->email = $request->get("email");



        Mail::to($request->get("email"))->send(New EmployeeMail());



        return Response([
            "message"=>"New User added successfully",
            "employee"=> $employee,
            "email"=> $request->get("email"),
        ],201);

    }

    public function validateEmail(Request $request){
        $request->validate([
            'email'=>'string|required|email|unique:users',
        ]);
    }

    public function login(Request $request){
        $request->validate([
            'email'=>'string|required|email',
            'password'=>'string|required',
        ]);
    }

}
