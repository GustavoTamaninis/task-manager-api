btnSubmit = document.getElementById("btn-submit");

btnSubmit.addEventListener("DOMContentLoaded", () => {
    fetch('/tasks')
        .then(response => response.json())
        .then(data => {
            lastId = data[data.length - 1].id;

        })
})