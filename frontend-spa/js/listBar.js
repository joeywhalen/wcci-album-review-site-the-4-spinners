import { displaySingleList } from "./displaySingleList.js";

const createListBar = function(lists){
    const listBar = document.createElement("div");
    listBar.classList.add("list-bar");
    const listBtns = document.createElement("div");
    listBtns.classList.add("list-btns");
    listBar.appendChild(listBtns);

    lists.forEach((list)=>{
        let listElement = document.createElement("section");
        listElement.classList.add("btn-section");
        let listNameElement = document.createElement("h2");
        listNameElement.innerText = list.listName;
        let listImage = document.createElement("div");
        listImage.innerHTML = `<img src="./images/Logo.png" alt="List logo"></img>`
        listImage.addEventListener("click", ()=>{
            displaySingleList(list)
        });
        listElement.appendChild(listNameElement);
        listElement.appendChild(listImage);
        listBar.appendChild(listElement);

    })

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

    listBar.prepend(form);
    // // listBar.appendChild(form);
    
    return listBar;
}
export {createListBar}







//  <div class="list-bar">
// <div id="logo-btns">
//     <section id="btn-section">
//     <img id="g-btn" src="/frontend-spa/images/Logo.png" alt="George's List logo"> [George logo]</section>


//     <section id="btn-section">
//     <img id="h-btn" src="/frontend-spa/images/Logo.png" alt="Harrison's List logo"> [Harrison logo]</section>
    

//     <section id="btn-section">
//     <img id="add-btn"src="/frontend-spa/images/Logo.png" alt="Add List logo">
//     [add your own list] </section>
    

//     <section id="btn-section">
//     <img id="j-btn" src="/frontend-spa/images/Logo.png" alt="Joey's List logo"> [Joey logo] </section>
    

//     <section id="btn-section">
//     <img id="n-btn" src="/frontend-spa/images/Logo.png" alt="Nana's List logo"> [Nana logo]</section>
// </div>
// </div> 