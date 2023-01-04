<?php
namespace App\Http\Controllers;

use App\Constants\Constants;
use App\Models\BankDetails;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class BankDetailController extends Controller
{

    /**
     * Store a newly created resource in storage.
     *
     * @param Request $request
     * @return Response
     */
    public function store(Request $request): Response
    {

        $id = $request->user()->user_id;


        if (sizeof(BankDetails::where("user_id", $id)->get())) {
            return  new Response([
                "message"=>"User bank detail already exist"
            ], 403);
        }

        $request->validate([
            "account_name"=>Constants::REQUIRE,
            "bank_name"=>Constants::REQUIRE,
            "account_number"=> Constants::REQUIRE.'|min:10',
            "bank_branch"=>Constants::REQUIRE,
        ]);

        if ($request->get("tell")) {
            $request->validate(["tell"=>'min:9']);
        }

        return new Response(BankDetails::create([
            "account_name"=>$request->get("account_name"),
            "user_id"=>$id,
            "bank_name"=>$request->get("bank_name"),
            "account_number"=> $request->get("account_number"),
            "bank_branch"=>$request->get("bank_branch")
        ]));

    }

    /**
     * Display the specified resource.
     *
     * @param Request $request
     * @return Response
     */
    public function index(Request $request) : Response
    {
        $user = $request->user();
        return new Response(BankDetails::where("user_id", $user->user_id)->get());
    }


    /**
     * Update the specified resource in storage.
     *
     * @param Request $request
     * @return Response
     */
    public function update(Request $request): Response
    {
        $bankDetails =  BankDetails::where("user_id", $request->user()->user_id)->first(['*']);
        if ($request->get("bank_name")) {
            $bankDetails->bank_name = $request->get("bank_name");
        }
        if ($request->get("bank_branch")) {
            $bankDetails->bank_branch = $request->get("bank_branch");
        }
        if ($request->get("account_name")) {
            $bankDetails->account_name = $request->get("account_name");
        }
        if ($request->get("account_number")) {
            $request->validate(['account_number' => Constants::REQUIRE.'|min:10']);
            $bankDetails->account_number = $request->get("account_number");
        }
        if ($request->get("tell")) {
            $request->validate(['tell' => Constants::REQUIRE."|min:9"]);
            $bankDetails->tell = $request->get("tell");
        }
        $bankDetails->save();
        return new Response($bankDetails, 202);
    }
}
