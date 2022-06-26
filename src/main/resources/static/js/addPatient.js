<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>White | Dental Clinic</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://unpkg.com/tailwindcss-jit-cdn"></script>
    <script type="module" th:src="@{js/tailwind-config.js}"></script>
    <script type="tailwind-config">
      window.tailwindConfig
    </script>
    <script type="text/javascript" th:src="@{js/addDentist.js}"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Rubik:wght@400;600;700&display=swap"
      rel="stylesheet"
    />
  </head>
  <body class="bg-fill">
  <header class="px-8 py-5 bg-main">
    <div class="flex">
      <div class="flex flex-1 justify-start mr-auto">
        <img
                th:src="@{img/white-logo-horizontal.svg}"
                alt="White - Dental Clinic"
        />
      </div>
      <div class="flex flex-1 justify-center">
        <img
                th:src="@{img/white-logo-illustration.svg}"
                alt="White - Dental Clinic"
        />
      </div>
      <div class="flex flex-1 justify-end ml-auto">
        <button
                class="font-semibold text-sm text-white tracking-widest focus:outline-none"
        >
          LOGIN
        </button>
      </div>
    </div>
  </header>
    <main class="px-9 py-8">
      <div class="flex gap-4">
        <div class="min-w-[420px] px-8 py-7 bg-white rounded">
          <div class="flex">
            <div class="h-[120px] w-[120px] mr-5 bg-fill rounded-full"></div>
            <div class="flex flex-col justify-between">
              <p class="font-semibold text-main">MBALZA</p>
              <div>
                <p class="font-semibold">Micaela Balza</p>
                <p>mbalza@gmail.com</p>
                <p>38.267.554</p>
              </div>
            </div>
          </div>
        </div>
        <div class="min-w-[420px] px-8 py-7 bg-white rounded">
          <p>Add Patient</p>
        </div>
        <div class="min-w-[420px] px-8 py-7 bg-white rounded">
          <p>Add Dentist</p>
          <form id="new-dentist-form">
            <div class="form-group">
                <label class="control-label" for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre"
                       placeholder="Ingrese el nombre"
                       name="nombre" required/>
            </div>
            <div class="form-group">
                <label class="control-label" for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido"
                       placeholder="Ingrese el apellido"
                       name="apellido" required/>
            </div>

            <div class="form-group">
                <label class="control-label" for="matricula">Matricula:</label>
                <input type="text" class="form-control" id="matricula"
                       placeholder="Ingrese la matricula"
                       name="matricula" required/>
            </div>


            <button type="submit" class="btn btn-danger"
                    id="btn-add-new-odontologo">Guardar</button>
        </form>
        <div id="response" style="display:none; margin-top:10px">
        </div>
      </div>
    </main>
    <footer
      class="fixed bottom-4 flex justify-center w-full text-xs text-main tracking-widest"
    >
      WHITE | Dental Clinic - 2022
    </footer>
  </body>
</html>