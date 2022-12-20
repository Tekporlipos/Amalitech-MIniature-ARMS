<?php
namespace App\Components;
use App\Models\traffic;
class TrafficComponent
{
    private string $ip;
    private string $user_agent;

    /**
     * @return string
     */
    public function getIp(): string
    {
        return $this->ip;
    }

    /**
     * @param string $ip
     */
    public function setIp(string $ip): void
    {
        $this->ip = $ip;
    }

    /**
     * @return string
     */
    public function getUserAgent(): string
    {
        return $this->user_agent;
    }

    /**
     * @param string $user_agent
     */
    public function setUserAgent(string $user_agent): void
    {
        $this->user_agent = $user_agent;
    }

    /**
     * @return string
     */
    public function getPage(): string
    {
        return $this->page;
    }

    /**
     * @param string $page
     */
    public function setPage(string $page): void
    {
        $this->page = $page;
    }
    private string $page;
    public function __construct(String $ip, String $agent, String $page)
    {
        $this->ip = $ip;
        $this->user_agent = $agent;
        $this->page = $page;
    }

    public function saveTraffic(): void
    {
     traffic::create([
            "ip"=>$this->getIp(),
            "user_agent"=>$this->getUserAgent(),
            "page"=>$this->getPage()
        ]);
    }


}
