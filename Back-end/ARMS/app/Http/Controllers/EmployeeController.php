<?php

namespace App\Http\Controllers;

use App\Constants\Constants;
use App\Models\Employee;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\DB;

class EmployeeController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return array
     */
    public function index(): array
    {
        return DB::select(Constants::EMPLOYEE_USER);
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
            "other_names" => $request->get("other_names"),
            "gender" => $request->get("gender"),
            "hire_date" => $request->get("hire_date"),
            "department" => $request->get("department"),
        ]);
    }


    /**
     * Display the specified resource.
     *
     * @param string $id
     * @return Response
     */
    public function show(string $id): Response
    {
        return Employee::where("user_id", $id)->first(['*']);
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

        if (!$employee) {
            return new Response([
                "message" => "noting to update"
            ], 404);
        }
        if ($request->get("first_name")) {
            $employee->first_name = $request->get("first_name");
        }
        if ($request->get("last_name")) {
            $employee->last_name = $request->get("last_name");
        }
        if ($request->get("other_name")) {
            $employee->other_names = $request->get("other_name");
        }
        if ($request->get("email")) {
            $request->validate(['email' => Constants::REQUIRE.'|email|unique:users']);
            $employee->email = $request->get("email");
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
        if ($request->get("hire_date")) {
            $request->validate(['hire_date' => Constants::REQUIRE."|date"]);
            $employee->hire_date = $request->get("hire_date");
        }
        $employee->save();
        return $employee->get();
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
}
