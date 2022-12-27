<template>
   <div class="page-header flex-wrap">
        <h3 class="mb-0"> Hi, welcome back! <span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Your Enterprise Resource Planning Center.</span>
        </h3>
       
      </div>
      <div class="row">
        <div class="col-xl-3 col-lg-12 stretch-card grid-margin">
          <div class="row">
            <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3">
              <div class="card bg-warning">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Today</p>
                      <h2 class="text-white"> {{ statistics.statistics?.added.today }}
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-basket bg-inverse-icon-warning"></i>
                  </div>
                  <h6 class="text-white">{{((statistics.statistics?.added.today)/statistics.statistics?.added.week)*100}}% Since last month</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3">
              <div class="card bg-danger">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Week</p>
                      <h2 class="text-white"> {{ statistics.statistics?.added.week }}
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-cube-outline bg-inverse-icon-danger"></i>
                  </div>
                  <h6 class="text-white">{{((statistics.statistics?.added.week)/statistics.statistics?.added.month)*100}}% Since last week</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3 pb-lg-0 pb-xl-3">
              <div class="card bg-primary">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Month</p>
                      <h2 class="text-white"> {{ statistics.statistics?.added.month }}
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-briefcase-outline bg-inverse-icon-primary"></i>
                  </div>
                  <h6 class="text-white">{{((statistics.statistics?.added.month)/statistics.statistics?.added.year)*100 }}% Since last month</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card pb-sm-3 pb-lg-0">
              <div class="card bg-success">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Year</p>
                      <h2 class="text-white">{{ statistics.statistics?.added.year }}</h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-account-circle bg-inverse-icon-success"></i>
                  </div>
                  <h6 class="text-white">{{((   statistics.statistics?.added.year - (statistics.statistics?.added.year -statistics.statistics?.added.month) )/statistics.statistics?.added.year)*100 }}% Since last year</h6>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-9 stretch-card grid-margin">
          <div class="card">
            <div class="card-body">
              <div class="row">
                <div class="col-sm-7">
                  <h5>Website Traffic</h5>
                  <p class="text-muted"> Show overview of the past month
                  </p>
                </div>
                
              </div>
              
              <div class="row my-3">
                <div class="col-sm-12">
                  <div class="flot-chart-wrapper">
                    <div id="flotChart" class="flot-chart container">
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="">
                  <h4>Quote of the Day</h4>
                
                  <p class="text-muted mb-0"> {{ quote.text }} <br><b> {{ quote.author }}</b>
                  </p>
                </div>
               
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-xl-8 col-sm-6 grid-margin stretch-card">
          <div class="card">
            <div class="card-body px-0 overflow-auto">
              <h4 class="card-title pl-4">Recent Employee</h4>
              <div class="table-responsive">
                <table class="table">
                  <thead class="bg-light">
                    <tr>
                      <th>Bio</th>
                      <th>Department</th>
                      <th>Started</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="emp of employee" >
                      <td>
                        <div class="d-flex align-items-center">
                          <img  :alt="emp.name" :src="emp.profile?emp.profile:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII='" alt="image" />
                          <div class="table-user-name ml-3">
                            <p class="mb-0 font-weight-medium"> {{ emp.first_name }} </p>
                            <small> {{ emp.email }}</small>
                          </div>
                        </div>
                      </td>
                      <td>{{ emp.department }}</td>
                      <td>
                        <div class="badge badge-inverse-success">{{ timeSince(emp.hire_date) }}</div>
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-4 col-sm-6 grid-margin stretch-card">
          <!--activity-->
          <div class="card">
            <div class="card-body">
              <h4 class="card-title">
                <span class="d-flex justify-content-between">
                  <span>Our Milestones</span>
                 
                </span>
              </h4>
              <ul class="gradient-bullet-list border-bottom">
                <li>
                  <h6 class="mb-0">Opening of operations in Takoradi, Ghana and AmaliTech gGmbH in Cologne, Germany.</h6>
                  <p class="text-muted">June 2019</p>
                </li>
                <li>
                  <h6 class="mb-0">Opening of first Training Academy, in Takoradi, Ghana.</h6>
                  <p class="text-muted">
                    <span>Dec 2019</span>
                  </p>
                </li>
                <li>
                  <h6 class="mb-0">Opening of AmaliTech Service Centre – first Training Academy graduates start working for  international clients.</h6>
                  <p class="text-muted">June 2020</p>
                </li>
                <li>
                  <h6 class="mb-0">Training Academy in Ghana moves to new, larger building.</h6>
                  <p class="text-muted">Jan & Feb 2021</p>
                </li>
                <li>
                  <h6 class="mb-0">Opening of Training Academy in Rwanda with first intake of trainees; opening of satellite office in Accra, Ghana.</h6>
                  <p class="text-muted">Oct & Dec 2021</p>
                </li>
                
              </ul>
                </div>
          </div>
          <!--activity ends-->
        </div> 
      </div>
      
      <div class="row">
        <div class="col-xl-8 grid-margin stretch-card">
          <div class="card card-calender">
            <div class="card-body">
              <div class="row pt-4">
                <div class="col-sm-6">
                  <h1 class="text-white">{{ hour }} : {{ minute }} {{ hour < 12 ?"AM":"PM"  }}</h1>
                  <h5 class="text-white">{{weekday[date.getUTCDay()]}} {{ date.getUTCDay() }} {{ month[date.getMonth()]}}, {{ date.getUTCFullYear() }}</h5>
                  <h5 class="text-white pt-2 m-0">Precipitation:50%</h5>
                  <h5 class="text-white m-0">Humidity:23%</h5>
                  <h5 class="text-white m-0">Wind:{{ current_weather.windspeed }} km/h</h5>
                </div>
                <div class="col-sm-6 text-sm-right pt-3 pt-sm-0">
                  <h3 class="text-white">Clear Sky</h3>
                  <p class="text-white m-0">Ghana, Accra</p>
                  <h3 class="text-white m-0">{{ current_weather.temperature }}°C</h3>
                </div>
              </div>
              <div class="row mt-5">
                <div class="col-sm-12">
                  <ul class="d-flex pl-0 overflow-auto">
                    <li class="weakly-weather-item text-white font-weight-medium text-center active">
                      <p class="mb-0">TODAY</p>
                      <i class="mdi mdi-weather-cloudy"></i>
                      <p class="mb-0">{{ current_weather.temperature }}<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">MON</p>
                      <i class="mdi mdi-weather-hail"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">TUE</p>
                      <i class="mdi mdi-weather-cloudy"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">WED</p>
                      <i class="mdi mdi-weather-fog"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">THU</p>
                      <i class="mdi mdi-weather-hail"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">FRI</p>
                      <i class="mdi mdi-weather-cloudy"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">SAT</p>
                      <i class="mdi mdi-weather-hail"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                    <li class="weakly-weather-item text-white font-weight-medium text-center">
                      <p class="mb-0">SUN</p>
                      <i class="mdi mdi-weather-cloudy"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-4 grid-margin stretch-card">
         <!--datepicker-->
         <div class="card">
          <div class="card-body">
            <div id="inline-datepicker" class="datepicker table-responsive"></div>
          </div>
        </div>
        <!--datepicker ends-->
        </div>
      </div>
</template>

<script setup>
import {getData,timeSince,formatDate} from '../assets/api'
import { RouterLink } from 'vue-router'
import { VueCookieNext } from 'vue-cookie-next'
import {ref} from 'vue';
document.title = "ERP Adim Dashboard"
const month = ["January","February","March","April","May","June","July","August","September","October","November","December"];
const weekday = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
const date = new Date();

var hour = ref(date.getUTCHours());
var minute = ref(date.getUTCMinutes());
var statistics = ref({});

setInterval(() => {
  const date1 = new Date();
  hour.value = date1.getUTCHours();
  minute.value = date1.getUTCMinutes() ;
}, 1000);

const employee = ref([]);
const quote = ref({});
const user = VueCookieNext.getCookie("user");
function getEmployees() {
  getData(`employees`,user.token).then(value=>{
employee.value = value.message;
if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
};
});
}

function getStatistics() {
  getData(`employees-statistics`,user.token).then(value=>{
    statistics.value = value;
  if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
};
});
}

const startAt = formatDate(date).reduce((total,value)=>total+value) - 2061;
fetch('https://type.fit/api/quotes')
  .then((response) => response.json())
  .then((data) => {
    quote.value = data[startAt];
  });
const current_weather = ref({});


  fetch('https://api.open-meteo.com/v1/forecast?latitude=7.946527&longitude=-1.023194&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m')
  .then((response) => response.json())
  .then((data) => {
    current_weather.value = data.current_weather

  });



getEmployees();
getStatistics();
</script>

<style scoped > 

</style>