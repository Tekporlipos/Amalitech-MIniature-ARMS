<?php

namespace App\Http\Controllers;

use App\Jobs\LoginAlertJob;
use App\Models\Assign;
use App\Models\PasswordReset;
use App\Models\User;
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
        $password =  strval(rand(11111111, 99999999));

        $this->createUser($request, $userId, $password);

        $employee =  (new EmployeeController)->create($request, $userId);

        if ($request->get("assistant_id")) {
            $this->createAssistant($userId, $request->get("assistant_id"));
        }

        $assist = User::where("user_id", $request->get("assistant_id"))->get();

        //remember to uncomment this block

//       $this->dispatch(new MailSender(
//           $employee, $request->get("email"),
//           $password, sizeof($assist)? $assist[0]->name : Constants::DEFAULT_ASSISTANT
//       ));

        return Response([
            "message"=>"New User added successfully",
            "employee"=> $employee,
            "email"=> $request->get("email"),
            "password"=> $password,
        ], 201);
    }


    public function validateEmail(Request $request): Response
    {
        $request->validate([
            'email'=>'string|required|email|unique:users',
        ]);

        return new Response([
            "message"=>"valid email",
        ], 200);
    }

    public function login(Request $request): Response
    {
        $request->validate([
            'email'=>'string|required|email',
            'password'=>'string|required',
        ]);
        $user = User::where("email", $request->get("email"))->first();

        if (!$user) {
            return new Response([
                "message"=>"There is no user with the specified email.",
            ], 504);
        }

        $passwordReset = PasswordReset::where('email', $request->get("email"))->get();
        if (Hash::check($request->get("password"), $user->password)  ||
            (sizeof($passwordReset) && Hash::check($request->get("password"), $passwordReset[0]->token))) {
            $token = $user->createToken("amaliTech")->plainTextToken;

            //remember to uncomment this block
//            $this->sendAlert($request, $user, "Your ARMS account was just login.");

            return new Response([
                "message"=>"login successful",
                "user"=>$user,
                "token"=> $token
            ], 201);
        }

        return new Response([
            "message"=>"wrong credentials",
        ], 504);
    }




    public function changePassword(Request $request): Response
    {
        $request->validate([
            'old_password'=>'string|required',
            'password'=>'string|required|confirmed',
        ]);
        $user = $request->user();
        $passwordResetModel = PasswordReset::where('email', $request->user()->email);
        $passwordReset = $passwordResetModel->get();
        if ($user && Hash::check($request->get("old_password"), $user->password) ||
            (sizeof($passwordReset) && Hash::check($request->get("old_password"), $passwordReset[0]->token))) {
            $user->password = bcrypt($request->get("password"));
            $user->email_verified_at = date_create();
            $user->update();

            if (sizeof($passwordReset)) {
                $passwordResetModel->delete();
            }

//            $this->sendAlert($request, $user, "Your password was just changed.");

            return new Response([
                "message"=>"password changed successful",
                "user"=>$user,
            ], 201);
        }
        return new Response([
            "message"=>"wrong credential",
        ], 504);
    }

   public function user(Request $request): Response
    {
        return new Response($request->user());
    }

    public function logout(Request $request): Response
    {
        $user = $request->user();
        $user->currentAccessToken()->delete();
        return new Response([
            "message"=>"logout successful",
        ], 201);
    }


    public function deepLogout(Request $request): Response
    {
        $user = $request->user();
        $user->tokens()->delete();
        return new Response([
            "message"=>"logout successful, All sessions cleared",
        ], 201);
    }

    public function resetPassword(Request $request): Response
    {
        $request->validate([
            'email'=>'string|email|required|email|exists:users,email',
        ]);
//
        $password =  strval(rand(11111111, 99999999));
       PasswordReset::create([
           'email'=>$request->get("email"),
           'token'=>bcrypt($password),
       ]);

//        $this->dispatch(new PasswordResetJob($password, $request->get("email")));

        return  new Response([
           'message'=>"password reset token is sent to the email"
       ], 202);
    }


    public function createAssistant(string $userId, string $assistantId)
    {
        Assign::create([
            "assistant_id"=>$assistantId,
            "user_id"=>$userId
        ]);
    }

    public function sendAlert(Request $request, $user, $message)
    {
        $this->dispatch(new LoginAlertJob([
            "ip"=>$request->ip(),
            "name"=>$request->headers->get("user-agent"),
            "date"=>date("Y-m-d H:i:s"),
            "userName"=>$user->name,
            "email"=>$user->email,
            "message"=>$message
        ]));
    }

   public function createUser($request, $userId, $password)
   {
       User::create(
           [
               "name" => $request->get("first_name") . " " . $request->get("last_name"),
               "user_id" => $userId,
               "role" => $request->get("role"),
               "email" => $request->get("email"),
               "password" => bcrypt($password),
           ]
       );
    }

}
