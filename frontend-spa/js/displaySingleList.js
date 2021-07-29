import { clearChildren } from "./displayHome.js";
import { displayHome } from "./displayHome.js";
import { createListBar } from "./listBar.js";


const displaySingleList = function (list){
  const mainElement = document.querySelector(".main-content");  
  clearChildren (mainElement);
    list.albums.forEach((album) =>{
      let albumElement = document.createElement("section");
      albumElement.classList.add("btn-section");
      let albumNameElement = document.createElement("h3");
      albumNameElement.innerText = album.title;
      let albumLink = document.createElement("a");
      let albumImageURL = document.createElement("img");
      albumImageURL.src = album.imageURL; 
      albumLink.href = album.imageURL;
      albumLink.appendChild(albumImageURL);
      albumElement.appendChild(albumNameElement);
      albumElement.appendChild(albumLink);
      mainElement.appendChild(albumElement);
    });
    return mainElement;
}
export {displaySingleList}