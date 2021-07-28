import { clearChildren } from "./displayHome.js";
import { displayHome } from "./displayHome.js";
import { createListBar } from "./listBar.js";


const displaySingleList = function (mainElement){
    clearChildren (mainElement);
    list.albums.forEach((album) =>{
      let albumElement = document.createdElement("section");
      albumElement.classList.add("btn-section");
      let albumNameElement = doucment.createdElement("h3");
      albumNameElement.innerText = album.title;
      let albumImage = document.createElement("div");
      albumImage.innerHTML = '<a href="' + album.imageURL + '"  alt="Album Art"></a>'
      albumElement.appendChild(albumNameElement);
      albumElement.appendChild(albumImage);
      mainElement.appendChild(albumElement);
    });
    return mainElement;
}
export {displaySingleList}