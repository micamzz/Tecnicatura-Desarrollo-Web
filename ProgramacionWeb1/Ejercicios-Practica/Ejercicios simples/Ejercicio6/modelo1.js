const numero1 = document.querySelector('#num1');
const numero2 = document.querySelector('#num2');
const botonMultiplicar = document.querySelector('#btnMultiplicar');
const resultado = document.querySelector('#resultado');


botonMultiplicar.addEventListener('click', () => {
    const valor1 = Number(numero1.value);
    const valor2 = Number(numero2.value);

    if (numero1.value === '' || numero2.value === '') {

        resultado.textContent = 'Se deben ingresar ambos números';
    } else {

        const resultadoMultiplicacion = valor1 * valor2;

        resultado.textContent = `${valor1} X ${valor2} : ${resultadoMultiplicacion}`;

    }

});

