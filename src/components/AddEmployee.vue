<template>

<div class="modal-content p-5">
    <div class="row">

<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Employee Details</h4>
      <p class="card-description">Bio data</p>
      <form class="forms-sample">
        <div class="form-group">
          <label for="exampleInputUsername1">First Name:<span class="required">*</span></label>
          <input type="text" class="form-control" required placeholder="First Name" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Last Name:<span class="required">*</span></label>
          <input type="text" class="form-control" required  placeholder="Last Name" />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Other Name:</label>
          <input type="text" class="form-control"  placeholder="Other Name" />
        </div>

        <div class="form-group">
          <label for="exampleFormControlSelect1">Gender:<span class="required">*</span></label>
          <select class="form-control form-control-lg" required>
            <option>Select -- Gender</option>
            <option>Male</option>
            <option>Female</option>
            <option>Others</option>
          </select>
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
          <input type="email" class="form-control" required placeholder="Email" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Department:<span class="required">*</span></label>
          <input type="text" class="form-control" placeholder="Department" />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Monthly Salary:<span class="required">*</span></label>
          <input type="text" class="form-control"  placeholder="Monthly Salary" />
        </div>
        <div class="form-group">
          <label >Hire Date:<span class="required">*</span></label>
          <input type="text" class="form-control"  placeholder="Hire Date" />
        </div>
       
      </form>
    </div>
  </div>
</div>


</div>
<div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
              </h3>
              <div class="d-flex">
                <a href="#"><button type="button" onclick="$emit('close')" class="btn btn-sm ml-3 btn-defualt"> Discard </button></a>
                <a href="#"><button type="button" class="btn btn-sm ml-3 btn-success">  Save  </button></a>
              </div>
            </div>
  </div>


   
</template>

<script setup  lang="ts">


</script>

<style scoped>
.btn-defualt{
    border: solid rgba(100, 89, 89, 0.671) 2px;
}
</style>