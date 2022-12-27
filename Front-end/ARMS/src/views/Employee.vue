<template>
     <div class="d-flex align-items-center">
        <div class="flex-colum">
          <input type="file" id="file" @change="uploadImage()" accept="image/png, image/gif, image/jpeg">
            <img class="img m-1" :src="image?image:userData.profile?userData.profile:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII='" alt="image" />
          <label  class="btn btn-defualt" for="file">
            Update 
          </label>
            
        </div>                        
        <div class="table-user-name ml-3">
                                  <h3 class="mb-0 font-weight-medium"> {{ userData.first_name }} {{ userData.other_names }}  {{ userData.last_name }}</h3>
                                  <small><b>{{ userData.position }}</b></small><br>
                                  <small> {{ userData.email }}</small><br>
                                  <small> {{ userData.tell }}</small><br>
                                  <small> {{ userData.department }}</small>
                                </div>
   </div>


   <div class="row mt-5">
<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Employee Details</h4>
      <p class="card-description">Bio data</p>
      <form class="forms-sample">
        
        <div class="form-group">
          <label for="exampleInputUsername1">First Name:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" v-model="userData.first_name" placeholder="First Name" aria-label="First Name" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary"  @click="updateEmployee({'first_name':userData.first_name})" type="button"> Update </button>
          </div>
         </div>
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Last Name:<span  class="required">*</span></label>
          <div class="input-group">
            <input type="text" v-model="userData.last_name" class="form-control" placeholder="Last Name" aria-label="Last Name" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="updateEmployee({'last_names':userData.last_name})" type="button"> Update </button>
          </div>
         </div>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Other Name:</label>
          <div class="input-group">
            <input type="text" class="form-control" v-model="userData.other_names"  placeholder="Other Name" aria-label="Other Name" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="updateEmployee({'other_names':userData.other_names})" type="button"> Update </button>
          </div>
         </div>
        </div>

        <div class="form-group">
          <label for="exampleFormControlSelect1">Gender:<span class="required">*</span></label>
          <div class="input-group">
            <select class="form-control form-control-lg" v-model="userData.gender"  aria-label="gender" aria-describedby="basic-addon2" >
            <option>Select -- Gender</option>
            <option>Male</option>
            <option>Female</option>
            <option>Others</option>
          </select>
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="updateEmployee({'gender':userData.gender})" type="button"> Update </button>
          </div>
         </div>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Other Details</h4>
      <p class="card-description">Identity data</p>
      <form class="forms-sample">
        <div class="form-group">
          <label for="exampleInputUsername1">Email:<span class="required">*</span></label>
          <input type="email" class="form-control" v-model="userData.email" disabled placeholder="Email" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Department:<span class="required">*</span></label>
          <input type="text" class="form-control" v-model="userData.department" placeholder="Department" disabled />
            
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Monthly Salary:<span class="required">*</span></label>
          <div class="input-group">
            <select v-model="userData.salary" @input="error.position = null" class="form-control form-control-lg" placeholder="Monthly Salary" aria-label="Monthly Salary">
            <option :value="userData.salary">{{ formatter.format(userData.salary) }}</option>
          </select>
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="dialogState = true" type="button"> View Detail </button>
          </div>
         </div>
        </div>
        <div class="form-group">
          <label >Hire Date:<span class="required">*</span></label>
          <input type="text" class="form-control" v-model="userData.hire_date" disabled  placeholder="Hire Date" />
        </div>
       
      </form>
    </div>
  </div>
</div>
</div>

<div class="page-header flex-wrap">
  <p class="required">
  <i class="mdi mdi-plus"></i> Bank Information
</p>
              <div class="d-flex">
                <input type="submit" value=" Save" @click="updateBankDetail()"  class="btn btn-sm ml-3 btn-success">
              </div>
            </div>


<div class="row mt-4">
<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <form class="forms-sample">
        <div class="form-group">
          <label for="exampleInputUsername1">Bank Name:<span class="required">*</span></label>
          <input type="text" class="form-control" v-model="bankDetail.bank_name" placeholder="Bank Name" aria-label="Bank Name" aria-describedby="basic-addon2" />
            
        </div>
        <div class="form-group">
          <label for="exampleInputUsername1">Account Number:<span class="required">*</span></label>
          <input type="text" class="form-control" v-model="bankDetail.account_number" placeholder="Account Number" aria-label="Bank Account Number" aria-describedby="basic-addon2" />
          
        </div>
      </form>
    </div>
  </div>
</div>

<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">

      <div class="form-group">
          <label for="exampleInputUsername1">Account Name<span class="required">*</span></label>
          <input type="text" class="form-control" v-model="bankDetail.account_name" placeholder="Bank Branch" aria-label="Bank Branch" aria-describedby="basic-addon2" />
          
        </div>


        <div class="form-group">
          <label for="exampleInputUsername1">Phone Number:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" v-model="userData.tell"  placeholder="Phone Number" aria-label="Phone Number" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" @click="updateEmployee({'tell':userData.tell})" type="button"> Update </button>
          </div>
         </div>
           </div>
    </div>
  </div>
</div>
</div>


<GDialog v-model="dialogState" :fullscreen="true"  max-width="75%">
     
      <div>
         <Payslip :user="userData" @close="dialogState = false" />
      </div>
</GDialog>

</template>

<script setup>

import { imageUpload,getData,patchData,formatter } from "../assets/api";
import {ref} from 'vue'
import { createToaster } from "@meforma/vue-toaster";
import 'gitart-vue-dialog/dist/style.css';
import { GDialog } from 'gitart-vue-dialog';
import Payslip  from '../components/Payslip.vue';
import { VueCookieNext } from 'vue-cookie-next';
document.title = "ERP Adim Employee";

const toaster = createToaster({position:"top-left",});

var image = ref(null);
var userData = ref({});
var bankDetail = ref({});
var update = ref(false);
var dialogState = ref(false)
const user = VueCookieNext.getCookie("user");
userData.value   = {...user};

function uploadImage() {
  const inputData = document.querySelector("#file")
  var data = new FormData()
data.append('profile', inputData.files[0])
console.log(user.token);
imageUpload("upload",data, user.token).then(value=>{
  if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}else{
  image.value = value.message;
  user.profile = value.message;
  VueCookieNext.setCookie("user",user);
}
  
});
}

function updateEmployee(data) {
  patchData(`employees/${userData.value.user_id}`,data,user.token).then(value=>{
        if(value.errors){
          this.error = value.errors;
        };
        if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
        if(value.message){
    toaster.show(value.message);
  }
      });
}

function updateBankDetail() {
  if(update){
    patchData(`bank-detail`,bankDetail.value,user.token).then(value=>{
        if(value.errors){
          this.error = value.errors;
        };
        if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
      });

  }else{
    postData(`bank-detail`,bankDetail.value,user.token).then(value=>{
      bankDetail.value = {...value};

      if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
    });
  }
}

function getInfo() {
  getData(`employees/${userData.value.user_id}`,user.token).then(value=>{
    if(value.length>0){
      userData.value = {...value[0]};
    }

    if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
  });
}

function getBankDetail() {
  getData("bank-detail",user.token).then(value=>{
    if(value.length > 0){
      update.value = true
      bankDetail.value = {...value[0]};
    }
    if(value.message == "Unauthenticated."){
  VueCookieNext.removeCookie("user");
  window.location.replace("/login");
}
  });
}



getInfo();
getBankDetail();

</script>

<style lang="css">
.btn-defualt{
    border: solid rgba(100, 89, 89, 0.671) 2px;
}

.flex-colum{
    display: flex;
    flex-direction: column;
}
#file{
  display: none;
}
.img{
width: 200px;
height: 200px;

}

</style>