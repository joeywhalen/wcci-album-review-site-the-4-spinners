import { createHeader } from "./header.js";
import { createFooter } from "./footer.js";
import { allListJson } from "./sampleListJson.js";
import { createListBar } from "./listBar.js";

const container = document.querySelector(".container");
container.append(createHeader());
container.append(createListBar(allListJson));

// fetch("http://localhost:8080/api/lists")
//     .then(response => response.json())
//     .then(lists => createListBar(lists))
//     .then(listElement => listBar.appendChild(listElement))
//     .catch(error => console.log(error));

container.append(createFooter());
console.log("test");