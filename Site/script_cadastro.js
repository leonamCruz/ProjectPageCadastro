const form = document.querySelector('form');
const nomeInput = document.querySelector('.name');
const emailInput = document.querySelector('#emailInput');
const senhaInput = document.querySelector('#senhaInput');
const sexoSelect = document.querySelector('#xexo');

form.addEventListener('submit', function (event) {
    event.preventDefault()
    const nome = nomeInput.value;
    const email = emailInput.value;
    const senha = senhaInput.value;
    const sexo = sexoSelect.value;
    const cidadao = {nome,email,senha,sexo}

    console.log(nome, email, senha, sexo)
    fetch('http://localhost:8080/pessoa', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify(cidadao)
    }).then(function (res) {
        console.log(res.status)
    })
})