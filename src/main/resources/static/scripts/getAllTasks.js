function getAllTasks(){
    fetch('/tasks')
        .then(response => response.json())
        .then(data => {
            document.querySelector('#allTasks').innerHTML = data
                .map(element => `
                    <li class="list-group-item d-flex justify-content-between align-items-center py-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="task2">
                            <label class="form-check-label" for="task2">
                                ${element.title} - 
                                <span class="small text-muted">${element.description}<span>
                            </label>
                        </div>
                        <button type="button" class="btn btn-outline-success btn-sm">Remove</button>
                    </li>
                    `)
                .join('');
        }   )
}
