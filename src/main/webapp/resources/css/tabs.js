$(document).ready(function() {
    $('.tabs #tabs .tab').fadeOut(0);
    var ActiveTab = $('.tabs .tabs-head li.active').attr('id');
    $('.tabs #tabs .tab#' + ActiveTab).fadeIn(150);
    $('.tabs .tabs-head li').click(function(){
        $('.tabs .tabs-head li').removeClass('active');
        $('.tabs .tabs-head li#' + this.id).addClass('active');
        
        $('.tabs #tabs .tab').fadeOut(0);
        $('.tabs #tabs .tab#' + this.id).fadeIn(150);
    });
    
    $('#Calendar').datepicker({ autoSize: true });
    $('#ClientBirthDay').datepicker({ autoSize: true, buttonImageOnly: true });
    $('#ClientPassportDate').datepicker({ autoSize: true });
    
    $('ul.rooms li').click(function(){
        var inputID = this.id;
        var checkbox = $('input[type=checkbox]#' + inputID);
        var checked = checkbox.attr('checked');
        
        if(checked == 'checked'){
            checkbox.removeAttr('checked');
            $('ul.rooms li#' + this.id).removeClass('active');
            $('div#rooms div#' + this.id).remove();
        }else{
            checkbox.attr('checked', 'checked');
            $('ul.rooms li#' + this.id).addClass('active');
            $('div#rooms').append('<div id="' + this.id + '" class="room">Information about <strong>' + this.id.substr(4, 4) + 'm</strong> room:<br /><br /><strong>Number of beds:</strong> 4<br /><strong>Air conditioning:</strong> Yes<br /><strong>Balcony / Loggia:</strong> Yes<br /><strong>Mini-bar:</strong> Provided<br /><br /><strong>Daily cleaning:</strong> Yes<br /><strong>Separate bathrooms:</strong> Yes<br /><br /><strong> Number of Rooms:</strong> 3<br /><strong>floor:</strong> 3<br /><strong>Height:</strong> 4.5 m<br /><strong>View from window:</strong> The sea, the promenade<br /><br /><strong> Cost:</strong> 200 y.e per night</div>');
        }
    });
    
});