<?php

namespace App\Http\Controllers;

use App\Constants\Constants;
use App\Models\Employee;
use App\Models\User;
use DateTime;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\DB;

class EmployeeController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @param Request $request
     * @return Response
     */
    public function index(Request $request): Response
    {
        $page = 0;
        $limit = 10;
        $this->checkPageAndLimit($request);
        return new Response([
            "page"=>$page/$limit,
            "limit"=>$limit,
            "total"=>Employee::count(),
            "message"=> DB::select(Constants::employeeUser($page, $limit))
        ], 202);
    }

    /**
     * Display a listing of the resource.
     *
     * @return array
     */
    public function employeeWithBank(): array
    {
        return DB::select(Constants::EMPLOYEE_PAYROLL);
    }


    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function statistics(): Response
    {

        $datetime = new DateTime();
        return new Response([
            "message"=>"The statistics of employees from the time of request",
            "statistics"=>[
                "total"=>Employee::count(),
                "gender"=>[
                    "female"=>Employee::where("gender", "female")->count(),
                    "male"=>Employee::where("gender", "male")->count(),
                ],
                "added"=>[
                    "today"=>Employee::whereDate(
                        Constants::CREATED, '>=', $datetime
                        ->modify('-1 day')
                        ->format(Constants::DATEFORMAT))
                        ->whereDate(Constants::CREATED, '<=', date_create())->count(),
                    "week"=>Employee::whereDate(
                        Constants::CREATED, '>=', $datetime
                        ->modify('-1 week')
                        ->format(Constants::DATEFORMAT))
                        ->whereDate(Constants::CREATED, '<=', date_create())->count(),
                    "month"=>Employee::whereDate(
                        Constants::CREATED,
                        '>=', $datetime
                        ->modify('-1 month')
                        ->format(Constants::DATEFORMAT))
                        ->whereDate(Constants::CREATED, '<=', date_create())->count(),
                    "year"=>Employee::whereDate(
                        Constants::CREATED, '>=', $datetime
                        ->modify('-1 year')
                        ->format(Constants::DATEFORMAT))
                        ->whereDate(Constants::CREATED, '<=', date_create())->count()
                ]
            ]

        ]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @param Request $request
     * @param string $userId
     * @return Employee
     */
    public function create(Request $request, string $userId): Employee
    {
        return Employee::create([
            "user_id" => $userId,
            "first_name" => $request->get("first_name"),
            "last_name" => $request->get("last_name"),
            "other_names" => $request->get("other_name"),
            "gender" => $request->get("gender"),
            "hire_date" => $request->get("hire_date"),
            "position" => $request->get("position"),
            "tell" => $request->get("tell"),
            "salary" => $request->get("salary"),
            "department" => $request->get("department"),
        ]);
    }


    /**
     * Display the specified resource.
     *
     * @param string $id
     * @return Response
     */
    public function show(string $id):Response
    {
        return new Response(DB::select(Constants::employeeById($id)));
    }


    /**
     * Display the specified resource.
     *
     * @param Request $request
     * @return Response
     */
    public function search(Request $request): Response
    {
         $page = 0;
         $limit = 10;
        $this->checkPageAndLimit($request);
        $search = $request->get('search');
        return new Response([
            "page"=>$page/$limit,
            "limit"=>$limit,
            "message"=> DB::select(Constants::search("%".$search."%", $page, $limit))
        ], 202);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param Request $request
     * @param string $id
     * @return Response
     */
    public function update(Request $request, string $id): Response
    {
        $employee =  Employee::where("user_id", $id)->first(['*']);

        if (($request->user()->role=="admin" || $request->user()->user_id == $id)
            && $employee) {

            $this->checkAvailable($request);
            $employee->save();

            return new Response([
                "message"=>"User information updated successfully",
                "data"=>$employee
            ]);
        }
        return new Response([
            "message"=>"unauthorized request"
        ], 401);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param Request $request
     * @param string $id
     * @return Response
     */
    public function destroy(Request $request, string $id): Response
    {
        $user = $request->user();
        if ($user->get("role")[0]["role"] == "admin") {
            User::where("user_id", $id)->delete();
            Employee::where("user_id", $id)->delete();
            return new Response([
                "message" => "Employee deleted successfully"
            ], 201);
        } else {
            return new Response([
                "message" => "unauthorized request"
            ], 401);
        }
    }


 public function upload(Request $request): Response
    {

        $request->validate(['profile'=>"file|mimes:jpeg,jpg,png,gif|required|max:10000"]);
        $file = $request->file('profile');
        //Move Uploaded File
        $destinationPath = 'profiles';
      $path =  $file->move($destinationPath, date("Y-m-d H-i-s").$file->getClientOriginalName());
      $user = $request->user();
      $user->profile = join("/", [Constants::URL,'profiles',$path->getFilename()]);
      $user->save();
        return new Response([
            "message"=> $user->profile
        ], 202);
    }


   public function checkPageAndLimit(Request $request)
   {
       global  $page,$limit;
       if ($request->get("page")) {
           $request->validate(["page"=>"required|int"]);
           $page = $request->get("page");
       }
       if ($request->get("limit")) {
           $request->validate(["limit"=>"required|int"]);
           $limit = $request->get("limit");
       }
       $page = $page * $limit;
   }

 public  function checkAvailable(Request $request)
 {
        global $employee;
         if ($request->get("first_name")) $employee->first_name = $request->get("first_name");
         if ($request->get("last_name")) $employee->last_name = $request->get("last_name");
         if ($request->get("position")) $employee->position = $request->get("position");
         if ($request->get("gender")) $employee->gender = $request->get("gender");
         if ($request->get("department")) $employee->department = $request->get("department");

     if ($request->get("tell")) {
         $request->validate(['tell'=>'min:9|max:10']);
         if (is_numeric($request->get("tell")) != 1) {
             return new Response([
                 'message'=>["The tell must be numeric characters."],
                 'errors'=>["The tell must be numeric characters."],
             ], 422);
         }
         $employee->tell = $request->get("tell");
     }
     if ($request->get("other_names")) {
         if (trim(strtolower($request->get("other_names"))) == "delete") {
             $employee->other_names = null;
         } else {
             $employee->other_names = $request->get("other_names");
         }
     }
     if ($request->get("hire_date")) {
         $request->validate(['hire_date' => Constants::REQUIRE."|date"]);
         $employee->hire_date = $request->get("hire_date");
     }
 }

}
