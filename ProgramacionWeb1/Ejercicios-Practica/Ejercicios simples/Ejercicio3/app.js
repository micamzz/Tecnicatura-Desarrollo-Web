const textarea = document.querySelector('#texto');
const contador = document.querySelector('#contador');

textarea.addEventListener('input', () =>{
 
    const cantidad = textarea.value.length;

    contador.textContent = `${cantidad} caracteres`;

})