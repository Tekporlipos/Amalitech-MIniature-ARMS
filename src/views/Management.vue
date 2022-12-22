<template>       
    <div class="page-header flex-wrap">
              <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Your Enterprise Resource Planning Center.</span>
              </h3>
              <div class="d-flex">
                <a href="#"><button type="button" @click="ShowAddEmployeeModel()" class="btn btn-sm ml-3 btn-success"> Add Employee </button></a>
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
                            <th>Gender</th>
                            <th>Department</th>
                            <th>Salary</th>
                            <th>Started</th>
                            <th>Actions</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                              <div class="d-flex align-items-center">
                                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIUAAACFCAMAAABCBMsOAAAAMFBMVEXk5ueutLfDx8nn6eqrsbS0urzf4uPQ09Wxt7qnrrG4vcDKztDN0dLHy83X2ty9wsQYMyQeAAAC3klEQVR4nO2a25KDIAxAxXATFf7/bxd0u7ujtRAkyM5wnvrW0ySESzoMnU6n0+l0Op1Op9P53wDAID3+w2MKg1yc0IxprYVTXuUBBzkKztkLPnGz1PYAayZ2hPNRVvQA6fjJYfNga7V4gGLvJYKHqBUOd07GHyZVRcNcBuI7HGsFDRGRqKEBcQmflJlWAy4WxzEaC6UGzEkSXsMSWshECcYEXTBAp0oQViioj43igCSyGNJD4YMx0gQDFkwoqIKBqIotGDSVYVESXoPCAsbkZbozWQINQIaCpj4lrjY9orwELMiE+GCUXyXgsBK+MIpbDAZtwQk2eFy32CxccQuJlmDMlLdAFyfF9t4tmrPASxBUZ8ZKZQQbSRNdq40O3sZulrGzm/ISjZxyMk585SXwp19GcgZv4yaAXSVUV8QWboit3JZBpIeC8FGpiVcURIGS5WPTSHxdo355beGlMenBk7Iyf2jiBdpvax/bBnlNvDSamExsU5q3HpzNlRR2Dyumk0flidXmcZje8Qemd5tHmGQaHRBmtI9MMneRfaq7f3jm+0FKa9WOtduAuZ5K+PlWrU686iEQlgfTZlS2xrTbf4NdjebvF2pw0mJUkjIqPgez4ecVelYRq6XxCAr6IgRvTcbyIj4R7rptX4iIpWgTA1g0+pa6iYzFmggMMzIMfz1ckXjAoHSuw+ZR4m8IIFOOeBGPmycOGNacejgymTtp8fv33UDs3AkHqDIOgSn32ho5XyLhOu+iVCgbvx45xRE78GeAHyqWjkSAYzVudaprDVRtAEE6dhAasFJJIGasJfvEkfSJXs4oJF0jsYvSFcWukZiPki3zjUVaTjKGQjiNhPfx5L9k5ZMwTkMPIPAkBINwlf5YRCsD8EM6PFMsFPi5VAaxPxtWqM2Ai8QCP6/MIrKpUTeLnchILWemn0GkMGyN4owOkpbp9TpDy8f2CWqsQ+SpHCrxUaLT6XQ6/4YvuEMkBJwEQTUAAAAASUVORK5CYII=" alt="image" />
                                <div class="table-user-name ml-3">
                                  <p class="mb-0 font-weight-medium"> John Dzikunu </p>
                                  <small> dzikunujohn36@gmail.com</small><br>
                                  <small> +233543715182</small>
                                </div>
                              </div>
                            </td>
                            <td>Male</td>
                            <td>Service Center</td>
                            <td>Ghs 200.00</td>
                            <td>
                              <div class="badge badge-inverse-success"> 2h ago </div>
                            </td>
                            <td>
                             
                          <div class="dropdown">
                              <svg class="dropdown-toggle" type="button" id="actions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:24px;height:24px"  viewBox="0 0 24 24">
                                <path fill="currentColor" d="M12,16A2,2 0 0,1 14,18A2,2 0 0,1 12,20A2,2 0 0,1 10,18A2,2 0 0,1 12,16M12,10A2,2 0 0,1 14,12A2,2 0 0,1 12,14A2,2 0 0,1 10,12A2,2 0 0,1 12,10M12,4A2,2 0 0,1 14,6A2,2 0 0,1 12,8A2,2 0 0,1 10,6A2,2 0 0,1 12,4Z" />
                            </svg>
                            <div class="dropdown-menu" aria-labelledby="actions">
                  
                              <div class="dropdown-item" href="#">

                                <button class="btn btn-primary btn-md m-1"> Edit </button>
                                <button class="btn btn-danger btn-md m-1">Delete</button>
                                
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
                    <h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">20 <i><small>0f</small></i> 100</span>
                    </h3>
                    <div class="d-flex">
                      <button class="btn btn-outline-default"> 
                        <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M20,11V13H8L13.5,18.5L12.08,19.92L4.16,12L12.08,4.08L13.5,5.5L8,11H20Z" />
                    </svg> 
                    Prev.
                  </button>
      
              <button class="btn btn-outline-default"> 
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
                    <AddEmployee @close="ShowAddEmployeeModel"/>
                </div>
            </Teleport>
</template>

<script setup lang="ts">
import AddEmployee from '../components/AddEmployee.vue'
let showAddModel = false;
function ShowAddEmployeeModel() {
    showAddModel = !showAddModel;
    
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
padding: 2%;
}


.page-header{
    margin: 0;
}
</style>