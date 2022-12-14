<?php
namespace App\Http\Middleware;

use App\Constants\Constants;
use Closure;
use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class AuthRegisterValidate
{
    /**
     * Handle an incoming request.
     *
     * @param Request $request
     * @param  \Closure(Request): (Response|RedirectResponse)  $next
     * @return Response|RedirectResponse
     */
    public function handle(Request $request, Closure $next)
    {

        $request->validate([
            'first_name' => Constants::REQUIRE,
            'last_name' => Constants::REQUIRE,
            'email' => Constants::REQUIRE.'|email|unique:users',
            'gender' => Constants::REQUIRE,
            'role' =>Constants::REQUIRE.'|min:4',
            'department' => Constants::REQUIRE,
            'position' => Constants::REQUIRE,
            'hire_date' => 'date|required',
            'salary' => 'required|regex:/^\d+(\.\d{1,2})?$/',
        ]);

        if ($request->get("assistantId")) {
            $request->validate(['assistantId'=>'uuid|exists:Users,user_id']);
        }

        if ($request->get("tell")) {
            $request->validate(['tell'=>'min:9|max:10']);
            if(is_numeric($request->get("tell")) != 1){
                return new Response([
                    'message'=>["The tell must be numeric characters."],
                    'errors'=>["The tell must be numeric characters."],
                ],422);
            }
        }


        return $next($request);
    }
}
