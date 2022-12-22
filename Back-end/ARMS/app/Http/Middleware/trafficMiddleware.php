<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use App\Components\TrafficComponent;
use App\Http\Controllers\TrafficController;
class trafficMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure(\Illuminate\Http\Request): (\Illuminate\Http\Response|\Illuminate\Http\RedirectResponse)  $next
     * @return \Illuminate\Http\Response|\Illuminate\Http\RedirectResponse
     */
    public function handle(Request $request, Closure $next)  {

        $ip = $request->ip();
        $user_agent = $request->headers->get("user-agent");
        $page = $request->getRequestUri();

        $traffic = new TrafficComponent($ip, $user_agent, $page);
        $traffic->saveTraffic();

        return $next($request);
    }
}
