const form = document.querySelector('form');
const email = document.querySelector('#emailL')
const password = document.querySelector('#senhaL')
form.addEventListener('submit', function (event) {
    event.preventDefault()
    const e_mail = email.value
    const s_enha = password.value
    const cidadao = {e_mail, s_enha}

    console.log(e_mail,s_enha)
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify(cidadao)
    }).then(function (res) {
        console.log(res.status)
    })
})