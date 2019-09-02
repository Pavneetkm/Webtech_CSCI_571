
<html>
<head>
    <title>Congress Selection </title>
    
   <script type="text/javascript">
function validateForm() {

      var y = document.forms["myForm"]["keyword"].value;
    if (y == null || y == "") {
        alert("Keyword* must be filled out");
        return false;
        }
    
}
       
       function selectonchange(){
           
           var x= document.getElementById("Legislators");
           {
               document.getElementById("change").innerHTML= "State/Representative*: "
           }
           
       }
        
    </script>
    </head>
    <body>
    <form name="myForm" method="POST" onsubmit="return validateForm()"><br><br><br><br>
        <center><h2>Congress Information Search</h2></center>
       <div align="middle" style="border: 1.5px solid black; padding:5px; width:35%;margin-left:280px;margin-top:20px;">
           Congress Database:  &nbsp; <select id="select" name="select" onchange="selectonchange()">
           <option selected disabled>Select your option</option>
           <option name="Legislators" id="Legislators">Legislators</option>
           <option name="Committees" id="Committees">Committees</option>
           <option name="Bills" id="Bills">Bills</option>
           <option name="Amendments" id="Amendments">Amendments</option></select><br>
           Chamber:   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="radio" name="chamber" value="Senate">Senate
           <input type="radio" name="Chamber" value="House">House<br>
           <span id=change >
        Keyword*:
               </span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="keyword" > <br>
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<button type="submit" value="Submit">Search</button>
  <input type="button" value="Clear" onClick="this.form.reset();"><br>
           <a href="http://sunlightfoundation.com/" target="_blank"><u>Powered by Sunlight Foundation</u></a>
    
        </div>
        </form>
    
    </body>

</html>