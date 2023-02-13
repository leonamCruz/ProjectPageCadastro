const formulario = document.querySelector("form")
const _nome = document.querySelector(".name")
const _email = document.querySelector(".email")
const _senha = document.querySelector(".senha")
const _sexo = document.querySelector('input[name=sexo]:checked')

formulario.addEventListener('submit',function (event){
    event.preventDefault()
    cadastro()
})

function cadastro(){

    const cidadao = {
        nome: _nome.value,
        email: _email.value,
        senha: _senha.value,
        sexo: _sexo || "Não informado"
    }

    fetch('http://localhost:8080/pessoa', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify(cidadao)
    }).then(function(res){console.log(res)})
}
function limpar(){
        _nome.value ="",
        _email.value="",
        _senha.value="",
        _sexo.checked = false
}