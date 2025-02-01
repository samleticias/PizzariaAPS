// document.querySelector("button").addEventListener("click", async () => {
//     const username = document.getElementById("register-username").value;
//     const password = document.getElementById("register-password").value;

//     try {
//         const response = await fetch("http://localhost:8080/auth/register", {
//             method: "POST",
//             headers: {
//                 "Content-Type": "application/json"
//             },
//             body: JSON.stringify({ username, password })
//         });

//         if (!response.ok) {
//             throw new Error(`Erro HTTP! Status: ${response.status}`);
//         }

//         const data = await response.json();
//         console.log("Resposta do servidor:", data);
//         alert("Cadastro realizado com sucesso!");
//     } catch (error) {
//         console.error("Erro na requisição:", error);
//     }
// });

document.querySelector("button").addEventListener("click", async () => {
    const username = document.getElementById("register-username").value;
    const password = document.getElementById("register-password").value;

    try {
        const response = await fetch("http://localhost:8080/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || `Erro HTTP! Status: ${response.status}`);
        }

        const data = await response.json();
        console.log("Resposta do servidor:", data);
        alert("Cadastro realizado com sucesso!");
    } catch (error) {
        console.error("Erro na requisição:", error);
        alert(error.message);  // Exibe a mensagem de erro para o usuário
    }
});