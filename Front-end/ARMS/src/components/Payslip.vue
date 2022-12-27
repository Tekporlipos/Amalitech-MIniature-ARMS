<template>
   <div class="card myDivToPrint" id="payslip" >

<div class="card-head p-1">
  <h3 class="card-title text-center">
  Payslip for December, 2022
  </h3>
</div>
<div class="card-content">
  <div class="head-title">
    <div>
      SSNIT Office Complex
    </div>
    <div>
      27 Ama Akroma Street
    </div>
    <div>
      Takoradi - Ghana
    </div>
  </div>
  <div>


    <div class="head-details">
      <div class="head-details">
      <div class="card-body px-0 overflow-auto">
      <div class="table-responsive">
        <table class="table">
          <tbody>
            <tr>
              <td><b>Staff Name:</b></td>
              <td> {{ user.first_name }} {{ user.other_names }}  {{ user.last_name }} </td>
            </tr>

            <tr>
              <td><b>Department:</b></td>
              <td>{{ user.department }} </td>
            </tr>

            <tr>
              <td><b>Annual Basic Salary:</b></td>
              <td> {{formatter(user.salary * 12) }}</td>
            </tr>
            <tr>
              <td><b>Branch:</b></td>
              <td>CalBank</td>
            </tr>
            <tr>
              <td><b>SSNIT Number:</b></td>
              <td>1400002840458</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    </div>

    <div class="head-details">
      <div class="card-body px-0 overflow-auto">
      <div class="table-responsive">
        <table class="table">
          <tbody>
            <tr>
              <td><b>Staff ID:</b></td>
              <td> </td>
            </tr>

            <tr>
              <td><b>Job Position:</b></td>
              <td> {{ user.position }}</td>
            </tr>

            <tr>
              <td><b>Email:</b></td>
              <td>{{ user.email }}</td>
            </tr>
            <tr>
              <td><b>Bank Name:</b></td>
              <td>CalBank</td>
            </tr>
            <tr>
              <td><b>Account Number:</b></td>
              <td>1400002840458</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    </div>
    </div>

    <div class="card-body px-0 overflow-auto">
      <h4 class="card-title pl-4 bold"><b>Earnings</b></h4>
      <div class="table-responsive">
        <table class="table">
        
          <tbody>
            <tr>
              <td>Basic Salary</td>
              <td>{{ formatter (user.salary) }} </td>
            </tr>

            <tr>
              <td>Lunch Allowance</td>
              <td>dddd</td>
            </tr>

            <tr>
              <td>Total Earnings</td>
              <td>dddd</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="card-body px-0 overflow-auto">
      <h4 class="card-title pl-4 bold"><b>Deductions</b></h4>
      <div class="table-responsive">
        <table class="table">
          <tbody>
            <tr>
              <td>Employee SSF (5.5%)</td>
              <td> helo </td>
            </tr>

            <tr>
              <td>PAYE</td>
              <td>dddd</td>
            </tr>

            <tr>
              <td>Total Deductions</td>
              <td>dddd</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
<br>
<br>
    <div class="head-title">
    <div>
      <b>Net Salary</b>
    </div>
   
    <div>
      <b> 2,788.42</b>
    </div>
  </div>

  </div>
</div>
<div class="card-footer">
  <div class="page-header flex-wrap">
<h3 class="mb-0"><span class="pl-0 h6 pl-sm-2 text-muted d-inline-block"></span>
</h3>
<div class="d-flex">
  <button type="button" @click="$emit('close')" class="btn btn-sm ml-3 btn-defualt"> Close </button>
  <input type="submit" @click="docPrint()" value="Print"  class="btn btn-sm ml-3 btn-success">
</div>
  </div>
</div>

</div>
</template>

<script>
    export default {
        name:"Payslip",
        props:["user"],
        methods:{
            docPrint() {
                    window.print()
            },
            submit() {
      this.$emit('close')
    },
    formatter(value){
  const f = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'GHS',
});
      return f.format(value);
    }
        },
        data() {
            return {
                
            }
        },
    }

    const formatter = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'GHS',
});
</script>

<style scoped>


.head-details,
.head-title{
  display: flex;
  justify-content: space-between;
}
.head-details{
margin: 0em 1em;
}
.head-title{
  border-top: solid 2px rgb(252, 117, 68);
  border-bottom: solid 2px rgb(252, 117, 68);
  padding: 1em;
 
}
.card-content{
  margin: 1em;
}

@media print {
    .card-footer {
        display: none;
    }
    .myDivToPrint {
        background-color: white;
        height: 100%;
        width: 100%;
        position: fixed;
        top: 0;
        left: 0;
        margin: 0;
        padding: 15px;
        font-size: 14px;
        line-height: 18px;
    }
}

</style>