window.addEventListener('load', function () {
  const form = document.querySelector('#new-dentist-form');

  form.addEventListener('submit', function (event) {
    event.preventDefault();
    const formData = {
      name: document.querySelector('#nombre').value,
      lastname: document.querySelector('#apellido').value,
      license: document.querySelector('#matricula').value,
    };
    const url = '/dentist/new';
    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
      console.log("hola");
        //Si no hay ningun error se muestra un mensaje diciendo que el odontologo
        //se agrego bien
        let successAlert =
          '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong></strong> Odontologo agregado </div>';

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').style.display = 'block';
        resetUploadForm();
      })
      .catch((error) => {
      console.log("error");
        //Si hay algun error se muestra un mensaje diciendo que el odontologo
        //no se pudo guardar y se intente nuevamente
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong> Error intente nuevamente</strong> </div>';

        document.querySelector('#response').innerHTML = errorAlert;
        document.querySelector('#response').style.display = 'block';
        //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
        // resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector('#nombre').value = '';
    document.querySelector('#apellido').value = '';
    document.querySelector('#matricula').value = '';
  }
});
