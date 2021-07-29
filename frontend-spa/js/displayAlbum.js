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
    
    mainElement.appendChild(albumElement);
    return mainElement;
}
export{displayAlbum}