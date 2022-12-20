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
    public function up()
    {
        Schema::create('employees', function (Blueprint $table) {
            $table->id();
            $table->uuid("user_id")->index();;
            $table->foreign('user_id')->references('user_id')->on('users')->onDelete('cascade');
            $table->string("first_name");
            $table->string("last_name");
            $table->string("other_names")->nullable();
            $table->string("gender");
            $table->string("hire_date");
            $table->string("department");
            $table->softDeletes();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('employees');
    }
};
