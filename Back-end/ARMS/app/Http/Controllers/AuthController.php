<?php

namespace App\Http\Controllers;

use App\Jobs\MailSender;
use App\Mail\EmployeeMail;
use App\Models\Employee;
use App\Threads\MailThread;
use Illuminate\Contracts\Foundation\Application;
use Illuminate\Contracts\Routing\ResponseFactory;
use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Mail;
use Illuminate\Support\Str;
use PhpParser\Node\Scalar\String_;
use Thread;

class AuthController extends Controller
{
    public function create(Request $request): Response|Application|ResponseFactory
    {
        $user_id = Str::uuid()->toString();
        $password =  strval(rand(11111111,99999999));
          User::create(
            [
                "name"=>$request->get("firstName")." ".$request->get("lastName"),
                "user_id"=> $user_id,
                "email"=>$request->get("email"),
                "password"=>bcrypt($password),
            ]
        );

        $employee =   EmployeeController::create($request,$user_id);

       $this->dispatch(new MailSender($employee,$request->get("email"),$password));


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

        if($user && Hash::check($request->get("old_password"),$user->password) ){
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




    public function deleteAccount(Request $request): Response
    {
        $user = $request->user();
        $response =   $this->delete($user);
        $user->tokens()->delete();
        return $response;
    }

    public function logout(Request $request): Response
    {
        $user = $request->user();
        $user->tokens()->delete();
        return new Response([
            "message"=>"logout successful",
        ],201);
    }

   public static function delete($user): Response
    {
        $employee = Employee::where("user_id",$user->user_id);
        $employee->delete();
        $user->delete();
        return new Response([
            "message"=>"User deleted successful",
        ],201);
    }

}
