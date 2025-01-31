document.getElementById("endereco-cep").addEventListener("input", function (e) {
    let cep = e.target.value.replace(/\D/g, "").slice(0, 8);
    if (cep.length > 5) {
        cep = `${cep.slice(0, 5)}-${cep.slice(5)}`;
    }
    e.target.value = cep;
});

document.getElementById("cliente-telefone").addEventListener("input", function (e) {
    let tel = e.target.value.replace(/\D/g, "").slice(0, 11);
    if (tel.length > 10) {
        tel = `(${tel.slice(0, 2)}) ${tel.slice(2, 7)}-${tel.slice(7)}`;
    } else if (tel.length > 6) {
        tel = `(${tel.slice(0, 2)}) ${tel.slice(2, 6)}-${tel.slice(6)}`;
    } else if (tel.length > 2) {
        tel = `(${tel.slice(0, 2)}) ${tel.slice(2)}`;
    } else if (tel.length > 0) {
        tel = `(${tel}`;
    }
    e.target.value = tel;
});