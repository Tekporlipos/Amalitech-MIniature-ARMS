<?php

namespace App\Http\Controllers;

use App\Constants\Constants;
use App\Models\Employee;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\DB;
use JetBrains\PhpStorm\NoReturn;

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

        if ($request->get("page")){
            $request->validate(["page"=>"required|int"]);
            $page = $request->get("page");
        }

        if ($request->get("limit")){
            $request->validate(["limit"=>"required|int"]);
            $limit = $request->get("limit");
        }

        $page = $page * $limit;

        return new Response([
            "page"=>$page/$limit,
            "limit"=>$limit,
            "total"=>Employee::count(),
            "message"=> DB::select(Constants::EMPLOYEE_USER($page, $limit))
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
            "first_name" => $request->get("firstName"),
            "last_name" => $request->get("lastName"),
            "other_names" => $request->get("otherName"),
            "gender" => $request->get("gender"),
            "hire_date" => $request->get("hireDate"),
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
    public function show(string $id)
    {

        return new Response([
            "email"=>user::where("user_id", $id)->first(['*'])->email,
            "message"=> Employee::where("user_id", $id)->first(['*']),
        ], 202);
    }


    /**
     * Display the specified resource.
     *
     * @param string $id
     * @return Response
     */
    public function search(Request $request)
    {
         $page = 0;
         $limit = 10;

        if ($request->get("page")){
            $request->validate(["page"=>"required|int"]);
            $page = $request->get("page");
        }

        if ($request->get("limit")){
            $request->validate(["limit"=>"required|int"]);
            $limit = $request->get("limit");
        }

        $page = $page * $limit;
        $search = $request->get('search');
        return new Response([
            "page"=>$page/$limit,
            "limit"=>$limit,
            "message"=> DB::select(Constants::SEARCH("%".$search."%", $page, $limit))
        ], 202);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param Request $request
     * @param string $id
     * @return Response
     */
    public function update(Request $request, string $id)
    {

        $employee =  Employee::where("user_id", $id)->first(['*']);

        if (!$employee) {
            return new Response([
                "message" => "noting to update"
            ], 404);
        }
        if ($request->get("firstName")) {
            $employee->first_name = $request->get("firstName");
        }
        if ($request->get("lastName")) {
            $employee->last_name = $request->get("lastName");
        }
        if ($request->get("otherName")) {
            if(trim(strtolower($request->get("otherName"))) == "delete"){
                $employee->other_names = null;
            }else{
                $employee->other_names = $request->get("otherName");
            }

        }

        if ($request->get("gender")) {
            $employee->gender = $request->get("gender");
        }
        if ($request->get("role")) {
            $employee->role = $request->get("role");
        }
        if ($request->get("department")) {
            $employee->department = $request->get("department");
        }
        if ($request->get("hireDate")) {
            $request->validate(['hireDate' => Constants::REQUIRE."|date"]);
            $employee->hire_date = $request->get("hireDate");
        }
        $employee->save();
        return new Response([
            "message"=>"User information updated successfully",
            "data"=>$employee
        ]);
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
            ], 504);
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
            "message"=> join("/", [Constants::URL,'profiles',$path->getFilename()])
        ], 202);
    }
}
