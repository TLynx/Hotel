/**
 * Created by Администратор on 23.02.2016.
 */
$(document).on({
        mouseenter: function() {
        $( this ).addClass( "scale" );
    }, mouseleave: function() {
        $( this ).removeClass( "scale" );
    }
},".offer");
