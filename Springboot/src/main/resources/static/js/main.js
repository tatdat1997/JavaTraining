$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["studentName"] = $("#studentName").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var tbhtml  = '<h4 class="text-center">Search reuslt</h4>';
        		tbhtml += "<table class='table table-striped table-bordered text-center'>";
        		tbhtml += "<tr>";  
    			tbhtml += "<th>No</th>";  
				tbhtml += "<th>Code</th>";  
				tbhtml += "<th>Name</th>";
				tbhtml += "<th>Birthday</th>";
				tbhtml += "<th>Address</th>";  
				tbhtml += "<th>Score</th>";  
				tbhtml += "<th>Edit</th>"; 
				tbhtml += "</tr>";  
					var json2;
	            for(var i = 0; i < data.result.length; i++) {
	            	tbhtml += "<tr>";
	                tbhtml += "<td>"+data.result[i].studentId+"</td>";
	                tbhtml += "<td>"+data.result[i].studentName+"</td>";
	                tbhtml += "<td>"+data.result[i].studentCode+"</td>";
	                tbhtml += "<td>"+data.result[i].studentInfoBasic.address+"</td>";
	                tbhtml += "<td>"+data.result[i].studentInfoBasic.dateOfBirthFormat+"</td>";
	                tbhtml += "<td>"+data.result[i].studentInfoBasic.averageSore+"</td>";
	                tbhtml += "<td>";
	                tbhtml += "<form action='/deleteStudent/id/"+data.result[i].studentInfoBasic.infoId+"' onsubmit='return submitForm(this);'>";
	                tbhtml += "<a href='/infoStudent/id/"+data.result[i].studentId+"' class='btn btn-primary'>Edit</a>";
                	tbhtml += "<button class='btn btn-danger' >Delete</button></form></td>";
	                tbhtml += "</tr>";
	            }
	            var json = "<h4>Ajax Response</h4><pre>"
	                + JSON.stringify(data, null, 4) + "</pre>";
	            
        	
	            if(data.result.length > 0){
	            	$('#feedback').html(tbhtml);
	            }else{
	            	var error = "<div class='alert alert-warning alert-dismissible fade show col-sm-8 offset-md-2'>";
	            	error += "<strong>Warning!</strong> "+data.msg+"</div>";
	            	$('#feedback').html(error);
	            }
            
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {
        	var obj = JSON.parse(e.responseText);
            var json = "<h4>Search reuslt warning</h4><pre>"
                + obj.msg + "</pre>";
            var error = "<div class='alert alert-warning alert-dismissible fade show col-sm-8 offset-md-2'>";
        	error += "<strong>Warning! </strong>"+obj.msg;
        	error += '</div>';
        	$('#feedback').html(error);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}