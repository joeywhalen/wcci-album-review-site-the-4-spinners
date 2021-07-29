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
  
  const form = document.createElement("form");
  form.classList.add("new-album-form");
  const listInput = document.createElement("input");
  listInput.classList.add("attach-list-name");
  listInput.setAttribute("type", "text");
  listInput.setAttribute("placeholder", "Which List?...");
  const titleInput = document.createElement("input");
  titleInput.classList.add("new-album-title");
  titleInput.setAttribute("type", "text");
  titleInput.setAttribute("placeholder", "Title of Album...");
  const artistInput = document.createElement("input");
  artistInput.classList.add("new-album-artist");
  artistInput.setAttribute("type", "text");
  artistInput.setAttribute("placeholder", "Album Artist...");
  const imageURLInput = document.createElement("input");
  imageURLInput.classList.add("new-album-cover-image");
  imageURLInput.setAttribute("type", "text");
  imageURLInput.setAttribute("placeholder", "Album Cover Image URL...");
  const recordLabelInput = document.createElement("input");
  recordLabelInput.classList.add("new-album-record-label");
  recordLabelInput.setAttribute("type", "text");
  recordLabelInput.setAttribute("placeholder", "Album Record Label...");
  const durationInput = document.createElement("input");
  durationInput.classList.add("new-album-duration");
  durationInput.setAttribute("type", "text");
  durationInput.setAttribute("placeholder", "Album Duration...");
  const starRatingInput = document.createElement("input");
  starRatingInput.classList.add("new-album-star-rating");
  starRatingInput.setAttribute("type", "integer");
  starRatingInput.setAttribute("placeholder", "Album Star Rating...");
  const videoUrlInput = document.createElement("input");
  videoUrlInput.classList.add("new-album-video-URL");
  videoUrlInput.setAttribute("type", "text");
  videoUrlInput.setAttribute("placeholder", "Album Video URL...");
  const commentsInput = document.createElement("input");
  commentsInput.classList.add("new-album-comments");
  commentsInput.setAttribute("type", "text");
  commentsInput.setAttribute("placeholder", "Album Comment...");

  const submitNewAlbumButton = document.createElement("button");
  submitNewAlbumButton.classList.add("submit-new-album");
  submitNewAlbum.innerText = "Submit New Album";
  const formattingElement = document.createElement('div');
  formattingElement.innerHTML = "<br><hr><br>";

  


    return mainElement;
}
export {displaySingleList}