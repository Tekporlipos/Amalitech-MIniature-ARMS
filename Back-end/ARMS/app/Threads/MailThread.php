<?php

namespace App\Threads;


use Thread;

class MailThread extends Thread
{

    private $mail;
    public function __construct($mail)
    {
        $this->mail = $mail;
    }

    public function run()
    {
      dd("je;;p");
    }


}
