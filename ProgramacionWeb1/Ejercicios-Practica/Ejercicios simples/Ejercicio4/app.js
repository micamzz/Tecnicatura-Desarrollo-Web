const num1 = document.querySelector('#a');
const num2 = document.querySelector('#b');
const boton = document.querySelector('#btn');
const resultado = document.querySelector('#info');

boton.addEventListener('click', ()=>{

    const valor1 = Number(num1.value);
    const valor2 = Number(num2.value);

     if(valor1 == '' || valor2==''){
         resultado.textContent = `Debe ingresar ambos números`;
         return;
     }


    if (valor1 > valor2) {

        resultado.textContent = `El numero ${valor1} es MAYOR que el numero ${valor2}`;

    } else if (valor1 < valor2) {

        resultado.textContent = `El numero ${valor2} es MAYOR que el numero ${valor1}`;

    } else {

        resultado.textContent = `Son el mismo numero`;

    }


});