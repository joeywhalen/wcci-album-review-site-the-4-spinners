import { createListBar } from "./listBar.js";

const displayHome = function(mainElement) {
    clearChildren(mainElement);
    mainElement.innerHTML = `<img src="/backend-api/src/main/resources/static/frontend-spa/images/Logo.png" alt="Desert Island Logo">`
    return mainElement;
}

const clearChildren = function(element){
    while(element.firstChild){
        element.removeChild(element.lastChild);
    }
};
export {displayHome, clearChildren};
