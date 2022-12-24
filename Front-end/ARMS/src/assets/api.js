const path = "http://127.0.0.1:8000/api/v1/";

export  async function postData(url,data,token) {
    const  response = await fetch(path+url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache', 
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': 'Bearer '+token
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', 
        referrerPolicy: 'no-referrer', 
        body: JSON.stringify(data)
      });
      return response.json(); 
}

export  async function getData(url,token) {
    const  response = await fetch(path+url, {
        method: 'GET',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin', 
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': 'Bearer '+token, 
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', 
        referrerPolicy: 'no-referrer', 
      });
      return response.json(); 
}

export  async function deleteData(url,token) {
    const  response = await fetch(path+url, {
        method: 'DELETE',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin', 
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': 'Bearer '+token, 
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', 
        referrerPolicy: 'no-referrer', 
      });
      return response.json(); 
}

export  async function patchData(url,data,token) {
    const  response = await fetch(path+url, {
        method: 'PATCH',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin', 
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': 'Bearer '+token, 
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', 
        referrerPolicy: 'no-referrer', 
        body: JSON.stringify(data),
      });
      return response.json(); 
}

export function timeSince(DateString) {

    const date = Date.now() - (Date.now() - (new Date(DateString)))
  
    var seconds = Math.floor((new Date() - date) / 1000);
    
    var interval = seconds / 31536000;
    
    if (interval > 1) {
      return Math.abs(Math.floor(interval)) + (interval > 0 ?" year(s) ago":" year(s) from now");
    }
    interval = seconds / 2592000;
    if (Math.abs(interval) > 1) {
      return Math.abs(Math.floor(interval)) +  (interval > 0 ?" month(s) ago":" month(s) from now");
    }
    interval = seconds / 86400;
    if (Math.abs(interval) > 1) {
      return Math.abs(Math.floor(interval)) +  (interval > 0 ?" day(s) ago":" day(s) from now");
    }
    interval = seconds / 3600;
    if (Math.abs(interval) > 1) {
      return Math.abs(Math.floor(interval)) +  (interval > 0 ?" hour(s) ago":" hour(s) from now");
    }
    interval = seconds / 60;
    if (Math.abs(interval) > 1) {
      return    Math.abs(Math.floor(interval)) + (interval > 0 ?" minute(s) ago":" minute(s) from now");
    }
    return Math.abs(Math.floor(interval)) +  (interval > 0 ? " second(s) ago":" second(s) from now");

    }