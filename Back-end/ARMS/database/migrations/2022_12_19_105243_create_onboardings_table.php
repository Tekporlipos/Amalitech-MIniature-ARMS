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
        Schema::create('onboardings', function (Blueprint $table) {
            $table->id();
            $table->uuid("user_id")->unique()->index();
            $table->foreign('user_id')->references('user_id')->on('users')->onDelete('cascade');
            $table->string("location")->nullable()->default("Takoradi");
            $table->string("start_date");
            $table->string("start_time")->nullable()->default("07:30 AM");
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
        Schema::dropIfExists('onboardings');
    }
};
