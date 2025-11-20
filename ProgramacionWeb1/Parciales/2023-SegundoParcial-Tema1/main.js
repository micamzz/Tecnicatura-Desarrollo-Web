const titulo = document.querySelector('.js-titulo-curso');

const cursoSeleccionado = document.getElementsByName('curso');

const fondo = document.querySelector('.vista');

const colorSeleccionado = document.getElementById('color');

const colorFondoSeleccionado = document.getElementsByName('color-fondo');


cursoSeleccionado.forEach(item =>{

    item.addEventListener('change', ()=>{
        
        titulo.textContent = item.value;
    });

});


colorSeleccionado.addEventListener('change', () =>{
    
    const colorElegido = colorSeleccionado.value;

    titulo.classList.remove('rojo','azul','verde');
    titulo.classList.add(colorElegido);


});


colorFondoSeleccionado.forEach(item  =>{
    
    item.addEventListener('change', () =>{
    fondo.classList.remove('verde2','violeta','naranja');
    fondo.classList.add(item.id);

    });

});


