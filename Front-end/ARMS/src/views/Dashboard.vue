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
                      <h2 class="text-white"> 10
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-basket bg-inverse-icon-warning"></i>
                  </div>
                  <h6 class="text-white">18.33% Since last month</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3">
              <div class="card bg-danger">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Week</p>
                      <h2 class="text-white"> 100
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-cube-outline bg-inverse-icon-danger"></i>
                  </div>
                  <h6 class="text-white">13.21% Since last week</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3 pb-lg-0 pb-xl-3">
              <div class="card bg-primary">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Month</p>
                      <h2 class="text-white"> 130
                      </h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-briefcase-outline bg-inverse-icon-primary"></i>
                  </div>
                  <h6 class="text-white">67.98% Since last month</h6>
                </div>
              </div>
            </div>
            <div class="col-xl-12 col-md-6 stretch-card pb-sm-3 pb-lg-0">
              <div class="card bg-success">
                <div class="card-body px-3 py-4">
                  <div class="d-flex justify-content-between align-items-start">
                    <div class="color-card">
                      <p class="mb-0 color-card-head">Last Year</p>
                      <h2 class="text-white">2368</h2>
                    </div>
                    <i class="card-icon-indicator mdi mdi-account-circle bg-inverse-icon-success"></i>
                  </div>
                  <h6 class="text-white">20.32% Since last year</h6>
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
                <div class="col-sm-5 text-md-right">
                  <button type="button" class="btn btn-icon-text mb-3 mb-sm-0 btn-inverse-primary font-weight-normal">
                    <i class="mdi mdi-email btn-icon-prepend"></i>Download Report </button>
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
                
                  <p class="text-muted mb-0"> Always seek out the seed of triumph in every adversity. <br><b> Og Mandino</b>
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
                    <tr>
                      <td>
                        <div class="d-flex align-items-center">
                          <img src="assets/images/faces/face1.jpg" alt="image" />
                          <div class="table-user-name ml-3">
                            <p class="mb-0 font-weight-medium"> John Dzikunu </p>
                            <small> dzikunujohn36@gmail.com</small>
                          </div>
                        </div>
                      </td>
                      <td>Service Center</td>
                      <td>
                        <div class="badge badge-inverse-success"> 2h ago </div>
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
              <a class="text-black mt-3 d-block pl-4" href="#">
                <span class="font-weight-medium h6">View all</span>
                <i class="mdi mdi-chevron-right"></i></a>
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
                  <h1 class="text-white">10:16PM</h1>
                  <h5 class="text-white">Monday 25 October, 2016</h5>
                  <h5 class="text-white pt-2 m-0">Precipitation:50%</h5>
                  <h5 class="text-white m-0">Humidity:23%</h5>
                  <h5 class="text-white m-0">Wind:13 km/h</h5>
                </div>
                <div class="col-sm-6 text-sm-right pt-3 pt-sm-0">
                  <h3 class="text-white">Clear Sky</h3>
                  <p class="text-white m-0">London, UK</p>
                  <h3 class="text-white m-0">21°C</h3>
                </div>
              </div>
              <div class="row mt-5">
                <div class="col-sm-12">
                  <ul class="d-flex pl-0 overflow-auto">
                    <li class="weakly-weather-item text-white font-weight-medium text-center active">
                      <p class="mb-0">TODAY</p>
                      <i class="mdi mdi-weather-cloudy"></i>
                      <p class="mb-0">21<span class="symbol">°c</span></p>
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
</script>