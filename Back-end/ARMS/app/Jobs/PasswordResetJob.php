<?php

namespace App\Jobs;

use App\Mail\EmployeeMail;
use App\Mail\ResetPasswordMail;
use Illuminate\Bus\Queueable;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Foundation\Bus\Dispatchable;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Queue\SerializesModels;
use Illuminate\Support\Facades\Mail;

class PasswordResetJob implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;

    /**
     * Create a new job instance.
     *
     * @return void
     */
    private string $email;
    private string $password;
    public function __construct(string $password, string $email)
    {
        $this->password= $password;
        $this->email= $email;
    }


    /**
     * Execute the job.
     *
     * @return void
     */
    public function handle(): void
    {
        Mail::to($this->email)
            ->send(new ResetPasswordMail($this->email, $this->password));

    }
}
