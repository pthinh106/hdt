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
const IngredientName = document.getElementById('IngredientName');
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
    checkRequired([IngredientName,Mahd, PlaceOfDelivery, Rules, ContractPrice]);
});
////////////////////////////////////////////////////////////////
var alertPlaceholder = document.getElementById('AddForm')
var addFormgroud = document.getElementById('AddProduct')
function add() {
    var wrapper = document.createElement('div')
    wrapper.className = 'col-sm-6'
    var wrapper1 = document.createElement('div')
    wrapper1.className = 'col-sm-6'
    wrapper.innerHTML = '<div class="form-group"">' + '<label>Loại Sản Phẩm </label>' + '<label style="color:red ;">(*)</label>'+ '<select class="form-control">'
        + '<option>Cơm Sườn</option>' + '<option>Bún Bò</option> </select> ' +'</div>'
    wrapper1.innerHTML = '<div class="form-group"">'+'<label>Số Lượng Sản Phẩm</label>' + '<label style="color:red ;">(*)</label>'+ '<input type="number" class="form-control"> '+'</div>'
    alertPlaceholder.append(wrapper)
    alertPlaceholder.append(wrapper1)
}
if (addFormgroud) {
    addFormgroud.addEventListener('click', function () {
        add()
    })
}

/*----->
----Tìm Mã----
-------*/
