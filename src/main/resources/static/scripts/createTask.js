function createTask(btn) {
    const inputTaskTitle = document.querySelector("#inputTaskTitle");
    const inputTaskDescription = document.querySelector("#inputTaskDescription");
    let taskTitle = inputTaskTitle.value.trim();
    let taskDescription = inputTaskDescription.value.trim();

    const showFlashError = (message) => {
        const form = btn.closest("form");
        if (!form) {
            return;
        }

        const existingFlash = form.querySelector(".task-flash-error");
        if (existingFlash) {
            existingFlash.remove();
        }

        const flash = document.createElement("div");
        flash.className = "alert alert-danger task-flash-error mb-3";
        flash.setAttribute("role", "alert");
        flash.textContent = message;

        form.prepend(flash);

        setTimeout(() => {
            flash.remove();
        }, 2500);
    };

    if (taskTitle === "") {
        showFlashError("Enter the task title.");
        inputTaskTitle.focus();
        return;
    }

    const payLoad = {
        title: taskTitle,
        description: taskDescription
    }

    fetch('/tasks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payLoad)
    })

        .then(response => {
            if (!response.ok) throw new Error('Erro ao criar tarefa'); // cobras casos de erro 400 e 500
            return response.json();
        })
        .then(() => {
            inputTaskTitle.value = '';
            inputTaskDescription.value = '';
            getAllTasks();
        })
        .catch(() => {
            showFlashError('Não foi possível criar a tarefa.');
        });
}