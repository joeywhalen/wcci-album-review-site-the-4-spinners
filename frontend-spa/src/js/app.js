import { createHeader } from "./header.js"
import { createFooter } from "./footer.js"

const container = document.querySelector(".container");
container.append(createHeader());
container.append(createFooter());
