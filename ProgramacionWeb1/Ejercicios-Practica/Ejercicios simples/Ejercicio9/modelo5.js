const nombre = document.getElementById('nombre');
const btnVocal = document.getElementById('btnVocal');
const resultado = document.getElementById('resultado');


btnVocal.addEventListener('click', () => {

  const valor = nombre.value.trim();

  if (valor === '') {
    resultado.textContent = 'Debes ingresar un nombre';
    return;
  }
    const primerLetra = valor.charAt(0).toLowerCase();

    const vocales = ['a','e','i','o','u'];

    if(vocales.includes(primerLetra)){
     resultado.textContent = `El nombre ${valor} empieza con vocal`;

    }else{

         resultado.textContent = `El nombre ${valor}  NO empieza con vocal`;
    }

  });