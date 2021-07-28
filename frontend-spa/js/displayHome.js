

const displayHome = function(mainElement) {
    clearChildren(mainElement);
    mainElement.innerHTML = `<img src="/frontend-spa/images/Logo.png" alt="Desert Island Logo">`
    // mainElement.appendChild();
    return mainElement;
   
   
}
const clearChildren = function(element){
    while(element.firstChild){
        element.removeChild(element.lastChild);
    }
};
export {displayHome, clearChildren};
