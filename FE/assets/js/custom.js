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
    var alertPlaceholder = document.getElementById('AddForm');
    var addFormgroud = document.getElementById('AddIP');
    var getList = document.getElementById('ListIP').innerHTML;
    function add() {
    var wrapper = document.createElement('div')
    wrapper.id ='ListIP';
    wrapper.className = 'ListIP col-sm-12';
    wrapper.innerHTML=getList
    alertPlaceholder.append(wrapper)
    
}
if (addFormgroud) {
    addFormgroud.addEventListener('click', function () {
    add()
    })
}  
    /*----->
    ----Popup----
    -------*/
