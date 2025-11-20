const numero1 = document.querySelector('#num1');
const numero2 = document.querySelector('#num2');
const botonEnviar = document.querySelector('#btnSumar');
const resultado = document.querySelector('#resultado');


botonEnviar.addEventListener('click', () =>{

 const valor1 = numero1.value;
 const valor2 = numero2.value;

   if (valor1 === '' || valor2 === '') {
    resultado.textContent = 'Se deben ingresar ambos números';
    return;
  }

 const suma = Number(valor1) + Number(valor2);
     

  resultado.textContent =`El resultado es : ${suma}`;


});