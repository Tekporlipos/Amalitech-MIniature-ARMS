<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TrafficController;
use App\Http\Controllers\AuthController;

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

Route::group(['prefix' => '/v1'],function (){
//    authentication
    Route::post("/register",[AuthController::class,'create'])->middleware([\App\Http\Middleware\AuthRegisterValidate::class]);
    Route::post("/login",[AuthController::class,'login']);
    Route::post("/validate",[AuthController::class,'validateEmail']);


    //authorization
    Route::group(['middleware'=>'auth:sanctum'],function (){
//        get all traffic on the website
        Route::get('/traffic',[TrafficController::class,'getAll']);
//        change password
        Route::post('/change-password',[AuthController::class,'changePassword']);
        Route::post('/logout',[AuthController::class,'logout']);
        Route::delete('/delete-account',[AuthController::class,'deleteEmployee']);
        Route::delete('/delete-employee',[AuthController::class,'deleteEmployee']);







    });
});

