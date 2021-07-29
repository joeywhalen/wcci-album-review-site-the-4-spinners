const createHeader = function(){
    const header = document.createElement("header");    
    const navigation = document.createElement("nav");
    navigation.classList.add("nav");
    const navButtons = document.createElement("ul");
    navButtons.classList.add("nav-btns");
    navButtons.innerHTML = `<button>Home</button>
                 <button>About Us</button> 
                 <button>Back Page</button>`
    
    const homeButton = document.createElement("button");
    homeButton.classList.add("home-navigation");
    homeButton.innerText = "Home";

    homeButton.addEventListener("click", () => {
        mainElement.appendChild(displayHome(allListJson));
    })

    const title = document.createElement("div");
    title.classList.add("title");
    //  <!-- <img src="/frontend-spa/images/Logo.png" alt=""> -->
    title.innerHTML = `<h1>Welcome to Desert Island Jukebox</h1>`
    
    
    navigation.appendChild(navButtons);
    navButtons.appendChild(homeButton);
    header.appendChild(navigation);
    header.appendChild(title);
    return header;
}
export {createHeader}



// <header>
//  <nav class="nav">
//         <ul id="nav-btns">
//             <button>Home</button>
//             <button>About Us</button> 
//             <button>Back Page</button>
//         </ul>
//  </nav>

//  <div class="title">       
//  <!-- <img src="/frontend-spa/images/Logo.png" alt=""> -->
//  <h1>Welcome to Desert Island Jukebox</h1>
//  </div>
// </header>
