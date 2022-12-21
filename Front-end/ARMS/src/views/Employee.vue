<template>
     <div class="d-flex align-items-center">
        <div class="flex-colum">
            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII=" alt="image" />
            <button class="btn btn-defualt">Update</button>
        </div>                        
        <div class="table-user-name ml-3">
                                  <h3 class="mb-0 font-weight-medium"> John Dzikunu </h3>
                                  <small><b>Junior Associate</b></small><br>
                                  <small> dzikunujohn36@gmail.com</small><br>
                                  <small> 233543715182</small><br>
                                  <small> SCT-123-345</small>
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
          <input type="text"  disabled class="form-control"  placeholder="First Name" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Last Name:<span  class="required">*</span></label>
          <input type="text" disabled class="form-control"   placeholder="Last Name" />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Other Name:</label>
          <input type="text" disabled class="form-control"  placeholder="Other Name" />
        </div>

        <div class="form-group">
          <label for="exampleFormControlSelect1">Gender:<span class="required">*</span></label>
          <select class="form-control form-control-lg" disabled >
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
          <input type="email" class="form-control" disabled placeholder="Email" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Department:<span class="required">*</span></label>
          <input type="text" class="form-control" disabled placeholder="Department" />
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Monthly Salary:<span class="required">*</span></label>
          <input type="text" class="form-control" disabled placeholder="Monthly Salary" />
        </div>
        <div class="form-group">
          <label >Hire Date:<span class="required">*</span></label>
          <input type="text" class="form-control" disabled placeholder="Hire Date" />
        </div>
       
      </form>
    </div>
  </div>
</div>
</div>

<p class="required">
  <i class="mdi mdi-plus"></i> Bank Information
</p>

<div class="row mt-4">
<div class="col-md-6 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <form class="forms-sample">
        <div class="form-group">
          <label for="exampleInputUsername1">Bank Account Name:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Bank Account Name" aria-label="Bank Account Name" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" type="button"> Update </button>
          </div>
         </div>
        </div>
        <div class="form-group">
          <label for="exampleInputUsername1">Bank Account Number:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Bank Account Number" aria-label="Bank Account Number" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" type="button"> Update </button>
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

      <div class="form-group">
          <label for="exampleInputUsername1">Bank Branch:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Bank Branch" aria-label="Bank Branch" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" type="button"> Update </button>
          </div>
         </div>
        </div>


        <div class="form-group">
          <label for="exampleInputUsername1">Phone Number:<span class="required">*</span></label>
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Phone Number" aria-label="Phone Number" aria-describedby="basic-addon2" />
            <div class="input-group-append">
            <button class="btn btn-sm btn-primary" type="button"> Update </button>
          </div>
         </div>
        </div>
    </div>
  </div>
</div>
</div>

</template>

<script setup lang="ts">

</script>

<style lang="css" scoped>
.btn-defualt{
    border: solid rgba(100, 89, 89, 0.671) 2px;
}

.flex-colum{
    display: flex;
    flex-direction: column;
}

</style>