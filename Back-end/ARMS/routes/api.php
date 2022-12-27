<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\BankDetailController;
use App\Http\Controllers\EmployeeController;
use App\Http\Controllers\OnboardingController;
use App\Http\Controllers\TrafficController;
use App\Http\Middleware\AdminAccess;
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
    Route::post("/reset-password", [AuthController::class,'resetPassword']);
    Route::post("/validate", [AuthController::class,'validateEmail']);

    //the register is here for temporary use is for only admin
     Route::post("/register", [AuthController::class,'create'])
         ->middleware([AuthRegisterValidate::class]);

    //authorization
    Route::group(['middleware'=>'auth:sanctum'], function () {


//        TO DO
        //search
        //pagination is not done

        //the register is here for temporary use is for only admin
//         Route::post("/register", [AuthController::class,'create'])
//             ->middleware([AuthRegisterValidate::class,AdminAccess::class]);

//        get all traffic on the website
        Route::get('/traffic', [TrafficController::class, 'getAll']);
//        change password
        Route::patch('/change-password', [AuthController::class, 'changePassword']);
        Route::post('/logout', [AuthController::class, 'logout']);
        Route::post('/deeper-logout', [AuthController::class, 'deepLogout']);
        Route::get('/user', [AuthController::class, 'user']);

//        manage employee
        Route::resource("employees", EmployeeController::class);
        Route::get("employees-statistics", [EmployeeController::class,"statistics"]);
        Route::get("search", [EmployeeController::class,"search"]);
        Route::get("payroll", [EmployeeController::class,"employeeWithBank"]);

        Route::post("upload", [EmployeeController::class,"upload"]);

        Route::resource("assistant", OnboardingController::class);
        Route::resource("bank-detail", BankDetailController::class)->middleware([AdminAccess::class]);
        Route::patch("bank-detail", [BankDetailController::class,'update']);
        Route::get("can-assistant", [OnboardingController::class, "showCanOnboard"]);
        Route::get("available-assistant", [OnboardingController::class, "showAvailable"]);

    });
});

