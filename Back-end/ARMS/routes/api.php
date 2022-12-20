<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\BankDetailController;
use App\Http\Controllers\EmployeeController;
use App\Http\Controllers\OnboardingController;
use App\Http\Controllers\TrafficController;
use App\Http\Middleware\AuthRegisterValidate;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group(['prefix' => '/v1'], function ()
{
//    authentication
    Route::post("/login", [AuthController::class,'login']);
    Route::post("/validate", [AuthController::class,'validateEmail']);

    //authorization
    Route::group(['middleware'=>'auth:sanctum'], function () {

        //the register is here for temporary use is for only admin
        Route::post("/register", [AuthController::class,'create'])
            ->middleware([AuthRegisterValidate::class]);

//        get all traffic on the website
        Route::get('/traffic', [TrafficController::class, 'getAll']);
//        change password
        Route::post('/change-password', [AuthController::class, 'changePassword']);
        Route::post('/logout', [AuthController::class, 'logout']);

//        manage employee
        Route::resource("employees", EmployeeController::class);
        Route::resource("assistant", OnboardingController::class);
        Route::resource("bank-detail", BankDetailController::class);
        Route::patch("bank-detail", [BankDetailController::class,'update']);
        Route::get("can-assistant", [OnboardingController::class, "showCanOnboard"]);
        Route::get("available-assistant", [OnboardingController::class, "showAvailable"]);

    });
});

