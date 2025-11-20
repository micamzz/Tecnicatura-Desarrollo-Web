const num = document.getElementById('num');
const btnParImpar = document.getElementById('btnParImpar');
const resultado = document.getElementById('resultado');

btnParImpar.addEventListener('click', () => {

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


  if (numero % 2 === 0) {
    resultado.textContent = `El número ${numero} es PAR`;
  } else {
    resultado.textContent = `El número ${numero} es IMPAR`;
  }
});