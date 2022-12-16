<?php

namespace App\Jobs;

use App\Mail\EmployeeMail;
use Illuminate\Bus\Queueable;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Foundation\Bus\Dispatchable;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Queue\SerializesModels;
use Illuminate\Support\Facades\Mail;

class MailSender implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;

    /**
     * Create a new job instance.
     *
     * @return void
     */

    private $employee;
    private string $email;
    private int $password;
    public function __construct($employee,$email,$password)
    {
        $this->employee = $employee;
        $this->email = $email;
        $this->password = $password;
    }

    /**
     * Execute the job.
     *
     * @return void
     */
    public function handle(): void
    {
        Mail::to($this->email)->send(New EmployeeMail($this->employee,$this->email,$this->password));
    }
}
