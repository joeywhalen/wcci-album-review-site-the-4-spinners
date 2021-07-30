import { displayAlbum } from "./displayAlbum.js";
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
      // albumLink.href = album.imageURL;
      albumLink.addEventListener("click", (clickEvent) => {
        displayAlbum(list, album)
      });
      albumLink.appendChild(albumImageURL);
      albumElement.appendChild(albumNameElement);
      albumElement.appendChild(albumLink);
      mainElement.appendChild(albumElement);
    });
  
  const form = document.createElement("form");
  form.classList.add("new-album-form");
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
  const ratingInput = document.createElement("input");
  ratingInput.classList.add("new-album-star-rating");
  ratingInput.setAttribute("type", "integer");
  ratingInput.setAttribute("placeholder", "Album Star Rating...");
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
  submitNewAlbumButton.innerText = "Submit New Album";
  const formattingElement = document.createElement('div');
  formattingElement.innerHTML = "<br><hr><br>";

  submitNewAlbumButton.addEventListener("click", (clickEvent) => {
    clickEvent.preventDefault();
    const albumElement = document.querySelector(".main-content");
    clearChildren(albumElement);
    const albumJson = {
      "title" : titleInput.value,
      "artist" : artistInput.value,
      "imageURL": imageURLInput.value,
      "recordLabel": recordLabelInput.value,
      "duration": durationInput.value,
      "rating": ratingInput.value,
      "videoUrl": videoUrlInput.value,
      "comments": [commentsInput.value]
    }
    fetch("http://localhost:8080/api/lists/" + list.id + "/albums", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(albumJson)
    })
      .then(response => response.json())
      .then(listResponse => displaySingleList(listResponse))
      .catch(error => console.log(error));

  })

  form.appendChild(titleInput);
  form.appendChild(artistInput);
  form.appendChild(imageURLInput);
  form.appendChild(recordLabelInput);
  form.appendChild(durationInput);
  form.appendChild(ratingInput);
  form.appendChild(videoUrlInput);
  form.appendChild(commentsInput);
  form.appendChild(submitNewAlbumButton);
  form.appendChild(formattingElement);

  mainElement.appendChild(form);

    return mainElement;
}
export {displaySingleList}