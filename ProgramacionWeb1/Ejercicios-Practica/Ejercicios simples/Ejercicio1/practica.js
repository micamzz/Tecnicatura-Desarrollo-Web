const form = document.querySelector('#form-cubo');
const inputNumero = document.querySelector('#numero');
const mensaje = document.querySelector('#mensaje');

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const valor = inputNumero.value.trim();

  if (valor === '') {
    mensaje.textContent = 'Por favor, ingresá un número.';
    return;
  }

  const numero = Number(valor);


  if (isNaN(numero)) {
    mensaje.textContent = 'El valor ingresado no es un número válido.';
    return;
  }

  const cubo = numero ** 3;

  mensaje.textContent = `El cubo de ${numero} es ${cubo}`;
});
