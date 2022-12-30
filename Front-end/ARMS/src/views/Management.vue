<template>     


<div class="page-header flex-wrap mb-2">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
              </h3>
              <div class="d-flex">
                <div class="form-group">
          <div class="input-group">
            <input type="text" class="form-control" v-model="search"   placeholder="Search employee" aria-label="Phone Number" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="searchEmployees(search)"  type="button"> Search </button>
          </div>
         </div>
           </div>
              </div>
            </div>


    <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Your Enterprise Resource Planning Center.</span>
              </h3>
              <div class="d-flex">
               <button type="button" @click="ShowAddEmployeeModel()" class="btn btn-sm ml-3 btn-success"> Add Employee </button>
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
                            <th>Position</th>
                            <th>Salary</th>
                            <th>Start</th>
                            <th>Actions</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="employ of employee">
                            <td>
                              <div class="d-flex align-items-center">
                                <img :src="employ.profile?employ.profile:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII='" class="img" alt="image" />
                                <div class="table-user-name ml-3">
                                  <p class="mb-0 font-weight-medium"> {{ employ.first_name }} {{ employ.other_names?employ.other_names:"" }} {{ employ.last_name }} </p>
                                  <small> {{ employ.email }}</small><br>
                                  <small> {{ employ.tell }}</small><br>
                                  <small> {{ employ.gender }}</small>
                                </div>
                              </div>
                            </td>
                            <td>{{ employ.department }}</td>
                            <td>{{ employ.position }}</td>
                            <td>{{ formatter.format(employ.salary) }}</td>
                            <td>
                              <div class="badge badge-inverse-success"> {{ timeSince(employ.hire_date) }} </div>
                            </td>
                            <td>
                             
                          <div class="dropdown">
                              <svg class="dropdown-toggle" type="button" id="actions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:24px;height:24px"  viewBox="0 0 24 24">
                                <path fill="currentColor" d="M12,16A2,2 0 0,1 14,18A2,2 0 0,1 12,20A2,2 0 0,1 10,18A2,2 0 0,1 12,16M12,10A2,2 0 0,1 14,12A2,2 0 0,1 12,14A2,2 0 0,1 10,12A2,2 0 0,1 12,10M12,4A2,2 0 0,1 14,6A2,2 0 0,1 12,8A2,2 0 0,1 10,6A2,2 0 0,1 12,4Z" />
                            </svg>
                            <div class="dropdown-menu" aria-labelledby="actions">
                  
                              <div class="dropdown-item" href="#">
                                <button type="button" @click="edit(employ.user_id)" class="btn btn-sm ml-3 btn-success"> Edit</button>
                                <button @click="[dialogState = true,employee.name = append(employ.first_name , employ.last_name),employee.id=employ.user_id]" class="btn btn-danger btn-md m-1">Delete</button>
                                
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


            <GDialog v-model="showAddModel" persistent max-width="95%">
              <AddEmployee :id="id"  @close="ShowAddEmployeeModel" @submit="submited"/>
            </GDialog>


            <GDialog v-model="dialogState"  max-width="500">
              <div class="card container p-3">
                <h3 class="card-title">DELETE ALERT</h3>
                <div class="card-content">Are you sure you want to delete {{ employee.name }}</div>
              </div>
              <div class="card-footer">
                <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
              </h3>
              <div class="d-flex">
                <button type="button" @click="dialogState = false" class="btn btn-sm ml-3 btn-defualt"> Discard </button>
                <input type="button" @click="[deleteEmployee(employee.id),dialogState = false]" value=" Delete"   class="btn btn-sm ml-3 btn-success">
              </div>
            </div>
              </div>
            </GDialog>
</template>

<script setup>
import AddEmployee from '../components/AddEmployee.vue'
import {getData,timeSince,deleteData, formatter} from '../assets/api'
import {ref} from 'vue';
import 'gitart-vue-dialog/dist/style.css'
import { GDialog } from 'gitart-vue-dialog'
import { createToaster } from "@meforma/vue-toaster";
import { VueCookieNext } from 'vue-cookie-next'
const toaster = createToaster({position:"top-left",});
let showAddModel = ref(false);
let search = ref("");
let id = ref(null);
const user = VueCookieNext.getCookie("user");
document.title = "ERP Adim Management" 

function ShowAddEmployeeModel() {
    showAddModel.value = !showAddModel.value;
}

function edit(user_id) {
  id.value= user_id;
  ShowAddEmployeeModel();
}

function submited(value) {
  showAddModel.value = false;
  if(value.message){
    toaster.show(value.message);
  }
  id.value = null;
 //bad solution
 getEmployees();
}


let employee = ref({});
let page = 0;
let total = 0;
let dialogState = ref(false)

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

function append(p1,p2) {
  return p1 +" "+p2;
}

function getEmployees() {
  getData(`employees?page=${page}`,user.token).then(value=>{
employee.value = value.message;
total = value.total;
if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
});
}


function searchEmployees(value) {
  getData(`search?sq=${value}`,user.token).then(value=>{
employee.value = value.message;
total = value.total;
if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
});
}

getEmployees();

function deleteEmployee(id) {
if(true){
deleteData(`employees/`+id,user.token).then(value=>{
  getEmployees();
  if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
  toaster.show(value.message);
})
}
}
</script>

<style scoped>

.page-header{
    margin: 0;
}
</style>