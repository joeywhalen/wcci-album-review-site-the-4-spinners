import { clearChildren, displayHome } from "./displayHome.js";
import { displaySingleList } from "./displaySingleList.js";
import { createFooter } from "./footer.js";

const createListBar = function (lists) {
    const container = document.querySelector(".container");
    const header = document.createElement("header");
    const navigation = document.createElement("nav");
    navigation.classList.add("nav");
    const navButtons = document.createElement("ul");
    navButtons.classList.add("nav-btns");
    // navButtons.innerHTML = `<button>About Us</button>`

    const homeButton = document.createElement("button");
    homeButton.innerText = "Home";
    homeButton.addEventListener("click", () => {
        const mainElement = document.querySelector("main");
        clearChildren(mainElement);
        displayHome(mainElement);
        console.log("Clicked Home button");
    });

    const jawPortfolioButton = document.createElement("button");
    jawPortfolioButton.innerText = "About Joey";
    jawPortfolioButton.addEventListener("click", () => {
        const jawTab = window.open('https://joeywhalen.github.io/ProfessionalPortfolio', '_blank');  
    });

    const nanaPortfolioButton = document.createElement("button");
    nanaPortfolioButton.innerText = "About Nana";
    nanaPortfolioButton.addEventListener("click", () => {
        const nanaTab = window.open('', '_blank');
    });

    const harrisonPortfolioButton = document.createElement("button");
    harrisonPortfolioButton.innerText = "About Harrison";
    harrisonPortfolioButton.addEventListener("click", () => {
        const harrisonTab = window.open('https://hewiggins.github.io/', '_blank');
    });

    const georgePortfolioButton = document.createElement("button");
    georgePortfolioButton.innerText = "About George";
    georgePortfolioButton.addEventListener("click", () => {
        const georgeTab = window.open('https://georgefought.github.io/', '_blank');
    })

    const title = document.createElement("div");
    title.classList.add("title");
    title.innerHTML = `<h2>Welcome to <br></h2> <h1>Desert Island Jukebox</h1>`

    const listBar = document.createElement("div");
    listBar.classList.add("list-bar");
    const listBtns = document.createElement("div");
    listBtns.classList.add("list-btns");
    listBar.appendChild(listBtns);

    lists.forEach((list) => {
        let listElement = document.createElement("section");
        listElement.classList.add("btn-section");
        let listNameElement = document.createElement("h2");
        listNameElement.innerText = list.listName;
        let listImage = document.createElement("div");
        listImage.innerHTML = `<img src="./images/RecordLogo.png" alt="List logo"></img>`
        listImage.addEventListener("click", () => {
            clearChildren(header);
                fetch("http://localhost:8080/api/lists")
                    .then(response => response.json())
                    .then(lists => container.prepend(createListBar(lists)))
                    .catch(error => console.log(error));
            displaySingleList(list);
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

    submitNewListButton.addEventListener("click", (clickEvent) => {
        clickEvent.preventDefault();
        clearChildren(header);
        const listJson = {
            "listName": listNameInput.value
        }
        fetch("http://localhost:8080/api/lists", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(listJson)
        })
            .then(response => response.json())
            .then(lists => container.prepend(createListBar(lists)))
            .catch(error => console.log(error));
    })

    form.appendChild(listNameInput);
    form.appendChild(submitNewListButton);
    form.appendChild(formattingElement);

    listBar.prepend(form);
    navigation.appendChild(navButtons);
    navButtons.appendChild(homeButton);
    navButtons.appendChild(jawPortfolioButton);
    navButtons.appendChild(nanaPortfolioButton);
    navButtons.appendChild(harrisonPortfolioButton);
    navButtons.appendChild(georgePortfolioButton);
    header.appendChild(navigation);
    header.appendChild(title);
    header.appendChild(listBar);

    return header;
}
export { createListBar }







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