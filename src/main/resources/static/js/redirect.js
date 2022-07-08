window.addEventListener('load', function () {
    const token = localStorage.getItem("session");
    if (token === null) window.location.href = '/index';
});