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

    /**
     * Create a new message instance.
     *
     * @return void
     */
    public function __construct($employee,$email,$password)
    {
        $this->employee = $employee;
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
            from: new Address('johntekporlipos@outlook.com', 'John Dzikunu'),
            replyTo: [
                new Address('john.dzikunu@amalitech.com', 'john dzikunu'),
            ],
            subject: 'New user onboarding'
        );
    }

    /**
     * Get the message content definition.
     *
     * @return \Illuminate\Mail\Mailables\Content
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
