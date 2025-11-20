const num = document.getElementById('num');
const btnDoble = document.getElementById('btnDoble');
const resultado = document.getElementById('resultado');

btnDoble.addEventListener('click', () => {
  
  const valor = num.value;

  if (valor === '') {
    resultado.textContent = 'Debes ingresar un número';
    return;
  }

  const numero = Number(valor);

  if (isNaN(numero)) {
    resultado.textContent = 'Ingrese un número válido';
    return;
  }

  const doble = numero * 2;

  resultado.textContent = `El doble de ${numero} es ${doble}`;
});