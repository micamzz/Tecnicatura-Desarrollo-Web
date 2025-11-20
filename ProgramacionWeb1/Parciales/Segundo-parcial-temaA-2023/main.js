
const colorSeleccionado = document.getElementById('color');
const fondo = document.querySelector('.vista');
const titulo = document.querySelector('.js-titulo');
const alineacion = document.getElementsByName('alineacion');

const universidadSeleccionada = document.getElementById('universidad');


universidadSeleccionada.addEventListener('change', () =>{

   const seleccionada = universidadSeleccionada.value;
   titulo.textContent =seleccionada;

});


colorSeleccionado.addEventListener('change', () =>{
 const colorElegido = colorSeleccionado.value;

 fondo.classList.remove('rojo', 'verde', 'azul');
 fondo.classList.add(colorElegido)
 
});

alineacion.forEach((item) =>{

    item.addEventListener('change', () => {
       
        titulo.classList.remove('gris','blanco','amarillo');
        titulo.classList.add(item.value);
      
    });

})