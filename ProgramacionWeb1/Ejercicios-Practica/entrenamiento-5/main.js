const formulario = document.querySelector('.js-formulario');
const inputUsuario = document.querySelector('#usuario');
const inputContrasenia = document.querySelector('#contrasenia');
const inputRepetirContrasenia = document.getElementById('repetir-contrasenia');
const botonCancelar = document.querySelector(".js-boton-cancelar");


// USUARIO
// CREAMOS EL P PARA DEBAJO DEL INPUT
const errorDeUsuario = document.createElement('p');
errorDeUsuario.classList.add('js-error-usuario'); // le agregamos una clase a ese p

errorDeUsuario.style.display = 'none';

const labelUsuario = document.querySelector('.js-label-usuario'); // Creamos la constante para que lo inserte despues del label
labelUsuario.insertAdjacentElement('afterend', errorDeUsuario);

// CONTRASEÑA
const errorDeContrasenia = document.createElement('p');
errorDeContrasenia.classList.add('js-error-contrasenia')
errorDeContrasenia.style.display = 'none';

const labelContrasenia = document.querySelector('.js-label-contrasenia');
labelContrasenia.insertAdjacentElement("afterend",errorDeContrasenia);

// REPETIR CONTRASENIA

const ErrorrepetirContrasenia = document.createElement('p');
ErrorrepetirContrasenia.classList.add('js-error-repetir-contrasenia');
ErrorrepetirContrasenia.style.display = 'none';

const labelRepetirContrasenia = document.querySelector('.js-label-repetir-contrasenia');
labelRepetirContrasenia.insertAdjacentElement("afterend",ErrorrepetirContrasenia);

// Accion PARA EL FORMULARIO 
formulario.addEventListener('submit', function (evento) { 
    evento.preventDefault();

    const esUsuarioValido =  validarUsuario();
    const esContraseniaValida =  validarContrasenia()
    const esRepetirContraseniaValida=  validarRepetirContrasenia();

     if(!esUsuarioValido || !esContraseniaValida || !esRepetirContraseniaValida){
        return;
     }

    window.location.href = 'bienvenida.html';
});



function validarUsuario() {
    const valorUsuario = inputUsuario.value.trim();
    console.log('Usuario ingresado:', valorUsuario);
    console.log('Cantidad de caracteres:', valorUsuario.length);

    errorDeUsuario.textContent = ""; // limpiamos si hay errores anteriores
    errorDeContrasenia.textContent = "";

    if (valorUsuario.length < 6 || valorUsuario.length > 8) {
        errorDeUsuario.textContent = "El usuario debe tener entre 6 y 8 caracteres";
        errorDeUsuario.style.display = 'block';
        return false;
    }

    return true;
}

function validarContrasenia() {
    const valorContrasenia = inputContrasenia.value.trim();
    errorDeContrasenia.textContent = "";

    if (valorContrasenia.length != 10) {
        errorDeContrasenia.textContent = "La contraseña debe tener  10 caracteres";
        errorDeContrasenia.style.display = 'block';
        return false;
    }

    const tieneLetra = /[a-zA-Z]/.test(valorContrasenia);
    const tieneNumero = /[0-9]/.test(valorContrasenia);
    const tieneEspecial = /[\*_\|\(\/\)]/.test(valorContrasenia);

    if (!tieneLetra || !tieneNumero || !tieneEspecial) {
        errorDeContrasenia.textContent = "La contraseña debe tener al menos, una letra,un numero y un caracter especial"
        errorDeContrasenia.style.display = 'block';
        return false;
    }

    return true;
}

function validarRepetirContrasenia(){
    const valorContrasenia = inputContrasenia.value.trim();
    const valorRepetirContrasenia = inputRepetirContrasenia.value.trim();

   ErrorrepetirContrasenia.textContent = "";
   ErrorrepetirContrasenia.style.display = 'none';

    if (valorContrasenia !== valorRepetirContrasenia) {
        ErrorrepetirContrasenia.textContent = "las contraseñas no coinciden";
       ErrorrepetirContrasenia.style.display = 'block';
       return false;
    }

    return true;
}


// BOTON DE CANCELAR EN EL FORMULARIO
botonCancelar.addEventListener('click',function(){

    //Para limpiar los mensajes de errores
    errorDeUsuario.textContent = "";  
    errorDeUsuario.style.display = 'none';

    errorDeContrasenia.textContent = "";
    errorDeContrasenia.style.display = 'none';

    ErrorrepetirContrasenia.textContent = " ";
    ErrorrepetirContrasenia.style.display = 'none';

})