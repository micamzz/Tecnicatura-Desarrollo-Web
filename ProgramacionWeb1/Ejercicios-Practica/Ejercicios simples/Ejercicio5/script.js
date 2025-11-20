const numero1 = document.querySelector('#num1');
const numero2 = document.querySelector('#num2');
const numero3 = document.querySelector('#num3');
const botonCalcular = document.querySelector('#btnPromedio');
const resultado = document.querySelector('#resultado');


botonCalcular.addEventListener('click', () =>{

 const valor1 = Number(numero1.value);
 const valor2 = Number(numero2.value);
 const valor3 = Number(numero3.value);

    if(valor1 < 0 || valor2 <= 0 || valor3 <= 0 || numero1.value === '' || numero2.value === '' || numero3.value === ''){

    resultado.textContent = "Todos los números deben ser mayores a 0";
    }else{
     
        const suma = valor1 + valor2 + valor3;

        const promedio = suma / 3 ;

        resultado.textContent= ` El promedio es : ${promedio}`;

    }

});