const titulo = document.querySelector('#titulo-unlam');

const inputUniversidad = document.querySelector('#uni');

const botonesSeleccionado = document.querySelectorAll('.boton');

const fondoArticle = document.querySelector('#datos-unlam');




inputUniversidad.addEventListener('input', ()=>{
       
   const textoIngresado = inputUniversidad.value;

   titulo.textContent = textoIngresado || 'UNLAM';

});


botonesSeleccionado.forEach(item =>{

    item.addEventListener('click', () =>{
     
      fondoArticle.classList.remove('violeta','naranja','celeste');
      fondoArticle.classList.add(item.id);

    });


});

