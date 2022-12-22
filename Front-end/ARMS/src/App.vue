<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div class="container-scroller">

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
             
             <ul class="mt-4 pl-0">
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
           <i class="mdi mdi-earth"></i> English </a>
         <div class="dropdown-menu navbar-dropdown" aria-labelledby="languageDropdown">
           <a class="dropdown-item" href="#"> French </a>
           <a class="dropdown-item" href="#"> Germany </a>
         </div>
       </li>
       <li class="nav-item nav-profile dropdown border-0">
         <a class="nav-link" href="#">
           <img class="nav-profile-img mr-2" alt="" src="assets/images/faces/face1.jpg" />
           <span class="profile-name">John Dzikunu</span>
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
   <!-- main-panel ends -->
 </div>
 <!-- page-body-wrapper ends -->
</div>
</template>