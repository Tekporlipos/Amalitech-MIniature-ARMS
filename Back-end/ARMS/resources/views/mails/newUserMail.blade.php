<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Laravel</title>

    <!-- Fonts -->
    <link href="https://fonts.bunny.net/css2?family=Nunito:wght@400;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="./css/app.css">

    <style>
        body {
            font-family: 'Nunito', sans-serif;
        }
    </style>
</head>
<body class="antialiased">
<div class="relative flex items-top justify-center min-h-screen bg-gray-100 dark:bg-gray-900 sm:items-center py-4 sm:pt-0">



    <div class="max-w-6xl mx-auto sm:px-6 lg:px-8">
        <div class="flex justify-center pt-8 sm:justify-start sm:pt-0">
            <h1> Hello {{$employee->gender=="male"?"Mr":"Miss"}} {{$employee->first_name}},</h1>
        </div>

        <div class="mt-8 bg-white dark:bg-gray-800 overflow-hidden shadow sm:rounded-lg">
            <div class="p-6">
                <div class="flex items-center">
                    <svg style="width:24px;height:24px" class="text-gray-500" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M7 12C9.2 12 11 10.2 11 8S9.2 4 7 4 3 5.8 3 8 4.8 12 7 12M11 20V14.7C9.9 14.3 8.5 14 7 14C3.1 14 0 15.8 0 18V20H11M15 4C13.9 4 13 4.9 13 6V18C13 19.1 13.9 20 15 20H22C23.1 20 24 19.1 24 18V6C24 4.9 23.1 4 22 4H15Z" />
                    </svg>
                    <div class="ml-4 text-lg leading-7 font-semibold"><a href="https://laravel.com/docs" class="underline text-gray-900 dark:text-white">John Dzikunu</a></div>
                </div>

                <div class="ml-12">
                    <div class="mt-2 text-gray-600 dark:text-gray-400 text-sm">
                        <b>Welcome To AmaliTech!</b> <br>
                        You have been onboarded onto Amalitech Resource Management System (ARMS). <br>
                        Reporting Date: {{$employee->hire_date}} <br>
                        Reporting Time: 07:30 <br>
                        Reporting Branch: TAKORADI <br>
                        Contact Person: Anita Nana Ama Agyepong <br>
                        <b>Hire Instruction: Congratulations once again! Please reach out to us if you have any challenges.</b>
                        <br>
                        <blockquote>
                            <ul>
                                <li>Please login with the credentials below:</li>
                                <li>Email: {{$email}}</li>
                                <li>Password: {{$password}}</li>
                            </ul>
                        </blockquote>

                    </div>
                </div>
            </div>
            <hr>
            <div class="grid grid-cols-1 md:grid-cols-2">
                <div class="p-6">
                    <div class="flex items-center">
                        <svg fill="none" style="width:24px;height:24px" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" class="w-8 h-8 text-gray-500"><path d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.747 0 3.332.477 4.5 1.253v13C19.832 18.477 18.247 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"></path></svg>
                        <div class="ml-4 text-lg leading-7 font-semibold"><a href="https://amalitech.org/wp-content/uploads/2021/04/Integrity.jpg" class="underline text-gray-900 dark:text-white">Integrity</a></div>
                    </div>

                    <div class="ml-12">
                        <div class="mt-2 text-gray-600 dark:text-gray-400 text-sm">
                           At Amalitech, we share moral principles that cannot be compromised. We adhere to ethics and strive for authenticity, as well as consistency in our thoughts and actions. Amalitech cares about the legal safety, trust and reputation of everyone associated with the company, and we aim at reflecting our core value through honest and transparent communication.
                        </div>
                    </div>
                </div>

                <div class="p-6 border-t border-gray-200 dark:border-gray-700 md:border-t-0 md:border-l">
                    <div class="flex items-center">
                        <svg fill="none" style="width:24px;height:24px" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" class="w-8 h-8 text-gray-500"><path d="M3 9a2 2 0 012-2h.93a2 2 0 001.664-.89l.812-1.22A2 2 0 0110.07 4h3.86a2 2 0 011.664.89l.812 1.22A2 2 0 0018.07 7H19a2 2 0 012 2v9a2 2 0 01-2 2H5a2 2 0 01-2-2V9z"></path><path d="M15 13a3 3 0 11-6 0 3 3 0 016 0z"></path></svg>
                        <div class="ml-4 text-lg leading-7 font-semibold"><a href="https://amalitech.org/wp-content/uploads/2021/03/Collabo-2.jpg" class="underline text-gray-900 dark:text-white">Collaboration</a></div>
                    </div>

                    <div class="ml-12">
                        <div class="mt-2 text-gray-600 dark:text-gray-400 text-sm">
                           At amalitech, we believe that collaboration is key. As a group of individuals, we work towards one common goals - hand in hand - pushing our agenda forward with utmost efficiency. We recognize individual strength, value the contribution of others, and enrich our work through the experience, skills, and perspective of our team members.
                        </div>
                    </div>
                </div>

                <div class="p-6 border-t border-gray-200 dark:border-gray-700">
                    <div class="flex items-center">
                        <svg fill="none" style="width:24px;height:24px" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" class="w-8 h-8 text-gray-500"><path d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z"></path></svg>
                        <div class="ml-4 text-lg leading-7 font-semibold"><a href="https://amalitech.org/wp-content/uploads/2021/04/Passion.jpg" class="underline text-gray-900 dark:text-white">Passion</a></div>
                    </div>

                    <div class="ml-12">
                        <div class="mt-2 text-gray-600 dark:text-gray-400 text-sm">
                            Passion is the driving force that allow for us to keep learning and growing. At AmaliTech, we are committed to our work and what it stands for - creating impacting, that provides opportunities for many and has meaning to us as individuals. We gladly go the extra mile to perform our duties and achieve our goals - enjoying every bit of the journey along the way!
                        </div>
                    </div>
                </div>

                <div class="p-6 border-t border-gray-200 dark:border-gray-700 md:border-l">
                    <div class="flex items-center">
                        <svg fill="none" style="width:24px;height:24px" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" class="w-8 h-8 text-gray-500"><path d="M3.055 11H5a2 2 0 012 2v1a2 2 0 002 2 2 2 0 012 2v2.945M8 3.935V5.5A2.5 2.5 0 0010.5 8h.5a2 2 0 012 2 2 2 0 104 0 2 2 0 012-2h1.064M15 20.488V18a2 2 0 012-2h3.064M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
                        <div class="ml-4 text-lg leading-7 font-semibold text-gray-900 dark:text-white"><a href="https://amalitech.org/wp-content/uploads/2021/02/core-2.jpg" class="underline text-gray-900 dark:text-white">Excellence</a></div>
                    </div>

                    <div class="ml-12">
                        <div class="mt-2 text-gray-600 dark:text-gray-400 text-sm">

                            Excellence at AmaliTech Means working to the best of your ability.
                            Striving for extraordinary achievement, and surpassing internal and external expectations.
                            It is our priority to provide high quality work and outstanding result wih maximum level of
                            professionalism and most efficient use of resources.

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class="flex justify-center mt-4 sm:items-center sm:justify-between">
            <div class="text-center text-sm text-gray-500 sm:text-left">
                <div class="flex items-center">
                    <a href="https://arms-beta.amalitech.org/home" class="ml-1 underline">Amalitech Service Center</a>
                </div>
            </div>
            <div class="ml-4 text-center text-sm text-gray-500 sm:text-right sm:ml-0">Enterprise Resource Planning
                (ERP)
            </div>
        </div>
    </div>
</div>
</body>
</html>
