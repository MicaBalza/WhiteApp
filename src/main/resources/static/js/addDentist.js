window.addEventListener('load', function () {
  const form = document.querySelector('#new-dentist-form');

  form.addEventListener('submit', function (event) {
    event.preventDefault();

    let data = {
      name: document.querySelector('#dentist-name').value,
      lastname: document.querySelector('#dentist-lastname').value,
      license: document.querySelector('#dentist-license').value
    };

    const url = '/dentist/new';

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
        let successAlert ='<div>Dentist added !</div>';

        document.querySelector('#dentist-response').innerHTML = successAlert;
        document.querySelector('#dentist-response').style.display = 'block';
        resetUploadForm();
      })
      .catch((error) => {
      console.log(error);
        let errorAlert = '<div>Error, please try again</div>';

        document.querySelector('#dentist-response').innerHTML = errorAlert;
        document.querySelector('#dentist-response').style.display = 'block';
      });
  });

  function resetUploadForm() {
    document.querySelector('#dentist-name').value = '';
    document.querySelector('#dentist-lastname').value = '';
    document.querySelector('#dentist-license').value = '';
  }
});