import { clearChildren } from "./displayHome.js";

const displayAlbum = function (album){
    const mainElement = document.querySelector(".main-content");
    clearChildren(mainElement);
    const albumElement = document.createElement("div");
    const albumTitleElement = document.createElement("h3");
    albumTitleElement.innerText = album.title;
    const albumImageElement = document.createElement("img");
    albumImageElement.innerText = album.imageURL;
    const albumArtistElement = document.createElement("h4");
    albumArtistElement.innerText = album.artist;
    const recordLabelElement = document.createElement("p");
    recordLabelElement.innerText = album.recordLabel;
    const albumDurationElement = document.createElement("p");
    albumDurationElement.innerText = album.duration;
    const albumRatingElement = document.createElement("p");
    albumRatingElement.innerText = album.rating + "/5";
    const albumVideoElement = document.createElement("a");
    albumVideoElement.href = album.videoURL;

    albumElement.appendChild(albumTitleElement);
    albumElement.appendChild(albumImageElement);
    albumElement.appendChild(albumArtistElement);
    albumElement.appendChild(recordLabelElement);
    albumElement.appendChild(albumDurationElement);
    albumElement.appendChild(albumRatingElement);
    albumElement.appendChild(albumVideoElement);    
    
    album.songs.forEach((song)=>{
        let songElement = document.createElement("section");
        songElement.classList.add("song-btn-section");
        let songNameElement= document.createElement("h5");
        songNameElement.innerText = song.songTitle;
        songElement.appendChild(songNameElement);
        albumElement.appendChild(songElement);
    });

    const form = document.createElement("form");
    form.classList.add("new-song-form");
    const albumTitleInput = document.createElement("input");
    albumTitleInput.classList.add("attach-album-name");
    albumTitleInput.setAttribute("type", "text");
    albumTitleInput.setAttribute("placeholder", "Which Album?...");
    const songTitleInput = document.createElement("input");
    songTitleInput.classList.add("new-song-title");
    songTitleInput.setAttribute("type", "text");
    songTitleInput.setAttribute("placeholder", "Title of Song...");
    const lengthInput = document.createElement("input");
    lengthInput.classList.add("new-song-length");
    lengthInput.setAttribute("type", "text");
    lengthInput.setAttribute("placeholder", "Song Length...");
    const starRatingInput = document.createElement("input");
    starRatingInput.classList.add("new-song-star-rating");
    starRatingInput.setAttribute("type", "integer");
    starRatingInput.setAttribute("placeholder", "Song Star Rating...");
    const commentsInput = document.createElement("input");
    commentsInput.classList.add("new-song-comments");
    commentsInput.setAttribute("type", "text");
    commentsInput.setAttribute("placeholder", "Song Comment...");

    const submitNewSongButton = document.createElement("button");
    submitNewSongButton.classList.add("submit-new-song");
    submitNewSongButton.innerText = "Submit New Song";
    const formattingElement = document.createElement('div');
    formattingElement.innerHTML = "<br><hr><br>";

    
    
    mainElement.appendChild(albumElement);
    return mainElement;
}
export{displayAlbum}