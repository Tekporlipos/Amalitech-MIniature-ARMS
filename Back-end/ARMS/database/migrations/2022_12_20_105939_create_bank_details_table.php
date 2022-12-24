<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up(): void
    {
        Schema::create('bank_details', function (Blueprint $table) {
            $table->id();
            $table->string("user_id")->unique()->index();;
            $table->foreign('user_id')->references('user_id')->on('users')->onDelete('cascade');
            $table->string("bank_name")->nullable();
            $table->string("account_name")->nullable();
            $table->string("bank_branch")->nullable();
            $table->string("account_number")->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down(): void
    {
        Schema::dropIfExists('bank_details');
    }
};
