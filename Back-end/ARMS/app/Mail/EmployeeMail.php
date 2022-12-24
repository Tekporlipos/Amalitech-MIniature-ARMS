<?php

namespace App\Mail;
use Illuminate\Bus\Queueable;
use Illuminate\Mail\Mailable;
use Illuminate\Mail\Mailables\Address;
use Illuminate\Mail\Mailables\Content;
use Illuminate\Mail\Mailables\Envelope;
use Illuminate\Queue\SerializesModels;

class EmployeeMail extends Mailable
{
    use Queueable, SerializesModels;

    private $employee;
    private $password;
    private string $email;
    private string $assistantName;

    /**
     * Create a new message instance.
     *
     * @return void
     */
    public function __construct($employee, $email, $password, $assistantName)
    {
        $this->employee = $employee;
        $this->assistantName  = $assistantName;
        $this->email  = $email;
        $this->password = $password;
    }

    /**
     * Get the message envelope.
     *
     * @return \Illuminate\Mail\Mailables\Envelope
     */
    public function envelope(): Envelope
    {
        return new Envelope(
            from: new Address(env("MAIL_FROM_ADDRESS"), env('MAIL_FROM_NAME')),
            replyTo: [
                new Address(env('HELP_EMAIL'), env('HELP_NAME')),
            ],
            subject: 'New user onboarding'
        );
    }

    /**
     * Get the message content definition.
     *
     * @return Content
     */
    public function content(): Content
    {
        return new Content(
            view: 'mails.newUserMail',
//            view: 'welcome',
            with: [
                'employee' => $this->employee,
                'password' => $this->password,
                'email' => $this->email,
                'name' => $this->assistantName,
            ],
//            text: 'emails.orders.shipped-text'
        );
    }

    /**
     * Get the attachments for the message.
     *
     * @return array
     */
    public function attachments(): array
    {
        return [
//            Attachment::fromPath('/path/to/file')
//                ->as('name.pdf')
//                ->withMime('application/pdf'),
        ];
    }
}
