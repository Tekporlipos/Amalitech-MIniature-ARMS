<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

class AuthRegisterValidate
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure(\Illuminate\Http\Request): (\Illuminate\Http\Response|\Illuminate\Http\RedirectResponse)  $next
     * @return \Illuminate\Http\Response|\Illuminate\Http\RedirectResponse
     */
    public function handle(Request $request, Closure $next)
    {

        $request->validate([
            'firstName'=>'string|required',
            'lastName'=>'string|required',
            'email'=>'string|required|email|unique:users',
            'gender'=>'string|required',
            'department'=>'string|required',
            'hireDate'=>'date|required',
        ]);


        return $next($request);
    }
}
