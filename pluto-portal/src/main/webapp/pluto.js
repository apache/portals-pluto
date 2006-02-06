
toggleNavigation = function() {
    if (document.getElementById) {
        navigationRoot = document.getElementById("navigation");
        if (navigationRoot) {
            navigationList = navigationRoot.getElementsByTagName("ul")[0];
            if (navigationList) {
                navigationList.style.visibility = "hidden";
                navigationRoot.onmouseover = function() {
                    navigationList.style.visibility = "visible";
                }
                navigationRoot.onmouseout = function() {
                    navigationList.style.visibility = "hidden";
                }
            }
        }
    }
}

window.onload = toggleNavigation;



