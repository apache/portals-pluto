    startList = function() {
      if (document.all && document.getElementById) {
        navRoot = document.getElementById("navigation");
        for (i=0; i<navRoot.childNodes.length; i++) {
          for(j=0; j<navRoot.childNodes[i].childNodes.length; j++) {
            node = navRoot.childNodes[i].childNodes[j];
            if (node.nodeName=="LI") {
              node.onmouseover=function() { this.className+=" over"; }
              node.onmouseout=function() { this.className=this.className.replace(" over", ""); }
            }
          }
        }
      }
    }
    window.onload=startList;
