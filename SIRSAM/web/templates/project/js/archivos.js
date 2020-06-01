function scriptLoad() {

    var h = window.innerHeight;
    var w = window.innerWidth;

    var iframe = document.getElementsByTagName("iframe")[0];

    iframe.style.height = h + "px";
    iframe.style.width = w + "px";
    iframe.style.overflow = "hidden";

}