$('#calendar').datepicker({
		});

!function ($) {
    $(document).on("click","ul.nav li.parent > a ", function(){          
        $(this).find('em').toggleClass("fa-minus");      
    }); 
    $(".sidebar span.icon").find('em:first').addClass("fa-plus");
}

(window.jQuery);
	$(window).on('resize', function () {
  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(document).on('click', '.panel-heading span.clickable', function(e){
    var $this = $(this);
	if(!$this.hasClass('panel-collapsed')) {
		$this.parents('.panel').find('.panel-body').slideUp();
		$this.addClass('panel-collapsed');
		$this.find('em').removeClass('fa-toggle-up').addClass('fa-toggle-down');
	} else {
		$this.parents('.panel').find('.panel-body').slideDown();
		$this.removeClass('panel-collapsed');
		$this.find('em').removeClass('fa-toggle-down').addClass('fa-toggle-up');
	}
})

/*---------------------------------
----------Validation-------------------
----------------------------------*/

const form = document.getElementById('form');
const Mahd = document.getElementById('Mahd');
const PlaceOfDelivery = document.getElementById('PlaceOfDelivery');
const Rules = document.getElementById('Rules');
const ContractPrice = document.getElementById('ContractPrice');
///////////////////////////////////////////////////////////////
const Manl = document.getElementById('Manl');
const IngredientName = document.getElementById('IngredientName');
const Unit = document.getElementById('Unit');
const ImportPrice = document.getElementById('ImportPrice');
Unit

const Mapxsp = document.getElementById('Mapxsp');

//Show input error messages
function showError(input, message) {
    const formControl = input.parentElement;
    formControl.className = 'form-group has-error';
}

//show success colour
function showSucces(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-group has-success';
}


//checkRequired fields
function checkRequired(inputArr) {
    inputArr.forEach(function(input){
        if(input.value.trim() === ""){
            showError(input,`${getFieldName(input)} is required`)
        }else {
            showSucces(input);
        }
    });
}


//get FieldName
function getFieldName(input) {
    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}


//Event Listeners
form.addEventListener('submit',function(e) {
    e.preventDefault();
    checkRequired([Mahd, PlaceOfDelivery, Rules, ContractPrice]);
    checkRequired([Manl, IngredientName, Unit, ImportPrice]);
    checkRequired([Mapxsp]);
    
});
////////////////////////////////////////////////////////////////
var alertPlaceholder = document.getElementById('AddForm')
var addFormgroud = document.getElementById('AddProduct')
let getList = document.getElementById('ListIngredient').innerHTML;
function add() {
    var wrapper0 = document.createElement('div')
    wrapper0.id ='ListIngredient';
    wrapper0.className = 'ListIngredient col-sm-12';
    wrapper0.innerHTML=getList
	alertPlaceholder.append(wrapper0)
    
}
if (addFormgroud) {
    addFormgroud.addEventListener('click', function () {
      add()
    })
}

var alertPlaceholder = document.getElementById('AddForm')
var addFormgroud1 = document.getElementById('AddIngredientImport')
function add1() {
    var wrapper = document.createElement('div')
    wrapper.className = 'col-sm-6'
	var wrapper1 = document.createElement('div')
    wrapper1.className = 'col-sm-6'
    wrapper.innerHTML = '<div class="form-group"">' + '<label>Nguyên Liệu</label>' + '<label style="color:red ;">(*)</label>'+ '<select class="form-control">' 
	+ '<option>Gạo Lức</option>' + '<option>Bào Ngư</option>'+'<option>Trứng Gà</option> </select> ' +'</div>'
	wrapper1.innerHTML = '<div class="form-group"">'+'<label>Số Lượng Sản Phẩm</label>' + '<label style="color:red ;">(*)</label>'+ '<input type="number" class="form-control"> '+'</div>'
	alertPlaceholder.append(wrapper)
	alertPlaceholder.append(wrapper1)
}
if (addFormgroud1) {
    addFormgroud1.addEventListener('click', function () {
      add1()
    })
}

var alertPlaceholder = document.getElementById('AddForm')
var addFormgroud2 = document.getElementById('AddProductImport')
function add2() {
    var wrapper = document.createElement('div')
    wrapper.className = 'col-sm-6'
	var wrapper1 = document.createElement('div')
    wrapper1.className = 'col-sm-6'
    wrapper.innerHTML = '<div class="form-group"">' + '<label>Sản Phẩm</label>' + '<label style="color:red ;">(*)</label>'+ '<select class="form-control">' 
	+ '<option>Cơm cháy</option>' + '<option>Súp Bào Ngư</option>'+'<option>Trứng Luộc</option> </select> ' +'</div>'
	wrapper1.innerHTML = '<div class="form-group"">'+'<label>Số Lượng Sản Phẩm</label>' + '<label style="color:red ;">(*)</label>'+ '<input type="number" class="form-control"> '+'</div>'
	alertPlaceholder.append(wrapper)
	alertPlaceholder.append(wrapper1)
}
if (addFormgroud2) {
    addFormgroud2.addEventListener('click', function () {
      add2()
    })
}
/*----->
----Popup----
-------*/
