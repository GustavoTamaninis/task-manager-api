document.addEventListener("DOMContentLoaded", () => {
    getAllTasks();
})

const btnSubmit = document.getElementById("btnSubmit");

btnSubmit.addEventListener("click", () => {
    createTask(btnSubmit)
});