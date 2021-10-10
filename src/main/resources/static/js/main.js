/**
 *
 */

$(document).ready(function (){

    $('.table .eBtn').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
            $.get(href, function (user, status) {
                $('.myForm #id').attr('readonly','readonly').val(user.id);
                $('.myForm #username').val(user.username);
                $('.myForm #surname').val(user.surname);
                $('.myForm #age').val(user.age);
                $('.myForm #email').val(user.email);
                $('.myForm #password').val(user.password);

            });

            $('.myForm #exampleModal').modal();

    });
});

$(document).ready(function (){

    $(' .table .dBtn').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myFormDelete #id1').attr('readonly','readonly').val(user.id);
            $('.myFormDelete #username1').attr('readonly','readonly').val(user.username);
            $('.myFormDelete #surname1').attr('readonly','readonly').val(user.surname);
            $('.myFormDelete #age1').attr('readonly','readonly').val(user.age);
            $('.myFormDelete #email1').attr('readonly','readonly').val(user.email);
            $('.myFormDelete #password1').attr('readonly','readonly').val(user.password);

        });

        $('.deleteForm #exampleModal').modal();

    });
});