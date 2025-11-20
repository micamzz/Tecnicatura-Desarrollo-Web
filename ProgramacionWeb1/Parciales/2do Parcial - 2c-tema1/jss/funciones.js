const fondo = document.querySelector('.vista');

const titulo = document.querySelector('.js-titulo');

const inputTextoIngresado = document.getElementById('texto-ingresado');

const colorSeleccionado = document.getElementById('color');

const alineacionElegida = document.querySelectorAll('input[name="alineacion"]');
const footer = document.querySelector('footer');


   let nuevoElemento = document.createElement('h2');
   nuevoElemento.classList.add('datos-alumno')
   nuevoElemento.textContent = 'DATOS DEL ALUMNO';

   footer.appendChild(nuevoElemento);


inputTextoIngresado.addEventListener('input', ()=>{

    const texto = inputTextoIngresado.value;

     titulo.textContent = texto || 'Países';
    // if(texto === ''){
    //      titulo.textContent = 'Países';
    // }else {
    //      titulo.textContent = texto 
    // }

});


colorSeleccionado.addEventListener('change', ()=>{
    fondo.classList.remove('rojo','verde','azul');
    fondo.classList.add(colorSeleccionado.value);
});


alineacionElegida.forEach((item) =>{
      
     item.addEventListener('change', () => {

         fondo.classList.remove('derecha','izquierda','centrado');
         fondo.classList.add(item.id);

     });

});

