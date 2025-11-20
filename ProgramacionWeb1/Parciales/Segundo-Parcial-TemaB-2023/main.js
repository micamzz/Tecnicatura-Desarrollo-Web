const inputTextoIngresado = document.getElementById('texto-ingresado');

const colorSeleccionado = document.getElementById('color');

const alineacionSeleccionada = document.getElementsByName('alineacion');

const titulo = document.querySelector('.js-titulo');

const fondo = document.querySelector('.vista');

const tituloOriginal = titulo.textContent;

inputTextoIngresado.addEventListener('input', () =>{

    const texto = inputTextoIngresado.value;

    titulo.textContent =  inputTextoIngresado.value  || 'Título';

    // titulo.textContent = texto === '' ? tituloOriginal : texto;
});


colorSeleccionado.addEventListener('change', () =>{
    
    const colorElegido = colorSeleccionado.value;
    fondo.classList.remove('rojo','azul','verde');
    fondo.classList.add(colorElegido);
});




alineacionSeleccionada.forEach((item) =>{

 item.addEventListener('change', () =>{
   
    fondo.classList.remove('centrado','izquierda','derecha');
    fondo.classList.add(item.value)
    // o fondo.classList.add(item.id);

 });

});