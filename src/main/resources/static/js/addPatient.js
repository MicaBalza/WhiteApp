window.addEventListener('load', function () {
  const form = document.querySelector('#new-patient-form');

  form.addEventListener('submit', function (event) {
    event.preventDefault();

    let data = {
      name: document.querySelector('#patient-name').value,
      lastname: document.querySelector('#patient-lastname').value,
      dni: document.querySelector('#patient-dni').value,
      address: {
        street: document.querySelector('#address-street').value,
        number: document.querySelector('#address-number').value
      }
    };

    const url = '/patient/new';

    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        let successAlert ='<div>Patient added</div>';

        document.querySelector('#patient-response').innerHTML = successAlert;
        document.querySelector('#patient-response').style.display = 'block';
          // resetUploadForm();
      })
      .catch((error) => {
      console.log(error);
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong> Error intente nuevamente</strong> </div>';

        //document.querySelector('#patient-response').innerHTML = errorAlert;
        //document.querySelector('#patient-response').style.display = 'block';
        // resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector('#patient-name').value = '';
    document.querySelector('#patient-lastname').value = '';
    document.querySelector('#patient').value = '';
  }
});
