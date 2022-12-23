<template>       
    <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Your Enterprise Resource Planning Center.</span>
              </h3>
              <div class="d-flex">
                <a href="#" id="openModal"><button type="button" @click="ShowAddEmployeeModel()" class="btn btn-sm ml-3 btn-success"> Add Employee </button></a>
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
                            <th>Started</th>
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
                                  <small> {{ employ.gender }}</small>
                                </div>
                              </div>
                            </td>
                            <td>{{ employ.department }}</td>
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
                                <a href="#" id="openModal"><button type="button" @click="[edit(),employee.id=employ.user_id]" class="btn btn-sm ml-3 btn-success"> Edit</button></a>
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
                    <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">{{ employee.length }} <i><small>0f</small></i> {{ employee.length }}</span>
                    </h3>
                    <div class="d-flex">
                      <button class="btn btn-outline-default " @click="prev()"> 
                        <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M20,11V13H8L13.5,18.5L12.08,19.92L4.16,12L12.08,4.08L13.5,5.5L8,11H20Z" />
                    </svg> 
                    Prev.
                  </button>
      
              <button class="btn btn-outline-default" @click="next()"> 
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

            <Teleport v-if="showAddModel" to="#modal">
                <div class="modalView">
                    <AddEmployee :id="employee.id"  @close="ShowAddEmployeeModel" @submit="submited"/>
                </div>
            </Teleport>

            <GDialog v-model="dialogState" max-width="500">
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
import {postData,getData,timeSince,deleteData} from '../assets/api'
import {ref} from 'vue';
import 'gitart-vue-dialog/dist/style.css'
import { GDialog } from 'gitart-vue-dialog'
import { createToaster } from "@meforma/vue-toaster";

let showAddModel = false;
const toaster = createToaster({position:"top-left",});
function ShowAddEmployeeModel() {
    showAddModel = !showAddModel;
    edditEmployee.value = false;
}
function edit() {
  showAddModel = !showAddModel;
}
function submited(value) {
  ShowAddEmployeeModel();
 document.getElementById("openModal").click()
 //bad solution
 getEmployees();
 edditEmployee.value = false;
}


let employee = ref([]);
let page = 0;
let dialogState = ref(false)
let edditEmployee = ref(false)

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
  getData(`employees?page=${page}`,"1|d7IoBijt1q5Or5rWnf6UliO6lfFEjcNmumdJ4HXW").then(value=>{
employee.value = value.message;
if(value.message.length < 10){
  page = -1;
}
});
}

getEmployees();

function deleteEmployee(id) {
if(true){
deleteData(`employees/`+id,"1|d7IoBijt1q5Or5rWnf6UliO6lfFEjcNmumdJ4HXW").then(value=>{
  getEmployees();
  toaster.show(value.message);
})
}
}
</script>

<style scoped>
.modalView{
background-color: rgba(0, 0, 0, 0.25);
width: 100vw;
height: 100vh;
overflow-y: scroll;
position: absolute;
z-index: 20000;
padding: 3% 5%;
}


.page-header{
    margin: 0;
}
</style>