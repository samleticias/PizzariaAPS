document.querySelector("#login-form button").addEventListener("click", async () => {
    const username = document.querySelector("#login-username").value;
    const password = document.querySelector("#login-password").value;

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
        const data = await response.json();
        localStorage.setItem("token", data.token);
        alert("Login realizado com sucesso!");
        window.location.href = "orders-list.html"; 
    } else {
        alert("Erro no login, verifique suas credenciais.");
    }
});