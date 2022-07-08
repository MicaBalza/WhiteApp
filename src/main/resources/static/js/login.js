window.addEventListener('load', function () {
  const form = document.querySelector('#login-form');

  form.addEventListener('submit', function (event) {
    event.preventDefault();

    let data = {
      username: document.querySelector('#username').value,
      password: document.querySelector('#password').value
    };

    const url = '/auth';

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
        localStorage.setItem('session', data.jwt);
        window.location.href = '/home';
      })
      .catch((error) => {
        console.log(error);
      });
  });
});