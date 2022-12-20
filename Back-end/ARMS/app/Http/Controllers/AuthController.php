<?php

namespace App\Http\Controllers;

use App\Jobs\MailSender;
use App\Models\User;
use App\Threads\MailThread;
use Illuminate\Contracts\Foundation\Application;
use Illuminate\Contracts\Routing\ResponseFactory;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

class AuthController extends Controller
{
    public function create(Request $request): Response|Application|ResponseFactory
    {
        $userId = Str::uuid()->toString();
        $password =  strval(rand(11111111,99999999));
          User::create(
              [
                  "name" => $request->get("firstName") . " " . $request->get("lastName"),
                  "user_id" => $userId,
                  "role" => $request->get("role"),
                  "email" => $request->get("email"),
                  "password" => bcrypt($password),
              ]
        );

        $employee =   EmployeeController::create($request, $userId);

       $this->dispatch(new MailSender($employee, $request->get("email"), $password));


        return Response([
            "message"=>"New User added successfully",
            "employee"=> $employee,
            "email"=> $request->get("email"),
            "password"=> $password,
        ],201);

    }

    public function validateEmail(Request $request): Response
    {
        $request->validate([
            'email'=>'string|required|email|unique:users',
        ]);

        return new Response([
            "message"=>"valid email",
        ],200);
    }

    public function login(Request $request): Response
    {
        $request->validate([
            'email'=>'string|required|email',
            'password'=>'string|required',
        ]);
        $user = User::where("email",$request->get("email"))->first();

        if(!$user){
            return new Response([
                "Message"=>"No user exist with this email",
            ],504);
        }


        if(Hash::check($request->get("password"),$user->password) ){
            $token = $user->createToken("amaliTech")->plainTextToken;
            return new Response([
                "message"=>"login successful",
                "user"=>$user,
                "token"=> $token
            ],201);
        }

        return new Response([
            "Message"=>"wrong credentials",
        ],504);


    }

    public function changePassword(Request $request): Response
    {
        $request->validate([
            'old_password'=>'string|required',
            'password'=>'string|required|confirmed',
        ]);

        $user = $request->user();

        if ($user && Hash::check($request->get("old_password"), $user->password) ){
            $user->password = bcrypt($request->get("password"));
            $user->update();
            return new Response([
                "message"=>"password changed successful",
                "user"=>$user,
            ],201);
        }

        return new Response([
            "Message"=>"wrong credential",
        ],504);


    }


    public function logout(Request $request): Response
    {
        $user = $request->user();
        $user->tokens()->delete();
        return new Response([
            "message"=>"logout successful",
        ],201);
    }

}