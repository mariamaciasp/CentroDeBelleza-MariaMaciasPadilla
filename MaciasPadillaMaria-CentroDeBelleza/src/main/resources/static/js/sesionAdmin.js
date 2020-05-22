$(function() {

			var valorNombreInicial = $(".nombre").text();
			var valorApellidosInicial = $(".apellidos").text();
			var valorFechaNacInicial = $(".fechaNac").text();
			var valorTelefonoInicial = $(".telefono").text();

			var valorEmailInicial = $(".email").text();


			// PARA NOMBRE

			$("td").on("click",".modificarN",function (even) {

				$(".modificarN").toggleClass("modificarN").toggleClass("guardarN").text("Guardar");
				$(".cancelarN").show();
				$(".nombre").toggleClass("nombre").toggleClass("cambiarNombre").html('<input id="nombre" name="nombre" type="text" placeholder="Nombre" class="form-control">');

			});

			$("td").on("click",".guardarN", function (event) {

				$(".guardarN").toggleClass("guardarN").toggleClass("modificarN").text("Modificar");

				var valorN = $("#nombre").val();

				$(".cambiarNombre").toggleClass("cambiarNombre").toggleClass("nombre").text(valorN);
				$(".cancelarN").hide();
				valorNombreInicial = $(".nombre").text();

			});

			$("td").on("click",".cancelarN", function (event) {
				$(".guardarN").toggleClass("guardarN").toggleClass("modificarN").text("Modificar");

				$(".cambiarNombre").toggleClass("cambiarNombre").toggleClass("nombre").text(valorNombreInicial);

				$(".cancelarN").hide();


			});

			// PARA APELLIDOS

			$("td").on("click",".modificarA",function (even) {

				$(".modificarA").toggleClass("modificarA").toggleClass("guardarA").text("Guardar");
				$(".cancelarA").show();
				$(".apellidos").toggleClass("apellidos").toggleClass("cambiarApellidos").html('<input id="apellidos" name="apellidos" type="text" placeholder="Apellidos" class="form-control">');

			});

			$("td").on("click",".guardarA", function (event) {

				$(".guardarA").toggleClass("guardarA").toggleClass("modificarA").text("Modificar");

				var valorA = $("#apellidos").val();

				$(".cambiarApellidos").toggleClass("cambiarApellidos").toggleClass("apellidos").text(valorA);
				$(".cancelarA").hide();
				valorApellidosInicial = $(".apellidos").text();
				
			});

			$("td").on("click",".cancelarA", function (event) {

				$(".guardarA").toggleClass("guardarA").toggleClass("modificarA").text("Modificar");
				$(".cambiarApellidos").toggleClass("cambiarApellidos").toggleClass("apellidos").text(valorApellidosInicial);
				$(".cancelarA").hide();


			});


			// PARA FECHA DE NACIMIENTO


			$("td").on("click",".modificarFN",function (even) {

				$(".modificarFN").toggleClass("modificarFN").toggleClass("guardarFN").text("Guardar");
				$(".cancelarFN").show();
				$(".fechaNac").toggleClass("fechaNac").toggleClass("cambiarFechaNac").html('<input id="fechaNac" name="fechaNac" type="date" class="form-control">');

			});

			$("td").on("click",".guardarFN", function (event) {

				$(".guardarFN").toggleClass("guardarFN").toggleClass("modificarFN").text("Modificar");
				
				var valorFN = $("#fechaNac").val();

				$(".cambiarFechaNac").toggleClass("cambiarFechaNac").toggleClass("fechaNac").text(valorFN);
				$(".cancelarFN").hide();
				valorFechaNacInicial = $(".fechaNac").text();

			});

			$("td").on("click",".cancelarFN", function (event) {

				$(".guardarFN").toggleClass("guardarFN").toggleClass("modificarFN").text("Modificar");
				$(".cambiarFechaNac").toggleClass("cambiarFechaNac").toggleClass("fechaNac").text(valorFechaNacInicial);
				$(".cancelarFN").hide();


			});


			// PARA TELÉFONO 


			$("td").on("click",".modificarT",function (even) {

				$(".modificarT").toggleClass("modificarT").toggleClass("guardarT").text("Guardar");
				$(".cancelarT").show();
				$(".telefono").toggleClass("telefono").toggleClass("cambiarTelefono").html('<input id="telefono" name="telefono" type="text" placeholder="Teléfono" class="form-control">');

			});

			$("td").on("click",".guardarT", function (event) {

				$(".guardarT").toggleClass("guardarT").toggleClass("modificarT").text("Modificar");

				var valorT = $("#telefono").val();

				$(".cambiarTelefono").toggleClass("cambiarTelefono").toggleClass("telefono").text(valorT);
				$(".cancelarT").hide();
				valorTelefonoInicial = $(".telefono").text();
				
			});

			$("td").on("click",".cancelarT", function (event) {
				$(".guardarT").toggleClass("guardarT").toggleClass("modificarT").text("Modificar");
				$(".cambiarTelefono").toggleClass("cambiarTelefono").toggleClass("telefono").text(valorTelefonoInicial);
				$(".cancelarT").hide();


			});




			// PARA EMAIL

			$("td").on("click",".modificarE",function (even) {

				$(".modificarE").toggleClass("modificarE").toggleClass("guardarE").text("Guardar");
				$(".cancelarE").show();
				$(".email").toggleClass("email").toggleClass("cambiarEmail").html('<input type="mail" id="email" name="email" class="form-control" placeholder="email@mail.com" required>');

			});

			$("td").on("click",".guardarE", function (event) {

				$(".guardarE").toggleClass("guardarE").toggleClass("modificarE").text("Modificar");

				var valorE = $("#email").val();

				$(".cambiarEmail").toggleClass("cambiarEmail").toggleClass("email").text(valorE);
				$(".cancelarE").hide();
				valorEmailInicial = $(".email").text();
				
			});

			$("td").on("click",".cancelarE", function (event) {
				$(".guardarE").toggleClass("guardarE").toggleClass("modificarE").text("Modificar");
				$(".cambiarEmail").toggleClass("cambiarEmail").toggleClass("email").text(valorEmailInicial);
				$(".cancelarE").hide();


			});


		});