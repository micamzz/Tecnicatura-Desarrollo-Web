const palabra = document.getElementById('palabra');
const btnInvertir = document.getElementById('btnInvertir');
const resultado = document.getElementById('resultado');

btnInvertir.addEventListener('click', () => {

  const valor = palabra.value.trim();
  
  if (valor === '') {
    resultado.textContent = 'Debes ingresar una palabra';
    return;
  }

  const invertida = valor.split('').reverse().join('');

  resultado.textContent = `Palabra invertida: ${invertida}`;
});