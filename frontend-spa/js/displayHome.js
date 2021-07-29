

const displayHome = function(mainElement) {
    clearChildren(mainElement);
    mainElement.innerHTML = `<img src="/frontend-spa/images/Logo.png" alt="Desert Island Logo">`
    // mainElement.appendChild();

const form = document.createElement("form");
    form.classList.add("new-list-form");
    const listNameInput = document.createElement("input");
    listNameInput.classList.add("new-list-name");
    listNameInput.setAttribute("type", "text");
    listNameInput.setAttribute("placeholder", "Name your list...");

    const submitNewListButton = document.createElement("button");
    submitNewListButton.classList.add("submit-new-list");
    submitNewListButton.innerText = "Submit New List";
    const formattingElement = document.createElement('div');
    formattingElement.innerHTML = "<br><hr><br>";

    submitNewListButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        const listJson = {
            "listName" : listNameInput.value
        }
        fetch("http://localhost:8080/api/lists", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(listJson)
        })
        .then(response => response.json())
        .then(lists => container.appendChild(createListBar(lists)))
        .catch(error => console.log(error));
    })

    form.appendChild(listNameInput);
    form.appendChild(submitNewListButton);
    form.appendChild(formattingElement);

    mainElement.prepend(form);
    // mainElement.appendChild(form);

    return mainElement;
}

const clearChildren = function(element){
    while(element.firstChild){
        element.removeChild(element.lastChild);
    }
};
export {displayHome, clearChildren};
