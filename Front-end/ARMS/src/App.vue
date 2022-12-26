<script>
import { postData } from "./assets/api";
export default {
  name:"App",
  components:{
    RouterLink,RouterView
  },
  methods:{

    data() {
      return {
        user:{},
        lang: "",
      }
    },

    logout(){
      postData("logout",{},this.user.token).then(value=>{
        this.$cookie.removeCookie("user");
        window.location.replace("/login");
          });
    }
  },
  beforeCreate() {
     this.user =   this.$cookie.getCookie("user")
     this.lang =   this.$cookie.getCookie("lang")
    if(window.location.pathname == '/login'){
      if(this.user != null) window.location.replace("/");
    }else{
      if(this.user == null) window.location.replace("/login");
    }
},
}
import { RouterLink, RouterView } from 'vue-router'



</script>

<template>
  <div v-if="$route.name != 'login'" class="container-scroller">

<nav class="sidebar sidebar-offcanvas" id="sidebar">
 <div class="text-center sidebar-brand-wrapper d-flex align-items-center">
   <a class="sidebar-brand brand-logo" href="index.html"><img src="assets/images/logo.gif" alt="ERP" /></a>
   <a class="sidebar-brand brand-logo-mini pl-4 pt-3" href="index.html"><h4>ERP</h4></a>
 </div>
 <ul class="nav">
   <div class="nav-space">
     <div>
       <li class="nav-item pt-3">
         <a class="nav-link .nav-tabs" href="/">
           <i class="mdi mdi-home menu-icon"></i>
           <span class="menu-title">Dashboard</span>
         </a>
       </li>

       <li class="nav-item ">
         <a class="nav-link" href="#">
           <i class="mdi mdi-square-inc-cash menu-icon"></i>
           <span class="menu-title">Finance</span>
         </a>
       </li>

       <li class="nav-item ">
         <RouterLink class="nav-link" to="/employee">
           <i class="mdi mdi-account-multiple menu-icon"></i>
           <span class="menu-title">Employee</span>
         </RouterLink>
       </li>

       <li class="nav-item ">
         <RouterLink class="nav-link" to="/management">
           <i class="mdi mdi-fan menu-icon"></i>
           <span class="menu-title">Management</span>
         </RouterLink>
       </li>
       

       <li class="nav-item pt-4">
         <span >
           <span class="menu-title">Docs</span>
         </span>
       </li>
       <li class="nav-item">
         <a class="nav-link" href="?">
           <i class="mdi mdi-file-document-box menu-icon"></i>
           <span class="menu-title">Documentation</span>
         </a>
       </li>
     </div>

     <div>
       <li class="nav-item sidebar-actions">
         <div class="nav-link">
           <div class="mt-4">
             
             <ul @click="logout()" class="mt-4 pl-0">
               <li>Sign Out</li>
             </ul>
           </div>
         </div>
       </li>
     </div>
   </div>
 </ul>
</nav>

<div class="container-fluid page-body-wrapper">
 
 <nav class="navbar col-lg-12 col-12 p-lg-0 fixed-top d-flex flex-row">
   <div class="navbar-menu-wrapper d-flex align-items-stretch justify-content-between">
     <a class="navbar-brand brand-logo-mini align-self-center d-lg-none" href="index.html"><h4>ERP</h4></a>
     <button class="navbar-toggler navbar-toggler align-self-center mr-2" type="button" data-toggle="minimize">
       <i class="mdi mdi-menu"></i>
     </button>
    
     <ul class="navbar-nav navbar-nav-right ml-lg-auto">
       <li class="nav-item dropdown d-none d-xl-flex border-0">
         <a class="nav-link dropdown-toggle" id="languageDropdown" href="#" data-toggle="dropdown">
           <i class="mdi mdi-earth"></i> {{ lang=="en"?"English":"Germany"}} </a>
         <div class="dropdown-menu navbar-dropdown" aria-labelledby="languageDropdown">
           <a class="dropdown-item" href="#"> English </a>
           <a class="dropdown-item" href="#"> Germany </a>
         </div>
       </li>
       <li class="nav-item nav-profile dropdown border-0">
         <a class="nav-link" href="#">
           <img class="nav-profile-img mr-2" :alt="user.name" :src="user.profile?user.profile:'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII='" />
           <span class="profile-name">{{ user.name }}</span>
         </a>
       </li>
     </ul>
     <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
       <span class="mdi mdi-menu"></span>
     </button>
   </div>
 </nav>
 
 <div class="main-panel">
   <div class="content-wrapper pb-0">
    <RouterView/>
       <footer class="footer">
         <div class="d-sm-flex justify-content-center justify-content-sm-between">
           <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Amalitech Service Center</span>
           <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Enterprise Resource Planning (ERP)</span>
         </div>
       </footer>
     </div>
   </div>
 </div>
</div>
<RouterView v-if="$route.name == 'login'"/>
</template>