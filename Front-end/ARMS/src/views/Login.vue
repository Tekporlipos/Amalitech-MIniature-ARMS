<template>
    <div class="login-page">
  <div class="form">
    <p class="alert alert-danger" v-if="$route.name == 'changePassword'&&error.message"> {{ error.message }}</p>
    <form v-if="$route.name == 'changePassword'"  @submit.prevent="changePassword()" class="register-form">
      <input v-model="data.old_password" type="password" placeholder="Old password"/>
      <input v-model="data.password" type="password" placeholder="New password"/>
      <input v-model="data.password_confirmation" type="password" placeholder="New password"/>
      <button>Change Password</button>
      <p class="message">Use password with mixed characters</p>
    </form>
    <form v-if="$route.name == 'login'" @submit.prevent="login()" class="login-form">
        <h3 v-if="!reset">Login!</h3>
        <h3 v-if="reset">Reset password!</h3>
        <p class="alert alert-danger" v-if="$route.name == 'login'&&error.message"> {{ error.message }}</p>
      <input v-model="data.email" v-if="!reseted" @input="error.message = null" type="email" required placeholder="Email"/>
      <input v-model="data.password" v-if="!reset" type="password" required placeholder="password"/>
      <button type="submit">{{!reset?"login":"Reset"}}</button>
      <p v-if="reset" class="message">Login me in instead  <a @click="[reset = false,reseted=false,error={}]" class="click">Login</a> </p>
      <p v-if="!reset" class="message">Forgotten password? <a @click="[reset = true,,error={}]" class="click">Reset password</a></p>
    </form>
  </div>
</div>
</template>

<script>
import { postData,patchData } from "../assets/api";
export default {
    name:"Login",
    data() {
        return {
            reset:false,
            reseted:false,
            data:{},
            error:{},
        }
    },
    methods:{
        login(){
            this.error = {};
            if(this.reset){
                postData("reset-password",this.data).then(value=>{
                    this.error = value;
                });
            }else{
                postData("login",this.data).then(value=>{
                    if(value.user){
                        this.$cookie.setCookie("user", {...value.user,"email":this.data.email,"token":value.token});
                       
                        if(value.user.email_verified_at){
                          window.location.replace("/");
                        }else{
                          window.location.replace("/change-password");
                        }
                    }else{
                        this.error = value;
                    }
                });
            }
        },
        changePassword(){
          patchData("change-password",this.data,this.$cookie.getCookie("user").token).then(value=>{
                 
                    this.error = value;
                });
        }
    },

    mounted() {
        document.title = "ERP Login" 
    },
}
</script>

<style scoped>
.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}

.click{
    cursor: pointer;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #f96868;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #f96868;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #f96868;
  text-decoration: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
</style>