/**
 * Jquery (ajax)
 */

var prefix = "service/users";
	
	var RestGet = function() {	//получение данных о юзере по Id
        $.ajax({
            type: 'GET',
            url:  prefix + '/' + $('#Id').val(),
            dataType: 'json',
            success: function(data, status) {
            	if (status == "nocontent") alert ("Пользователя с таким Id нет");
            	else $("#data").text(JSON.stringify(data));
            },
            error: function() {
            	alert("Ошибка");
            }
        });
    };
    
	var RestPost = function() {	//создание нового юзера
        $.ajax({
            type: 'POST',
            url:  prefix,
            async: true,
            contentType: "application/json",
            data: JSON.stringify( { "name": $('#user_name').val(), "money": $('#money').val(), "email": $('#email').val() } ),
            success: function() {
            	alert("Новый пользователь записан в БД")
            },
            error: function() {
            	alert("Error_Post");
            }
        });
    };
    
	var RestPut = function() {	//обновление юзера по ID
        $.ajax({
            type: 'PUT',
            url:  prefix + '/' + $('#Id').val(),
            dataType: "text",
            async: true,
            contentType: "application/json",
            data: JSON.stringify( { "name": $('#user_name').val(), "money": $('#money').val(), "email": $('#email').val() } ),
            success: function(response) {
            	alert("Пользователь c Id "+ $('#Id').val() + " обновлен")
            },
            error: function(response) {
            	if (response.status == 404) alert("Пользователя с таким Id нет");
            	else alert("Введите Id");
            }
        });
    };
    
	var RestDelete = function() {	//удаление юзера по ID
        $.ajax({
            type: 'DELETE',
            url:  prefix + '/' + $('#Id').val(),
            async: true,
            success: function() {
            	alert("Пользователь c Id "+ $('#Id').val() + " удалён")
            },
            error: function() {
            	alert("Введите Id");
            }
        });
    }; 
    
    var RestBuy = function() {	//создание покупки юзером
        $.ajax({
            type: 'POST',
            url:  prefix + '/buy/' + $('#Id_user').val(),
            async: true,
            contentType: "application/json",
            data: JSON.stringify( { "productName": $('#productName').val(), "price": $('#price').val(), "category": $('#category').val(), "description": $('#description').val() } ),
            success: function() {
            	alert("Покупка занесена в БД")
            },
            error: function() {
            	alert("Пользователя с таким Id нет");
            }
        });
    };