window.addEventListener('load', function () {
  const container = document.querySelector('#patient-list');


  const url = '/patients';

  const settings = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    }
  };

  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
        const content = data.map((patient) => (
          `<div class="item">
            <p>${patient.name} ${patient.lastname}</p>
          </div>`
        ));

        container.innerHTML = content;
    })
});
