<template>

<form class="modal-content p-2" @submit.prevent="submitData()">
    <div class="row">

<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title"> <span v-if="id">Edit</span> Employee Details</h4>
      <p class="card-description">Bio data</p>
      <div class="forms-sample">
        <div class="form-group">
          
          <label >First Name:<span class="required" v-if="!id">*</span></label>
         <br><small v-if="error.first_name" class="required">{{ error.first_name }}</small>
          <input v-model="inputData.first_name" @input="error.first_name = null" type="text" class="form-control" :required="!id" placeholder="First Name" />
        </div>
        <div class="form-group">
          <label>Last Name:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.last_name" class="required">{{ error.last_name }}</small>
          <input v-model="inputData.last_name" @input="error.last_name = null" type="text" class="form-control" :required="!id"  placeholder="Last Name" />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Other Name:</label>
          <br><small v-if="error.other_name" class="required">{{ error.other_name }}</small>
          <input v-model="inputData.other_names" @input="error.other_names = null" type="text" class="form-control"  placeholder="Other Name" />
        </div>

        <div class="form-group">
          <label >Gender:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.gender" class="required">{{ error.gender }}</small>
          <select v-model="inputData.gender" @input="error.gender = null" class="form-control form-control-lg" :required="!id">
            <option>Select -- Gender</option>
            <option>Male</option>
            <option>Female</option>
            <option>Others</option>
          </select>
        </div>

        <div class="form-group">
          <label for="exampleInputPassword1">Phone Number:</label>
          <br><small v-if="error.tell" class="required">{{ error.tell }}</small>
          <input v-model="inputData.tell" @input="error.tell = null" type="text" class="form-control"  placeholder="Other Name" />
        </div>
      </div>
    </div>
  </div>
</div>

<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <!-- <h4 class="card-title">Other Details</h4>
      <p class="card-description">Identity data</p> -->
      <div class="forms-sample">
        <div class="form-group">
          <label >Email:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.email"  class="required">{{ error.email }}</small>
          <input type="email" :disabled="id"  v-model="inputData.email" @focusout="checkEmail()" @input="error.email = null" class="form-control" :required="!id" placeholder="Email" />
        </div>
        <div class="form-group">
          <label >Department:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.department" class="required">{{ error.department }}</small>
          <select v-model="inputData.department" @input="error.department = null" class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Department</option>
            <option value="Service Center">Service Center</option>
            <option value="Operation Center">Operation Center</option>
            <option value="Others">Others</option>
          </select>
        </div>
        <div class="form-group">
          <label >Position:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.position" class="required">{{ error.position }}</small>
          <select v-model="inputData.position" @input="error.position = null" class="form-control form-control-lg" :required="!id">
            <option value="">Select -- Position</option>
            <option value="Service Center">Junior Associate</option>
            <option value="Operation Center">Associate</option>
            <option value="Others">Senior Associate</option>
          </select>
        </div>
        <div class="form-group">
          <label >Monthly Salary:<span v-if="!id" class="required">*</span></label>
          <br><small v-if="error.salary" class="required">{{ error.salary }}</small>
          <input type="number" :required="!id" v-model="inputData.salary" @input="error.salary = null" class="form-control"  placeholder="Monthly Salary" />
        </div>
        <div class="form-group">
          <label >Hire Date:<span class="required" v-if="!id">*</span></label>
          <br><small v-if="error.hire_date" class="required">{{ error.hire_date }}</small>
          <input type="date" v-model="inputData.hire_date" @input="error.hire_date = null" class="form-control"  placeholder="Hire Date" />
        </div>        
        <div class="form-group">
          <label >Contant Assistant</label>
          <br><small v-if="error.assistant" class="required">{{ error.assistant }}</small>
          <select v-model="inputData.assistant" @input="error.assistant = null" class="form-control form-control-lg">
            <option value="">Select ----Assistant</option>
            <option v-for="a of canAssist" :value="a.user_id">{{ a.name }}</option>
          </select>
        </div>
       
      </div>
    </div>
  </div>
</div>


</div>
<div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
              </h3>
              <div class="d-flex">
                <button type="button" @click="$emit('close')" class="btn btn-sm ml-3 btn-defualt"> Discard </button>
                <input type="submit" value=" Save"  class="btn btn-sm ml-3 btn-success">
              </div>
            </div>
  </form>


   
</template>

<script>
import {postData,getData,patchData} from '../assets/api'
const token = "1|yx38Kzy7iaK9knwC2qkQsec3JFwaJjqKqtjPYD8l";


export default {
  name:"AddEmployee",
  props:["id"],
  methods: {
    submit() {
      this.$emit('someEvent')
    },
    submitData(){
      if(this.id){
        patchData(`employees/${this.id}`,this.inputData,token).then(value=>{
        if(value.errors){
          this.error = value.errors;
        };
        if(value){
        this.$emit("submit",value);
        this.inputData = {role:"employee"};
        this.error ={};
        this.canAssist = {};
        this.user_id ="";
      }
      });
    }else{
        postData("register",this.inputData,token).then(value=>{
        if(value.errors){
          this.error = value.errors;
        };
        if(value){
        this.$emit("submit",value);
        this.inputData = {role:"employee"};
        this.error ={};
        this.canAssist = {};
        this.user_id ="";
      }
      });
    }
  },
    checkEmail(){
      if(!this.id){
        postData("validate",this.inputData,"").then(value=>{
        if(value.errors || value.exception)this.error = value.errors;
      });
      }
    },
    getDataEmployees(){
      getData(`employees/${this.id}`,token).then(value=>{
        if(value.length>0){
          this.inputData = {...value[0]};
        }
       
    });
},
getDataAssistant(){
  getData("assistant",token).then(value=>{
if(!value.errors){
  this.canAssist = value
}
});
}
},

created(){
  if(this.user_id !== this.id){
    console.log(this.user_id);
    this.user_id = this.id
    this.getDataAssistant();
    if(this.id){
      this.getDataEmployees();
    }
  }
 
},
updated() {
  if(this.user_id !== this.id){
    console.log(this.user_id);
    this.user_id = this.id
    this.getDataAssistant();
    if(this.id){
      this.getDataEmployees();
    }
  }
  },
  unmounted() {
    this.inputData = {role:"employee"};
    this.error ={};
    this.canAssist = {};
    this.user_id ="";
  },
  data(){
    return {
      inputData:{role:"employee"},
      error:{},
      canAssist:{},
      user_id:""
    }
  }
}


</script>

<style scoped>
.btn-defualt{
    border: solid rgba(100, 89, 89, 0.671) 2px;
}

.page-header{
  margin: 0px;
}
</style>