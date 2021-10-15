import { createFooter } from "./footer.js";
import { createListBar } from "./listBar.js";
import { displayHome } from "./displayHome.js";


const container = document.querySelector(".container");

await fetch("/api/lists")
    .then(response => response.json())
    .then(lists => container.appendChild(createListBar(lists)))
    .catch(error => console.log(error));

const mainElement = document.createElement("main");
mainElement.classList.add("main-content");

container.appendChild(displayHome(mainElement));

container.append(createFooter());
console.log("test");