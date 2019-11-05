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
    console.log(search);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var tbhtml  = '<h4 class="text-center">Search reuslt</h4>'
		        		 + "<p class='text-center'>There are "+data.totalStudent+" students, divided into "+data.totalPage+" pages</p>"
		        		 + "<table class='table table-striped table-bordered text-center'>"
		        		 + "<tr>"  
		    			 + "<th style='width: 90px;'>No</th>"
						 + "<th style='width: 190px;'>Name</th>"  
						 + "<th style='width: 140px;'>Code</th>"
						 + "<th style='width: 190px;'>Address</th>"
						 + "<th style='width: 100px;'>Birthday</th>"  
						 + "<th style='width: 90px;'>Score</th>" 
						 + "<th style='width: 140px;'>Edit</th>"  
						 + "</tr>";  
	            for(var i = 0; i < data.result.length; i++) {
	            	var j = i + 1 ;
	            	tbhtml += "<tr>"
	                 + "<td>"+j+"</td>"
	                 + "<td>"+data.result[i].studentName+"</td>"
	                 + "<td>"+data.result[i].studentCode+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.address+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.dateOfBirthFormat+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.averageSore+"</td>"
	                 + "<td>"
	                 + "<form action='/deleteStudent/id/"+data.result[i].studentInfoBasic.infoId+"' onsubmit='return submitForm(this);'>"
	                 + "<a href='/infoStudent/id/"+data.result[i].studentId+"' class='btn btn-primary'>Edit</a>&nbsp"
                	 + "<button class='btn btn-danger' >Delete</button></form></td>"
	                 + "</tr>";
	            }
	            tbhtml += "<input type='hidden' id='totalPage' value="+data.totalPage+">";
	            if(data.result.length > 0){
	            	$('#feedback').html(tbhtml);
	            	document.getElementById("pagination").style.display = 'block';
	            }else{
	            	var error = "<div class='alert alert-warning fade show col-sm-8 offset-md-2'" +
	            			"id='ErrorMsg'>";
	            	error += "<strong>Warning!</strong> " + data.msg
	            	+ "<a onclick='myFunction()' style='margin-left: 68%;'><i class='fa fa-times'></i></a>" 
	            	+ "</div>";
	            	$('#feedback').html(error);
	            }
            
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {
        	var obj = JSON.parse(e.responseText);
            var error = "<div class='alert alert-warning fade show col-sm-8 offset-md-2'" +
            		"id='ErrorMsg'>";
        	error += "<strong>Warning! </strong>"+obj.msg
        	+ "<a onclick='myFunction()' style='margin-left: 44%;'><i class='fa fa-times'></i></a>" 
        	+ "</div>";
        	error += '</div>';
        	$('#feedback').html(error);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}



function fire_ajax_next() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/search/page/"+page,
        data: "",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var tbhtml  = '<h4 class="text-center">Search reuslt</h4>'
        		 + "<table class='table table-striped table-bordered text-center'>"
        		 + "<tr>"
    			 + "<th style='width: 90px;'>No</th>"
				 + "<th style='width: 190px;'>Name</th>"  
				 + "<th style='width: 140px;'>Code</th>"
				 + "<th style='width: 190px;'>Address</th>"
				 + "<th style='width: 100px;'>Birthday</th>"  
				 + "<th style='width: 90px;'>Score</th>" 
				 + "<th style='width: 140px;'>Edit</th>" 
				 + "</tr>";  
					var json2;

	            for(var i = 0; i < data.result.length; i++) {
	            	var j = i + 1;
	            	tbhtml += "<tr>"
	                 + "<td>"+j+"</td>"
	                 + "<td>"+data.result[i].studentName+"</td>"
	                 + "<td>"+data.result[i].studentCode+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.address+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.dateOfBirthFormat+"</td>"
	                 + "<td>"+data.result[i].studentInfoBasic.averageSore+"</td>"
	                 + "<td>"
	                 + "<form action='/deleteStudent/id/"+data.result[i].studentInfoBasic.infoId+"' onsubmit='return submitForm(this);'>"
	                 + "<a href='/infoStudent/id/"+data.result[i].studentId+"' class='btn btn-primary'>Edit</a>&nbsp"
                	 + "<button class='btn btn-danger' >Delete</button></form></td>"
	                 + "</tr>";
	            }
	            tbhtml += "<input type='hidden' id='totalPage' value="+totalPage+">";
	            var json = "<h4>Ajax Response</h4><pre>"
	                + JSON.stringify(data, null, 4) + "</pre>";
	            
        	
	            if(data.result.length > 0){
	            	$('#feedback').html(tbhtml);
	            }else{
	            	var error = "<div class='alert alert-warning alert-dismissible fade show col-sm-8 offset-md-2'>";
	            	error += "<strong>Warning!</strong>Somthing wrong! No more than student!</div>";
	            	$('#feedback').html(error);
	            }
            
            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {
        	document.getElementById("pagination").style.display = 'none';
        	var obj = JSON.parse(e.responseText);
            var json = "<h4>Search reuslt warning</h4><pre>"
                + obj.msg + "</pre>";
            var error = "<div class='alert alert-warning alert-dismissible fade show col-sm-8 offset-md-2'>";
        	error += "<strong>Warning! </strong> Somthing wrong!!! "+obj.msg;
        	error += '</div>';
        	$('#feedback').html(error);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
    
}

var totalPage;
var page = 0;
var url = "/api/search/page/"+page;
$("#btn-pre").on("click", function(){
	if (page >= 1) {
		page--;

		fire_ajax_next();
	}
});

// handling the next-btn
$("#btn-next").on("click", function(){
	totalPage = document.getElementById("totalPage").value;
	if(page < totalPage - 1){
		page++;

		fire_ajax_next();
	}
});

