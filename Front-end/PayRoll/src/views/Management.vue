<template>       
    <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Your Payroll Generation Center.</span>
              </h3>
              <div class="d-flex">
               <button type="button" @click="generatePayRoll()"  class="btn btn-sm ml-3 btn-success"> Generate Payroll</button>
               <button type="button" @click="rewardType = true"  class="btn btn-sm ml-3 btn-success"> Add Reward Type</button>
              </div>
            </div>
            
            <div class="row">
              <div class="col-xl-12 col-sm-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body px-0 overflow-auto">
                    <h4 class="card-title pl-4">Onboard Employees</h4>
                    <div class="table-responsive">
                      <table class="table">
                        <thead class="bg-light">
                          <tr>
                            <th>Bio</th>
                            <th>Department</th>
                            <th>SSF(5%)</th>
                            <th>Salary</th>
                            <th>Reward</th>
                            <th>Actions</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="employ of employee">
                            <td>
                              <div class="d-flex align-items-center">
                                <img :src="employ.profile != 'null'?employ.profile:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII='" class="img" alt="image" />
                                <div class="table-user-name ml-3">
                                  <p class="mb-0 font-weight-medium"> {{ employ.first_name }} {{ employ.other_names != 'null'?employ.other_names:"" }} {{ employ.last_name }} </p>
                                  <small> {{ employ.email }}</small><br>
                                  <small> {{ employ.tell }}</small><br>
                                  <small> {{ employ.gender }}</small>
                                </div>
                              </div>
                            </td>
                            <td>
                              <div class="table-user-name">
                                  <small> {{ employ.department }}</small><br>
                                  <small> {{ employ.position }}</small>
                                </div>
                            </td>
                            <td>{{ formatter.format(employ.ssf) }}</td>
                            <td>{{ formatter.format(employ.salary) }}</td>
                            <td>
                              <div> {{ formatter.format(employ.bonus + employ.allowance) }}</div>
                            </td>
                            <td>
                             
                          <div class="dropdown">
                              <svg class="dropdown-toggle" type="button" id="actions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:24px;height:24px"  viewBox="0 0 24 24">
                                <path fill="currentColor" d="M12,16A2,2 0 0,1 14,18A2,2 0 0,1 12,20A2,2 0 0,1 10,18A2,2 0 0,1 12,16M12,10A2,2 0 0,1 14,12A2,2 0 0,1 12,14A2,2 0 0,1 10,12A2,2 0 0,1 12,10M12,4A2,2 0 0,1 14,6A2,2 0 0,1 12,8A2,2 0 0,1 10,6A2,2 0 0,1 12,4Z" />
                            </svg>
                            <div class="dropdown-menu" aria-labelledby="actions">
                  
                              <div class="dropdown-item" href="#">
                                <button type="button" @click="addReward=true" class="btn btn-sm ml-3 btn-success"> Add Reward</button>
                                <button class="btn btn-danger btn-md m-1" @click="view = true">View Rewards</button>
                                
                              </div>
                             
                            </div>
                          </div>
                        </td>
                          </tr>
              
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="page-header flex-wrap container">
                    <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">{{ employee.length + (10 * page) }} <i><small>0f</small></i> {{ total }}</span>
                    </h3>
                    <div class="d-flex">
                      <button class="btn btn-outline-default " :disabled="page==0" @click="prev()"> 
                        <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M20,11V13H8L13.5,18.5L12.08,19.92L4.16,12L12.08,4.08L13.5,5.5L8,11H20Z" />
                    </svg> 
                    Prev.
                  </button>
      
              <button class="btn btn-outline-default" :disabled="employee.length + (10 * page)  == total" @click="next()"> 
                Next
                    <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M4,11V13H16L10.5,18.5L11.92,19.92L19.84,12L11.92,4.08L10.5,5.5L16,11H4Z" />
                  </svg>
              </button>
             </div>
                  </div>
                </div>
              </div>
            </div>



             <!-- view payroll -->

             <GDialog v-model="view" persistent  max-width="50%">
              <div class="card">
                <div class="card-title p-2 pl-5">
                  <h4><b>John Dzikunu</b></h4>
                </div>
                <div class="card-content container">

                  <div class="card-body px-0 overflow-auto">
      <h4 class=" pl-4 bold"><b>Bonus</b></h4>
      <div class="table-responsive">
        <table class="table">
        
          <tbody>
            <tr>
              <td>Basic Salary</td>
              <td>ddd </td>
              <td> <div class="require text-danger btn" @click="deleteed = true">X</div></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="card-body px-0 overflow-auto">
      <h4 class="card-title pl-4 bold"><b>Allowance</b></h4>
      <div class="table-responsive">
        <table class="table">
          <tbody>
            <tr>
              <td>Basic Salary</td>
              <td>ddd </td>
              <td> <div class="require text-danger btn" @click="deleteed = true">X</div> </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

                </div>
                <div class="card-footer">
  <div class="page-header flex-wrap">
<h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
</h3>
<div class="d-flex">
  <button type="button" @click="view=false"  class="btn btn-sm ml-3 btn-defualt"> Close </button>
  <input type="submit"  value="Add"  class="btn btn-sm ml-3 btn-success">
</div>
  </div>
</div>
              </div>
            </GDialog>



            <!-- generate payroll -->

            <GDialog v-model="generating" persistent  max-width="100">
              <div id="wrapper">
    
                <div class="profile-main-loader">
                  <div class="loader">
                    <svg class="circular-loader" viewBox="25 25 50 50" >
                      <circle class="loader-path" cx="50" cy="50" r="20" fill="none" stroke="#e97b3b" stroke-width="2" />
                    </svg>
                  </div>
                </div>
        
              </div>
            </GDialog>



            <!-- add reward -->

            <GDialog v-model="rewardType" persistent  max-width="500">
              <div class="card">
                <div class="card-title text-center p-2">
                  <h4>Add Reward Type</h4>
                </div>
                <div class="card-content container">
<form class="forms-sample" action="">

  <div class="form-group">
          <label >Reward Type:<span class="required" v-if="!id">*</span></label>
          <br><small class="required">error</small>
          <select  class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Reward Type</option>
            <option value="Service Center">Bonus</option>
            <option value="Operation Center">Allowance</option>
          </select>
  </div>

  <div class="form-group">
          <label >Reward Name:<span v-if="!id" class="required">*</span></label>
          <br><small class="required">error</small>
          <input type="text" class="form-control"  placeholder="Reward name" />
  </div>

  <div class="form-group">
          <label >Reward Name:</label>
          <br><small class="required">error</small>
          <textarea class="form-control" rows="3"  placeholder="Reward Description" ></textarea>
  </div>

</form>
                </div>
                <div class="card-footer">
  <div class="page-header flex-wrap">
<h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
</h3>
<div class="d-flex">
  <button type="button" @click="rewardType=false"  class="btn btn-sm ml-3 btn-defualt"> Close </button>
  <input type="submit"  value="Add"  class="btn btn-sm ml-3 btn-success">
</div>
  </div>
</div>
              </div>
            </GDialog>


             <!-- add reward -->

             <GDialog v-model="addReward" persistent  max-width="500">
              <div class="card">
                <div class="card-title text-center p-2">
                  <h4>Add Reward</h4>
                </div>
                <div class="card-content container">
<form class="forms-sample" action="">

  <div class="form-group">
          <label >Reward Type:<span class="required" v-if="!id">*</span></label>
          <br><small class="required">error</small>
          <select  class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Reward Type</option>
            <option value="Service Center">Bonus</option>
            <option value="Operation Center">Allowance</option>
          </select>
  </div>

  <div class="form-group">
          <label >Reward Name:<span v-if="!id" class="required">*</span></label>
          <br><small class="required">error</small>
          <select  class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Reward Name</option>
            <option value="Service Center">Bonus</option>
            <option value="Operation Center">Allowance</option>
          </select>
  </div>

  <div class="form-group">
          <label >Beneficial:<span v-if="!id" class="required">*</span></label>
          <br><small class="required">error</small>
          <select  class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Beneficial</option>
            <option value="Service Center">John Dzikunu</option>
            <option value="Operation Center">All Service center</option>
            <option value="Operation Center">All Operation center</option>
          </select>
  </div>

</form>
                </div>
                <div class="card-footer">
  <div class="page-header flex-wrap">
<h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
</h3>
<div class="d-flex">
  <button type="button" @click="addReward=false"  class="btn btn-sm ml-3 btn-defualt"> Close </button>
  <input type="submit"  value="Add"  class="btn btn-sm ml-3 btn-success">
</div>
  </div>
</div>
              </div>
            </GDialog>



            <GDialog v-model="deleteed"  max-width="500">
              <div class="card container p-3">
                <h3 class="card-title">DELETE ALERT</h3>
                <div class="card-content">Are you sure you want to delete</div>
              </div>
              <div class="card-footer">
                <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
              </h3>
              <div class="d-flex">
                <button type="button" @click="deleteed = false" class="btn btn-sm ml-3 btn-defualt"> Discard </button>
                <input type="button"  value=" Delete"   class="btn btn-sm ml-3 btn-success">
              </div>
            </div>
              </div>
            </GDialog>


</template>

<script setup>
import {formatter} from '../assets/api'
import {ref} from 'vue';
import 'gitart-vue-dialog/dist/style.css'
import { GDialog } from 'gitart-vue-dialog'
import { createToaster } from "@meforma/vue-toaster";
import { VueCookieNext } from 'vue-cookie-next'
const toaster = createToaster({position:"top-left",});
const user = VueCookieNext.getCookie("user");
document.title = "ERP Adim PayRoll Generation" 


let employee = ref([]);
let page = 0;
let total = 0;
let rewardType = ref(false)
let generating = ref(false)
let addReward = ref(false)
let deleteed = ref(false)
let view = ref(false);

function next() {
  page++;
  getEmployees();
}

function prev() {
  if(page>0){
    page--;
    getEmployees();
  }
}


function getEmployees() {
  fetch(`http://localhost:8080/payroll?month=202211&page=${page}`)
  .then((response) => response.json())
  .then((data) => {
    if(data.data.payroll && data.data.payroll.length>0){
      employee.value  = data.data.payroll
    }
    total = data.data.total;
  });
}


function generatePayRoll() {
  generating.value = true;
  fetch('http://localhost:8080/payroll/generate',{
    headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': 'Bearer '+user.token
        },
  })
  .then((response) => response.json())
  .then((data) => {
    generating.value = false;
    toaster.show(data.data);
    setTimeout(() => {
      getEmployees();  
    }, 1000);
  });
}

getEmployees();

</script>

<style scoped>

#wrapper{
    position:relative;
    /*background:#333;*/
    height:100%;
}

.profile-main-loader{
    left: 50% !important;
    margin-left:-100px;
    position: fixed !important;
    top: 50% !important;
    margin-top: -100px;
    width: 45px;
    z-index: 9000 !important;
}

.profile-main-loader .loader {
  position: relative;
  margin: 0px auto;
  width: 100px;
  height:100px;
}
.profile-main-loader .loader:before {
  content: '';
  display: block;
  padding-top: 100%;
}

.circular-loader {
  -webkit-animation: rotate 2s linear infinite;
          animation: rotate 2s linear infinite;
  height: 100%;
  -webkit-transform-origin: center center;
      -ms-transform-origin: center center;
          transform-origin: center center;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
  margin: auto;
}

.loader-path {
  stroke-dasharray: 150,200;
  stroke-dashoffset: -10;
  -webkit-animation: dash 1.5s ease-in-out infinite, color 6s ease-in-out infinite;
          animation: dash 1.5s ease-in-out infinite, color 6s ease-in-out infinite;
  stroke-linecap: round;
}

@-webkit-keyframes rotate {
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}

@keyframes rotate {
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}
@-webkit-keyframes dash {
  0% {
    stroke-dasharray: 1,200;
    stroke-dashoffset: 0;
  }
  50% {
    stroke-dasharray: 89,200;
    stroke-dashoffset: -35;
  }
  100% {
    stroke-dasharray: 89,200;
    stroke-dashoffset: -124;
  }
}
@keyframes dash {
  0% {
    stroke-dasharray: 1,200;
    stroke-dashoffset: 0;
  }
  50% {
    stroke-dasharray: 89,200;
    stroke-dashoffset: -35;
  }
  100% {
    stroke-dasharray: 89,200;
    stroke-dashoffset: -124;
  }
}
@-webkit-keyframes color {
  0% {
    stroke: #e97b3b;
  }
  40% {
    stroke: #e97b3b;
  }
  66% {
    stroke: #e97b3b;
  }
  80%, 90% {
    stroke: #e97b3b;
  }
}
@keyframes color {
  0% {
    stroke: #e97b3b;
  }
  40% {
    stroke: #e97b3b;
  }
  66% {
    stroke: #e97b3b;
  }
  80%, 90% {
    stroke: #e97b3b;
  }
}

.container{
  padding: 0.75rem 1.25rem;
}

.page-header {
  margin: 0;
}
</style>